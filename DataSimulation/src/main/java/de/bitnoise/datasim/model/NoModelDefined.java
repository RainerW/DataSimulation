package de.bitnoise.datasim.model;

import de.bitnoise.datasim.ui.SimulatorModelListener;

public class NoModelDefined implements SimulatorModel {

	public boolean addModelListener(SimulatorModelListener listener) {
		return false;
	}

	public ModelState getModelState() {
		return ModelState.UNDEFINED;
	}

	public Long getUniqeID() {
		return 0L;
	}

	public String getDetails() {
		return "";
	}

	public boolean removeListener(SimulatorModelListener listener) {
		return false;
	}

}
