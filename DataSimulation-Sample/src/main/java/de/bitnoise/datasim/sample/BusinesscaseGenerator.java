package de.bitnoise.datasim.sample;

import java.util.Date;
import java.util.Random;

import de.bitnoise.datasim.controller.SimulatorController;
import de.bitnoise.datasim.events.SimulatorEvent;
import de.bitnoise.datasim.generator.AbstractSimulatorInput;
import de.bitnoise.datasim.generator.SimulatorInput;

public class BusinesscaseGenerator extends AbstractSimulatorInput implements SimulatorInput {

	Random rnd = new Random();
	int id = 0;

	private SimulatorController fController;

	public String getPlugName() {
		return getClass().getName();
	}

	public long getPlugVersion() {
		return 0;
	}

	public void registerSimulatorController(SimulatorController controller) {
		fController = controller;
	}

	public void createNextEvent(SimulatorController controller, Date now) {
		if (rnd.nextBoolean()) {
			System.out.println("Create Event : " + id);
			
			Businesscase bc = new Businesscase();
			controller.addModel( bc );
			
			{
				Date time = new Date(now.getTime() + 10);
				BusinesscaseEvent eventToExceut = new BusinesscaseEvent(bc,time,"Activation 1/3");
				controller.addEvent(eventToExceut);
				bc.addEvent("Message 1 ",eventToExceut);
			}

			{
				Date time = new Date(now.getTime() + rnd.nextInt(5000));
				BusinesscaseEvent eventToExceut = new BusinesscaseEvent(bc,time,"Activation 2/3");
				controller.addEvent(eventToExceut);
				bc.addEvent("Message 2 :",eventToExceut);
			}
			
			{
				Date time = new Date(now.getTime() + rnd.nextInt(5000));
				BusinesscaseEvent eventToExceut = new BusinesscaseEvent(bc,time,"Activation 3/3");
				controller.addEvent(eventToExceut);
				bc.addEvent("Message 2 :",eventToExceut);
			}
		}
	}

	public void simulationPause(boolean pause) {
	}

	public void simulationStart() {
	}

	public void simulationStop() {
	}

}
