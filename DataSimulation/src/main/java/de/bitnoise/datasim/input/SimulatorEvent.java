package de.bitnoise.datasim.input;

import de.bitnoise.datasim.writer.SimulatorWriter;

public interface SimulatorEvent {
	Class<?> getOutputWriterType();
	
	Object getPayload();
	
	boolean writeTo(SimulatorWriter writer);
}
