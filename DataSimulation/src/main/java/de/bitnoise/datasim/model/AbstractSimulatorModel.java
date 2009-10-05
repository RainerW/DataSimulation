package de.bitnoise.datasim.model;

import java.util.ArrayList;
import java.util.List;

import de.bitnoise.datasim.ui.SimulatorEventDetailListener;
import de.bitnoise.datasim.ui.SimulatorModelListener;
import de.bitnoise.datasim.util.UniqeID;

public class AbstractSimulatorModel implements SimulatorModel {

	protected ModelState fCurrentState = ModelState.UNDEFINED;

	private Long uniqueID = UniqeID.generate();

	private List<SimulatorModelListener> modelListener = new ArrayList<SimulatorModelListener>();

	private String fDetail = "";

	protected void setModelState(ModelState newState) {
		fCurrentState = newState;
	}

	public ModelState getModelState() {
		return fCurrentState;
	}

	public Long getUniqeID() {
		return uniqueID;
	}

	public boolean addModelListener(SimulatorModelListener listener) {
		return modelListener.add(listener);
	}

	protected void notifyModelChange(SimulatorModel changedModel) {
		for (SimulatorModelListener listener : modelListener) {
			listener.eventSimulatorModelChanged(changedModel);
		}
	}

	protected void setDetails(String detail) {
		fDetail = detail;
	}

	public String getDetails() {
		return fDetail;
	}

	public boolean removeListener(SimulatorModelListener listener) {
		return modelListener.remove(listener);
	}

}
