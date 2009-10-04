package de.bitnoise.datasim;

import java.util.List;

import de.bitnoise.datasim.gui.adapter.EventTable;
import de.bitnoise.datasim.input.SimulatorEvent;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventListener;

public interface SimulatorController {
	boolean addModel(SimulatorModel... modelItemToAdd);

	boolean addModel(List<SimulatorModel> modelItemToAdd);

	boolean addEvent(SimulatorEvent... eventToExceut);

	boolean addEvent(List<SimulatorEvent> eventToExceut);
	
}
