package de.bitnoise.datasim.input;

import java.util.Date;

public interface SimulatorTimedEvent extends SimulatorEvent {
	Date getOccuranceTime();
}
