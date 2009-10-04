package de.bitnoise.datasim.sample;

import java.util.Date;

import de.bitnoise.datasim.input.DefaultEvent;
import de.bitnoise.datasim.input.SimulatorTimedEvent;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventListener;
import de.bitnoise.datasim.writer.SimulatorWriter;

public class BusinesscaseEvent extends DefaultEvent implements
		SimulatorTimedEvent {

	private Date fTime;

	private Businesscase myBC;

	protected static int uniqueID = 1;

	public BusinesscaseEvent(Businesscase bc, Date executionTime, String details) {
		super(bc, details);
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

	public boolean writeTo(SimulatorWriter writer) {
		myBC.written(this);
		return true;
	}

	public String getType() {
		return "DB-Notification";
	}

}
