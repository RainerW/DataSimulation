package de.bitnoise.datasim.model;

import de.bitnoise.datasim.DefaultController;
import de.bitnoise.datasim.ui.SimulatorEventDetailListener;

public interface SimulatorModel {
	ModelState getModelState();

	String getUniqeID();

	void addModelListener(SimulatorEventDetailListener defaultController);

}
