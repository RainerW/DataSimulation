package de.bitnoise.datasim;

import java.util.List;

import de.bitnoise.datasim.input.SimulatorEvent;
import de.bitnoise.datasim.model.SimulatorModel;

public interface SimulatorController {
	boolean addModel(SimulatorModel... modelItemToAdd);

	boolean addModel(List<SimulatorModel> modelItemToAdd);

	boolean addEvent(SimulatorEvent... eventToExceut);

	boolean addEvent(List<SimulatorEvent> eventToExceut);
}