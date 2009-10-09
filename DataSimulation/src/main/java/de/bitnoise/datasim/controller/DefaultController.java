package de.bitnoise.datasim.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

import de.bitnoise.datasim.command.SimulatorCommand;
import de.bitnoise.datasim.events.SimulatorEvent;
import de.bitnoise.datasim.events.SimulatorTimedEvent;
import de.bitnoise.datasim.generator.SimulatorGenerator;
import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.tracker.SimulatorTracker;
import de.bitnoise.datasim.ui.SimulatorEventListener;
import de.bitnoise.datasim.ui.SimulatorModelListener;
import de.bitnoise.datasim.util.MemoryDumper;
import de.bitnoise.datasim.util.SortedList;

public class DefaultController implements SimulatorControllerProvider,
    Runnable, SimulatorModelListener, SimulatorEventListener
{

  List<SimulatorGenerator> inputs = new ArrayList<SimulatorGenerator>();

  boolean isRunning = true;

  List<SimulatorEvent> events = new ArrayList<SimulatorEvent>();

  SortedList<SimulatorTimedEvent> timedEvents =
      new SortedList<SimulatorTimedEvent>(new TimedEventComparator());

  List<SimulatorModel> models = new ArrayList<SimulatorModel>();

  private boolean shutdownRequest = false;

  private EnumMap<ModelState, List<SimulatorModel>> modelsByState =
      new EnumMap<ModelState, List<SimulatorModel>>(ModelState.class);

  private int sleeptime = 1000;

  public DefaultController()
  {
    for (ModelState state : ModelState.values())
    {
      modelsByState.put(state, new ArrayList<SimulatorModel>());
    }
  }

  public boolean addEvent(SimulatorEvent... eventToExecute)
  {
    if (eventToExecute == null)
    {
      return false;
    }
    for (SimulatorEvent event : eventToExecute)
    {
      if (event instanceof SimulatorTimedEvent)
      {
        timedEvents.add((SimulatorTimedEvent) event);
      }
      else
      {
        events.add(event);
      }
      event.addEventListener(this);
    }
    return false;
  }

  static protected class TimedEventComparator implements
      Comparator<SimulatorTimedEvent>
  {

    public int compare(SimulatorTimedEvent o1, SimulatorTimedEvent o2)
    {
      return o1.getOccuranceTime().compareTo(o2.getOccuranceTime());
    }
  }

  public boolean addEvent(List<SimulatorEvent> eventToExceut)
  {
    if (eventToExceut == null)
    {
      return false;
    }
    return addEvent(eventToExceut.toArray(new SimulatorEvent[] {}));
  }

  public boolean addModel(SimulatorModel... modelItemToAdd)
  {
    if (modelItemToAdd == null)
    {
      return false;
    }
    dirtyModel = true;
    synchronized (models)
    {
      for (SimulatorModel model : modelItemToAdd)
      {
        models.add(0, model);
        model.addModelListener(this);
      }
    }
    return false;
  }

  public boolean addModel(List<SimulatorModel> modelItemToAdd)
  {
    if (modelItemToAdd == null)
    {
      return false;
    }
    return addModel(modelItemToAdd.toArray(new SimulatorModel[] {}));
  }

  public void processEvents()
  {

  }

  public List<SimulatorEvent> getEventsList(Date currentTime)
  {
    List<SimulatorEvent> result = new ArrayList<SimulatorEvent>();
    result = events;
    events = new ArrayList<SimulatorEvent>();

    for (Iterator<SimulatorTimedEvent> iter = timedEvents.iterator(); iter
        .hasNext();)
    {
      SimulatorTimedEvent event = iter.next();
      if (event.getOccuranceTime().before(currentTime))
      {
        iter.remove();
        result.add(event);
      }
    }
    return result;
  }

  public void printState()
  {
    int c = 0;
    for (SimulatorModel model : models)
    {
      if (model.getModelState() != ModelState.OK)
      {

        System.out.println("" + model.getUniqeID() + "\t"
            + model.getModelState());
      }
      else
      {
        c++;
      }
    }
    System.out.println("ok = " + c);

  }

  public void writeEvents(Date now)
  {
    List<SimulatorEvent> events = getEventsList(now);
    for (SimulatorEvent event : events)
    {
      if (event.execute(this))
      {
        event.removeEventListener(this);
      }
    }
  }

  // private SimulatorWriter findWriter(SimulatorEvent event)
  // {
  // Class<?> type = event.getOutputWriterType();
  //
  // SimulatorWriter result = writerHash.get(type);
  // if (result != null)
  // {
  // return result;
  // }
  //
  // for (SimulatorWriter writer : writers)
  // {
  // if (writer.canHandle(type))
  // {
  // writerHash.put(type, writer);
  // return writer;
  // }
  // }
  // throw new
  // IllegalStateException("Unable to find Writer for type : " +
  // type);
  // }

  public void createEvents(Date now)
  {
    for (SimulatorGenerator input : inputs)
    {
      input.createNextEvent(this, now);
    }
  }

  public void registerGenerator(SimulatorGenerator intputToRegister)
  {
    if (intputToRegister == null)
    {
      throw new IllegalArgumentException("intputToRegister cannot be null");
    }
    intputToRegister.registerSimulatorController(this);
    inputs.add(intputToRegister);
  }

  public boolean isRunning()
  {
    return isRunning;
  }

  public void start(boolean waitUntilStoped)
  {
    isRunning = true;
    shutdownRequest = false;
    new Thread(this).start();
    if (waitUntilStoped)
    {
      while (isRunning())
      {
        sleep(10);
      }
    }
  }

  public void stop()
  {
    System.out.println("Shutdown request");
    shutdownRequest = true;
  }

  public void run()
  {
    try
    {
      MemoryDumper md = new MemoryDumper("d:\\var\\memory.txt", 120);
      while (isRunning)
      {
        Date now = new Date();
        writeEvents(now);
        processTrackers(now);
        if (shutdownRequest)
        {
          if (events.size() == 0 && timedEvents.size() == 0)
          {
            System.out.println("Shutting down");
            isRunning = false;
          }
        }
        else
        {
          if (!pauseCreation)
          {
            createEvents(now);
          }
        }
        notifyEventsChanged();

        sleep(sleeptime);
        md.dump();
      }
    }
    finally
    {
      isRunning = false;
    }
  }

  private void processTrackers(Date now)
  {
    for (SimulatorTracker tracker : trackers)
    {
      tracker.processTracker(this, now);
    }
  }

  private void sleep(int i)
  {
    try
    {
      Thread.sleep(i);
    }
    catch (InterruptedException e)
    {
      throw new RuntimeException(e);
    }
  }

  List<SimulatorEventListener> eventsListeners =
      new ArrayList<SimulatorEventListener>();

  private List<SimulatorModelListener> modelsListener =
      new ArrayList<SimulatorModelListener>();

  private List<SimulatorModel> lastResult;

  private boolean dirtyModel = true;

  private ModelState[] lastfilter;

  private boolean pauseCreation = true;

  private List<SimulatorTracker> trackers = new ArrayList<SimulatorTracker>();

  private SimulatorCommand resetCommand;

  public void registerEventListener(SimulatorEventListener modelListener)
  {
    eventsListeners.add(modelListener);
  }

  public void registerModelListener(SimulatorModelListener listener)
  {
    modelsListener.add(listener);
  }

  private void notifyEventsChanged()
  {
    for (SimulatorEventListener listener : eventsListeners)
    {
      listener.eventSimulatorEventChanged();
    }
  }

  private void notifyModelsChanged(SimulatorModel changedModel)
  {
    for (SimulatorModelListener listener : modelsListener)
    {
      listener.eventSimulatorModelChanged(changedModel);
    }

  }

  public List<SimulatorEvent> getEventsList()
  {
    List<SimulatorEvent> result = new ArrayList<SimulatorEvent>();
    result.addAll(events);
    result.addAll(timedEvents);
    return result;
  }

  public void eventSimulatorEventChanged()
  {
    notifyEventsChanged();
  }

  public void eventSimulatorModelChanged(SimulatorModel changedModel)
  {
    dirtyModel = true;
    notifyModelsChanged(changedModel);
    synchronized (models)
    {
      if (changedModel.getModelState() == ModelState.OK)
      {
        changedModel.removeListener(this);
        models.remove(changedModel);
      }
    }
  }

  protected List<SimulatorModel> getModelList()
  {
    synchronized (models)
    {
      return models;
    }
  }

  public List<SimulatorModel> getModelList(ModelState... filter)
  {
    if (lastfilter == filter && !dirtyModel)
    {
      return lastResult;
    }
    if (filter == null || filter.length == 0)
    {
      return getModelList();
    }
    EnumSet<ModelState> filterSet = EnumSet.of(filter[0], filter);
    List<SimulatorModel> result = new ArrayList<SimulatorModel>();
    synchronized (models)
    {
      for (SimulatorModel model : getModelList())
      {
        ModelState state = model.getModelState();
        if (filterSet.contains(state))
        {
          result.add(model);
        }
      }
    }
    dirtyModel = false;
    lastfilter = filter;
    lastResult = result;
    return result;
  }

  public void pause(boolean pause)
  {
    pauseCreation = pause;
  }

  public void registerTracker(SimulatorTracker trackerToRegister)
  {
    trackers.add(trackerToRegister);
  }

  public void executeResetEvent()
  {
    resetCommand.execute(this);
  }

  public void registerCommand(SimulatorCommand command)
  {
    resetCommand = command;
  }

  public void setEventsPerSecond(int value)
  {
    sleeptime = transformTicksPerMinuteToSleepTime(value);
    // System.out.println("value = " + value + " sleeptime=" +
    // sleeptime);
  }

  protected int transformTicksPerMinuteToSleepTime(int value)
  {
    int oneMinute = 1000 * 60;
    return oneMinute / value;
  }

}
