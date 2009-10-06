/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bitnoise.datasim;

import javax.swing.plaf.SliderUI;

import de.bitnoise.datasim.command.SimulatorCommand;
import de.bitnoise.datasim.controller.DefaultController;
import de.bitnoise.datasim.controller.SimulatorControllerProvider;
import de.bitnoise.datasim.generator.SimulatorGenerator;
import de.bitnoise.datasim.tracker.SimulatorTracker;
import de.bitnoise.datasim.ui.gui.SimulatorFrame;

public class DataSimulator {

	SimulatorControllerProvider controller = new DefaultController();

	public void runSimulation(boolean gui) {
		SimulatorFrame frame = null;
		if (gui) {
			frame = new SimulatorFrame();
			frame.showMainFrame(controller);
		}
		controller.start(gui);
	}

	public void stop() {
		controller.stop();
	}

	public void registerGenerator(SimulatorGenerator generatorToRegister) {
		controller.registerGenerator(generatorToRegister);
	}

	public void registerTracker(SimulatorTracker trackerToRegister) {
	  controller.registerTracker(trackerToRegister);
	}

  public void registerCommand(SimulatorCommand cleanDatabaseCommand)
  {
    controller.registerCommand(cleanDatabaseCommand);
  }

}
