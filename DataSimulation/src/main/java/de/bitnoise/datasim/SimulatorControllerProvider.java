package de.bitnoise.datasim;

import java.util.Date;
import java.util.List;

import de.bitnoise.datasim.input.SimulatorEvent;

public interface SimulatorControllerProvider extends SimulatorController {

	void processEvents();

	List<SimulatorEvent> getEventsList(Date currentTime);

	void printState();

}
