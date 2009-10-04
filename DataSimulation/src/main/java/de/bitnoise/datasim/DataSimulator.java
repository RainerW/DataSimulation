/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package de.bitnoise.datasim;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.istack.internal.NotNull;

import de.bitnoise.datasim.input.SimulatorEvent;
import de.bitnoise.datasim.input.SimulatorInput;
import de.bitnoise.datasim.writer.SimulatorWriter;

/**
 * 
 * @author rainer
 */
public class DataSimulator {

	SimulatorControllerProvider controller = new DefaultController();

	List<SimulatorInput> inputs = new ArrayList<SimulatorInput>();

	List<SimulatorWriter> writers = new ArrayList<SimulatorWriter>();

	Map<Class<?>, SimulatorWriter> writerHash = new HashMap<Class<?>, SimulatorWriter>();

	public void runSimulation() {

		while (true) {
			Date now = new Date();
			controller.processEvents();

			List<SimulatorEvent> events = controller.getEventsList(now);
			for (SimulatorEvent event : events) {
				SimulatorWriter writer = findWriter(event);
				if (event.writeTo(writer)) {
					writer.write(event);
				}
			}

			for (SimulatorInput input : inputs) {
				input.createNextEvent(controller, now);
			}

			controller.printState();
			
			sleep(1000);
		}

	}

	private SimulatorWriter findWriter(SimulatorEvent event) {
		Class<?> type = event.getOutputWriterType();

		SimulatorWriter result = writerHash.get(type);
		if (result != null) {
			return result;
		}

		for (SimulatorWriter writer : writers) {
			if (writer.canHandle(type)) {
				writerHash.put(type, writer);
				return writer;
			}
		}
		throw new IllegalStateException("Unable to find Writer for type : "
				+ type);
	}

	private void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	public void registerInput(SimulatorInput intputToRegister) {
		if (intputToRegister == null) {
			throw new IllegalArgumentException(
					"intputToRegister cannot be null");
		}

		intputToRegister.registerSimulatorController(controller);
		inputs.add(intputToRegister);
	}

	public void registerWriter(SimulatorWriter writerToRegister) {
		writers.add(writerToRegister);
	}

}
