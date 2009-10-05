package de.bitnoise.datasim.sample;

import de.bitnoise.datasim.events.SimulatorEvent;
import de.bitnoise.datasim.writer.SimulatorWriter;

public class DatabaseWriter implements SimulatorWriter {

	public boolean canHandle(Class<?> type) {
		try {
			type.asSubclass(DatabaseWriter.class);
		} catch (ClassCastException cce) {
			return false;
		}
		return true;
	}

	public void write(SimulatorEvent event) {
		System.out.println("Writing : " + event);
	}

}
