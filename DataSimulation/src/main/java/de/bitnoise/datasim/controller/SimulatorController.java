package de.bitnoise.datasim.controller;

import java.util.List;

import de.bitnoise.datasim.events.SimulatorEvent;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventListener;
import de.bitnoise.datasim.ui.adapter.EventTable;

public interface SimulatorController {
	boolean addModel(SimulatorModel... modelItemToAdd);

	boolean addModel(List<SimulatorModel> modelItemToAdd);

	boolean addEvent(SimulatorEvent... eventToExceut);

	boolean addEvent(List<SimulatorEvent> eventToExceut);
	
}
