package de.bitnoise.datasim.events;

import java.util.Date;

public interface SimulatorTimedEvent extends SimulatorEvent {
	Date getOccuranceTime();
}
