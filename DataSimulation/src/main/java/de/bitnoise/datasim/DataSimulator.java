/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bitnoise.datasim;

import de.bitnoise.datasim.gui.SimulatorFrame;
import de.bitnoise.datasim.input.SimulatorInput;
import de.bitnoise.datasim.writer.SimulatorWriter;

public class DataSimulator {

	SimulatorControllerProvider controller = new DefaultController();

	public void runSimulation(boolean gui) {
		SimulatorFrame frame = null;
		if (gui) {
			frame = new SimulatorFrame();
			frame.showMainFrame(controller);
		}
		controller.start();
		while (controller.isRunning()) {

		}
	}

	public void stop() {
		controller.stop();
	}

	public void registerInput(SimulatorInput intputToRegister) {
		controller.registerInput(intputToRegister);
	}

	public void registerWriter(SimulatorWriter writerToRegister) {
		controller.registerWriteR(writerToRegister);
	}

}
