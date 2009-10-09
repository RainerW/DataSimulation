package de.bitnoise.datasim.events;

import de.bitnoise.datasim.controller.DefaultController;
import de.bitnoise.datasim.controller.SimulatorController;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventListener;

public interface SimulatorEvent {

	String getType();

	SimulatorModel getTrackingModel();

	String getDetails();

	void addEventListener(SimulatorEventListener listener);
	
	void removeEventListener(SimulatorEventListener listener);

  boolean execute(SimulatorController controller);
}
