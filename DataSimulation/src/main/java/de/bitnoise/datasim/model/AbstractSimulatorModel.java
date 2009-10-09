package de.bitnoise.datasim.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import de.bitnoise.datasim.events.SimulatorEvent;
import de.bitnoise.datasim.ui.SimulatorEventDetailListener;
import de.bitnoise.datasim.ui.SimulatorModelListener;
import de.bitnoise.datasim.util.UniqeID;

public class AbstractSimulatorModel implements SimulatorModel
{

  protected ModelState fCurrentState = ModelState.RUNNING;

  private Long uniqueID = UniqeID.generate();

  private List<SimulatorModelListener> modelListener =
      new ArrayList<SimulatorModelListener>();

  private String fDetail = "";

  protected Map<SimulatorEvent, SimpleModelDetails> internalState =
      new HashMap<SimulatorEvent, SimpleModelDetails>();

  protected List<ModelDetail> details = new ArrayList<ModelDetail>();

  protected void setModelState(ModelState newState)
  {
    fCurrentState = newState;
  }

  public ModelState getModelState()
  {
    return fCurrentState;
  }

  public Long getUniqeID()
  {
    return uniqueID;
  }

  public boolean addModelListener(SimulatorModelListener listener)
  {
    return modelListener.add(listener);
  }

  protected void notifyModelChange(SimulatorModel changedModel)
  {
    ArrayList<SimulatorModelListener> temp =
        new ArrayList<SimulatorModelListener>();
    temp.addAll(modelListener);
    for (SimulatorModelListener listener : temp)
    {
      listener.eventSimulatorModelChanged(changedModel);
    }
  }

  protected void setDetails(String detail)
  {
    fDetail = detail;
  }

  public String getDetails()
  {
    return fDetail;
  }

  public boolean removeListener(SimulatorModelListener listener)
  {
    return modelListener.remove(listener);
  }

  public void addRequiredEvent(SimulatorEvent event, String detail)
  {
    SimpleModelDetails state = new SimpleModelDetails(detail);
    internalState.put(event, state);
    details.add(state);
  }

  public void setEventFinalSuccess(SimulatorEvent event, String appendDetails)
  {
    setEventState(event, ModelState.OK, appendDetails);
  }

  public void setEventFinalError(SimulatorEvent event, String appendDetails)
  {
    setEventState(event, ModelState.ERROR, appendDetails);
  }

  public void setEventFinalSuccess(SimulatorEvent event)
  {
    setEventState(event, ModelState.OK, null);
  }

  public void setEventFinalError(SimulatorEvent event)
  {
    setEventState(event, ModelState.ERROR, null);
  }

  public void setEventState(SimulatorEvent event, ModelState newState,
      String appendDetail)
  {
    SimpleModelDetails state = internalState.get(event);
    if (state != null)
    {
      state.setState(newState);
      if (appendDetail != null)
      {
        state.setDetail(" " + state.getDetails() + appendDetail);
      }
      updateState();
    }
  }

  private void updateState()
  {
    int max = details.size();
    int notOkCount = max;
    boolean isOk = true;
    String latest = null;
    for (ModelDetail detail : details)
    {
      ModelState state = detail.getModelState();
      if (state == ModelState.ERROR || state == ModelState.FAIL)
      {
        setModelState(state);
        isOk = false;
        break;
      }
      if (state == ModelState.RUNNING || state == ModelState.UNDEFINED
          || state == ModelState.WARING)
      {
        isOk = false;
      }
      if (state == ModelState.OK)
      {
        notOkCount--;
      }
      if (latest == null)
      {
        latest = detail.getDetails();
      }
    }
    if (isOk)
    {
      setModelState(ModelState.OK);
    }
    setDetails("[" + notOkCount + "/" + max + "] " + latest);

    notifyModelChange(this);
  }

  public List<ModelDetail> getModelDetails()
  {
    return details;
  }

}