package de.bitnoise.datasim.controller;

import java.util.Date;
import java.util.EnumSet;
import java.util.List;

import de.bitnoise.datasim.command.SimulatorCommand;
import de.bitnoise.datasim.events.SimulatorEvent;
import de.bitnoise.datasim.generator.SimulatorGenerator;
import de.bitnoise.datasim.model.ModelState;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.tracker.SimulatorTracker;
import de.bitnoise.datasim.ui.SimulatorEventListener;
import de.bitnoise.datasim.ui.SimulatorModelListener;

public interface SimulatorControllerProvider extends SimulatorController {

	void processEvents();

	List<SimulatorEvent> getEventsList(Date currentTime);

	void printState();

	void writeEvents(Date now);

	void createEvents(Date now);

	void registerGenerator(SimulatorGenerator intputToRegister);

	void stop();

	boolean isRunning();

	void registerEventListener(SimulatorEventListener modelListener);

	void registerModelListener(SimulatorModelListener modelListener);
	
	void registerCommand(SimulatorCommand command);

	void registerTracker(SimulatorTracker trackerToRegister);
	
	List<SimulatorEvent> getEventsList();

	List<SimulatorModel> getModelList(ModelState...filter);

  void start(boolean waitUntilStoped);

  void pause(boolean pause);

  void executeResetEvent();

}
