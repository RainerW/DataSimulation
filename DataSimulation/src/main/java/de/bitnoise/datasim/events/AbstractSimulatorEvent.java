package de.bitnoise.datasim.events;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import de.bitnoise.datasim.controller.SimulatorController;
import de.bitnoise.datasim.model.NoModelDefined;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventListener;

public abstract class AbstractSimulatorEvent implements SimulatorTimedEvent
{

  protected List<SimulatorEventListener> eventListeners =
      new ArrayList<SimulatorEventListener>();

  protected SimulatorModel trackingModel = new NoModelDefined();

  protected String fDetails;

  private Date fOccuranceTime;

  public AbstractSimulatorEvent(SimulatorModel model, String details,
      Date occurance)
  {
    if (model != null)
    {
      trackingModel = model;
    }
    if (details != null)
    {
      fDetails = details;
    }
    fOccuranceTime = occurance;
  }

  public boolean execute(SimulatorController controller)
  {
    try
    {
      boolean result = executeSafe(controller);
      if (result)
      {
        getTrackingModel().setEventFinalSuccess(this);
      }
      else
      {
        getTrackingModel().setEventFinalError(this);
      }
      return result;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      getTrackingModel().setEventFinalError(this);
      return false;
    }
  }

  abstract protected boolean executeSafe(SimulatorController controller)
      throws Exception;

  public void addEventListener(SimulatorEventListener listener)
  {
    eventListeners.add(listener);
  }

  public void removeEventListener(SimulatorEventListener listener)
  {
    eventListeners.remove(listener);
  }

  public String getDetails()
  {
    return fDetails;
  }

  protected void setTrackingModel(SimulatorModel model)
  {
    trackingModel = model;
  }

  public SimulatorModel getTrackingModel()
  {
    return trackingModel;
  }

  public Date getOccuranceTime()
  {
    return fOccuranceTime;
  }

  public String getType()
  {
    return "event " + getClass().getSimpleName();
  }
}
