package de.bitnoise.datasim.model;

import java.util.ArrayList;
import java.util.List;

import de.bitnoise.datasim.UniqeID;
import de.bitnoise.datasim.ui.SimulatorEventDetailListener;

public class BaseSimulatorModel implements SimulatorModel {

	protected ModelState fCurrentState = ModelState.UNDEFINED;

	private String uniqueID = UniqeID.generateAsString();

	private List<SimulatorEventDetailListener> modelListener = new ArrayList<SimulatorEventDetailListener>();

	protected void setModelState(ModelState newState) {
		fCurrentState = newState;
	}

	public ModelState getModelState() {
		return fCurrentState;
	}

	public String getUniqeID() {
		return uniqueID;
	}

	public void addModelListener(SimulatorEventDetailListener listener) {
		modelListener.add(listener);
	}

	protected void notifyModelChange() {
		for (SimulatorEventDetailListener listener : modelListener) {
			listener.eventSimulatorEventChanged();
		}
	}

}
