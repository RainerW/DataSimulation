package de.bitnoise.datasim.sample;

import java.util.HashMap;
import java.util.Map;

import de.bitnoise.datasim.input.SimulatorEvent;
import de.bitnoise.datasim.model.BaseSimulatorModel;
import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;

public class Businesscase extends BaseSimulatorModel implements SimulatorModel {

	int eventCount = 0;

	public Businesscase() {
		setModelState(ModelState.RUNNING);
	}

	public void written(BusinesscaseEvent businesscaseEvent) {
		eventCount--;
		if (eventCount == 0) {
			setModelState(ModelState.OK);
		}

	}

	public void addEvent(String string, BusinesscaseEvent eventToExceut) {
		eventCount++;
	}

}
