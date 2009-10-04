package de.bitnoise.datasim.sample;

import java.util.Date;

import de.bitnoise.datasim.input.SimulatorTimedEvent;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.writer.SimulatorWriter;

public class BusinesscaseEvent implements SimulatorTimedEvent {

	private Date fTime;

	private Businesscase myBC;

	private String fDetails = "";

	protected static int uniqueID = 1;

	public BusinesscaseEvent(Businesscase bc, Date executionTime, String details) {
		fTime = executionTime;
		myBC = bc;
		if (details != null) {
			fDetails = details;
		}
	}

	public Class<?> getOutputWriterType() {
		return DatabaseWriter.class;
	}

	public Object getPayload() {
		return ++uniqueID;
	}

	public Date getOccuranceTime() {
		return fTime;
	}

	public boolean writeTo(SimulatorWriter writer) {
		myBC.written(this);
		return true;
	}

	public SimulatorModel getTrackingModel() {
		return myBC;
	}

	public String getDetails() {
		return "New Notification ( " + fDetails + ") ID = " + uniqueID;
	}

}
