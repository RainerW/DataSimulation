package de.bitnoise.datasim.model;

import de.bitnoise.datasim.UniqeID;

public class BaseSimulatorModel implements SimulatorModel {

	protected ModelState fCurrentState = ModelState.UNDEFINED;

	private String uniqueID = UniqeID.generateAsString();

	protected void setModelState(ModelState newState) {
		fCurrentState = newState;
	}

	public ModelState getModelState() {
		return fCurrentState;
	}

	public String getUniqeID() {
		return uniqueID;
	}

}
