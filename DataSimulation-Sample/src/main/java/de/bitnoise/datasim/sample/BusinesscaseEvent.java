package de.bitnoise.datasim.sample;

import java.util.Date;

import de.bitnoise.datasim.input.SimulatorTimedEvent;
import de.bitnoise.datasim.writer.SimulatorWriter;

public class BusinesscaseEvent implements SimulatorTimedEvent {

	private Date fTime;

	private Businesscase myBC;

	protected static int uniqueID = 1;

	public BusinesscaseEvent(Businesscase bc, Date executionTime) {
		fTime = executionTime;
		myBC = bc;
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

	@Override
	public String toString() {
		return "Event " + uniqueID + ":" + fTime.toGMTString();
	}

	public boolean writeTo(SimulatorWriter writer) {
		myBC.written(this);
		return true;
	}

}
