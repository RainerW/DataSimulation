package de.bitnoise.datasim.ui;

import de.bitnoise.datasim.model.SimulatorModel;

public interface SimulatorModelListener {
	void eventSimulatorModelChanged(SimulatorModel changedModel);
}
