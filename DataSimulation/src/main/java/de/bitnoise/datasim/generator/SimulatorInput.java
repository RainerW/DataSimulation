package de.bitnoise.datasim.generator;

import java.util.Date;

import de.bitnoise.datasim.SimulatorPlug;
import de.bitnoise.datasim.controller.SimulatorController;

public interface SimulatorInput extends SimulatorPlug {

	void registerSimulatorController(SimulatorController controller);

	void simulationStart();

	void simulationPause(boolean pause);

	void simulationStop();

	void createNextEvent(SimulatorController controller, Date now);
}
