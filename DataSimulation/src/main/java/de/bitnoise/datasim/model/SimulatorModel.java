package de.bitnoise.datasim.model;

import java.util.List;

import de.bitnoise.datasim.controller.DefaultController;
import de.bitnoise.datasim.events.SimulatorEvent;
import de.bitnoise.datasim.ui.SimulatorEventDetailListener;
import de.bitnoise.datasim.ui.SimulatorModelListener;
import de.bitnoise.datasim.ui.adapter.ModelTable;

public interface SimulatorModel extends ModelDetail
{
  Long getUniqeID();

  boolean addModelListener(SimulatorModelListener listener);

  boolean removeListener(SimulatorModelListener listener);

  List<ModelDetail> getModelDetails();

  public void setEventFinalSuccess(SimulatorEvent event);

  public void setEventFinalError(SimulatorEvent event);

}
