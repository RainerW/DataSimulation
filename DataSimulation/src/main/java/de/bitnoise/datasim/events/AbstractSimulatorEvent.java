package de.bitnoise.datasim.events;

import java.util.ArrayList;
import java.util.List;

import de.bitnoise.datasim.model.NoModelDefined;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventListener;
import de.bitnoise.datasim.writer.SimulatorWriter;

public abstract class AbstractSimulatorEvent implements SimulatorEvent
{

  protected List<SimulatorEventListener> eventListeners = new ArrayList<SimulatorEventListener>();

  protected SimulatorModel trackingModel = new NoModelDefined();

  protected String fDetails;

  public AbstractSimulatorEvent(SimulatorModel model, String details)
  {
    if (model != null)
    {
      trackingModel = model;
    }
    if (details != null)
    {
      fDetails = details;
    }
  }

  public void addEventListener(SimulatorEventListener listener)
  {
    eventListeners.add(listener);
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

  public boolean writeTo(SimulatorWriter writer)
  {
    return true;
  }
  
  public Class<?> getOutputWriterType()
  {
    return getClass();
  }
}
