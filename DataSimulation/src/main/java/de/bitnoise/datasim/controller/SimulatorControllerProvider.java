package de.bitnoise.datasim.controller;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import de.bitnoise.datasim.events.SimulatorEvent;
import de.bitnoise.datasim.generator.SimulatorInput;
import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventListener;
import de.bitnoise.datasim.ui.SimulatorModelListener;
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

	void registerEventListener(SimulatorEventListener modelListener);

	void registerModelListener(SimulatorModelListener modelListener);

	List<SimulatorEvent> getEventsList();

	List<SimulatorModel> getModelList(ModelState...filter);

}
