package de.bitnoise.datasim.model;

import de.bitnoise.datasim.controller.DefaultController;
import de.bitnoise.datasim.ui.SimulatorEventDetailListener;
import de.bitnoise.datasim.ui.SimulatorModelListener;
import de.bitnoise.datasim.ui.adapter.ModelTable;

public interface SimulatorModel {
	ModelState getModelState();

	Long getUniqeID();

	boolean addModelListener(SimulatorModelListener listener);

	String getDetails();

	boolean removeListener(SimulatorModelListener listener);

}
