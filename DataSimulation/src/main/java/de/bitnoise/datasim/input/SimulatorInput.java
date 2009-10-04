package de.bitnoise.datasim.input;

import java.util.Date;

import de.bitnoise.datasim.SimulatorController;
import de.bitnoise.datasim.SimulatorPlug;

public interface SimulatorInput extends SimulatorPlug {

	void registerSimulatorController(SimulatorController controller);

	void simulationStart();

	void simulationPause(boolean pause);

	void simulationStop();

	void createNextEvent(SimulatorController controller, Date now);
}
