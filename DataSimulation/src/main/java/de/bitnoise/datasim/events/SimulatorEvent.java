package de.bitnoise.datasim.events;

import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventListener;
import de.bitnoise.datasim.writer.SimulatorWriter;

public interface SimulatorEvent {
	Class<?> getOutputWriterType();

	String getType();

	boolean writeTo(SimulatorWriter writer);

	SimulatorModel getTrackingModel();

	String getDetails();

	void addEventListener(SimulatorEventListener listener);
}
