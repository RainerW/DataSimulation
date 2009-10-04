package de.bitnoise.datasim.model;

import de.bitnoise.datasim.DefaultController;
import de.bitnoise.datasim.gui.adapter.ModelTable;
import de.bitnoise.datasim.ui.SimulatorEventDetailListener;
import de.bitnoise.datasim.ui.SimulatorModelListener;

public interface SimulatorModel {
	ModelState getModelState();

	String getUniqeID();

	boolean addModelListener(SimulatorModelListener listener);

	String getDetails();

	boolean removeListener(SimulatorModelListener listener);

}
