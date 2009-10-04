package de.bitnoise.datasim;

import java.util.Date;
import java.util.List;

import de.bitnoise.datasim.input.SimulatorEvent;
import de.bitnoise.datasim.input.SimulatorInput;
import de.bitnoise.datasim.ui.SimulatorEventListener;
import de.bitnoise.datasim.writer.SimulatorWriter;

public interface SimulatorControllerProvider extends SimulatorController {

	void processEvents();

	List<SimulatorEvent> getEventsList(Date currentTime);

	void printState();

	void writeEvents(Date now);

	void createEvents(Date now);

	void registerInput(SimulatorInput intputToRegister);

	void registerWriteR(SimulatorWriter writerToRegister);

	void stop();

	void start();

	boolean isRunning();
	
	void registerModelListener(SimulatorEventListener modelListener);

	List<SimulatorEvent> getEventsList();
	
}
