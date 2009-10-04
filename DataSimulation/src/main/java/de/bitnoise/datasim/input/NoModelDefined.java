package de.bitnoise.datasim.input;

import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorModelListener;

public class NoModelDefined implements SimulatorModel {

	public boolean addModelListener(SimulatorModelListener listener) {
		return false;
	}

	public ModelState getModelState() {
		return ModelState.UNDEFINED;
	}

	public String getUniqeID() {
		return "-";
	}

	public String getDetails() {
		return "";
	}

	public boolean removeListener(SimulatorModelListener listener) {
		return false;
	}

}
