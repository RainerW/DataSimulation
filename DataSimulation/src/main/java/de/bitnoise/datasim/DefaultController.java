package de.bitnoise.datasim;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import de.bitnoise.datasim.input.SimulatorEvent;
import de.bitnoise.datasim.input.SimulatorInput;
import de.bitnoise.datasim.input.SimulatorTimedEvent;
import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventDetailListener;
import de.bitnoise.datasim.ui.SimulatorEventListener;
import de.bitnoise.datasim.writer.SimulatorWriter;

public class DefaultController implements SimulatorControllerProvider,
		Runnable, SimulatorEventDetailListener {

	List<SimulatorInput> inputs = new ArrayList<SimulatorInput>();

	List<SimulatorWriter> writers = new ArrayList<SimulatorWriter>();

	Map<Class<?>, SimulatorWriter> writerHash = new HashMap<Class<?>, SimulatorWriter>();

	boolean isRunning = true;

	List<SimulatorEvent> events = new ArrayList<SimulatorEvent>();
	SortedList<SimulatorTimedEvent> timedEvents = new SortedList<SimulatorTimedEvent>(
			new TimedEventComparator());

	List<SimulatorModel> models = new ArrayList<SimulatorModel>();

	private boolean shutdownRequest = false;

	public boolean addEvent(SimulatorEvent... eventToExecute) {
		if (eventToExecute == null) {
			return false;
		}
		for (SimulatorEvent event : eventToExecute) {
			if (event instanceof SimulatorTimedEvent) {
				timedEvents.add((SimulatorTimedEvent) event);
			} else {
				events.add(event);
			}
		}
		return false;
	}

	static protected class TimedEventComparator implements
			Comparator<SimulatorTimedEvent> {

		public int compare(SimulatorTimedEvent o1, SimulatorTimedEvent o2) {
			return o1.getOccuranceTime().compareTo(o2.getOccuranceTime());
		}
	}

	public boolean addEvent(List<SimulatorEvent> eventToExceut) {
		if (eventToExceut == null) {
			return false;
		}
		return addEvent(eventToExceut.toArray(new SimulatorEvent[] {}));
	}

	public boolean addModel(SimulatorModel... modelItemToAdd) {
		if (modelItemToAdd == null) {
			return false;
		}
		for (SimulatorModel model : modelItemToAdd) {
			models.add(model);
			model.addModelListener(this);
		}
		return false;
	}

	public boolean addModel(List<SimulatorModel> modelItemToAdd) {
		if (modelItemToAdd == null) {
			return false;
		}
		return addModel(modelItemToAdd.toArray(new SimulatorModel[] {}));
	}

	public void processEvents() {

	}

	public List<SimulatorEvent> getEventsList(Date currentTime) {
		List<SimulatorEvent> result = new ArrayList<SimulatorEvent>();
		result = events;
		events = new ArrayList<SimulatorEvent>();

		for (Iterator<SimulatorTimedEvent> iter = timedEvents.iterator(); iter
				.hasNext();) {
			SimulatorTimedEvent event = iter.next();
			if (event.getOccuranceTime().before(currentTime)) {
				iter.remove();
				result.add(event);
			}
		}
		return result;
	}

	public void printState() {
		int c = 0;
		for (SimulatorModel model : models) {
			if (model.getModelState() != ModelState.OK) {

				System.out.println("" + model.getUniqeID() + "\t"
						+ model.getModelState());
			} else {
				c++;
			}
		}
		System.out.println("ok = " + c);

	}

	public void writeEvents(Date now) {
		List<SimulatorEvent> events = getEventsList(now);
		for (SimulatorEvent event : events) {
			SimulatorWriter writer = findWriter(event);
			if (event.writeTo(writer)) {
				writer.write(event);
			}
		}
	}

	private SimulatorWriter findWriter(SimulatorEvent event) {
		Class<?> type = event.getOutputWriterType();

		SimulatorWriter result = writerHash.get(type);
		if (result != null) {
			return result;
		}

		for (SimulatorWriter writer : writers) {
			if (writer.canHandle(type)) {
				writerHash.put(type, writer);
				return writer;
			}
		}
		throw new IllegalStateException("Unable to find Writer for type : "
				+ type);
	}

	public void createEvents(Date now) {
		for (SimulatorInput input : inputs) {
			input.createNextEvent(this, now);
		}
	}

	public void registerInput(SimulatorInput intputToRegister) {
		if (intputToRegister == null) {
			throw new IllegalArgumentException(
					"intputToRegister cannot be null");
		}
		intputToRegister.registerSimulatorController(this);
		inputs.add(intputToRegister);
	}

	public void registerWriteR(SimulatorWriter writerToRegister) {
		writers.add(writerToRegister);
	}

	public boolean isRunning() {
		return isRunning;
	}

	public void start() {
		isRunning = true;
		shutdownRequest = false;
		new Thread(this).start();
	}

	public void stop() {
		System.out.println("Shutdown request");
		shutdownRequest = true;
	}

	public void run() {
		try {
			while (isRunning) {
				Date now = new Date();
				processEvents();
				writeEvents(now);
				if (shutdownRequest) {
					if (events.size() == 0 && timedEvents.size() == 0) {
						System.out.println("Shutting down");
						isRunning = false;
					}
				} else {
					createEvents(now);
				}
				notifyEventsChanged();
				printState();

				sleep(1000);
			}
		} finally {
			isRunning = false;
		}
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	List<SimulatorEventListener> eventsListeners = new ArrayList<SimulatorEventListener>();

	public void registerModelListener(SimulatorEventListener modelListener) {
		eventsListeners.add(modelListener);
	}

	private void notifyEventsChanged() {
		for (SimulatorEventListener listener : eventsListeners) {
			listener.eventSimulatorEventChanged();
		}
	}

	public List<SimulatorEvent> getEventsList() {
		List<SimulatorEvent> result = new ArrayList<SimulatorEvent>();
		result.addAll(events);
		result.addAll(timedEvents);
		return result;
	}

	public void eventSimulatorEventChanged() {
		notifyEventsChanged();
	}

}
