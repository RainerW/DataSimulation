package de.bitnoise.datasim.sample;

import java.util.Date;

import de.bitnoise.datasim.controller.SimulatorController;
import de.bitnoise.datasim.events.AbstractSimulatorEvent;
import de.bitnoise.datasim.events.SimulatorTimedEvent;
import de.bitnoise.datasim.model.SimulatorModel;
import de.bitnoise.datasim.ui.SimulatorEventListener;

public class BusinesscaseEvent extends AbstractSimulatorEvent implements
    SimulatorTimedEvent
{

  private Businesscase myBC;

  protected static int uniqueID = 1;

  public BusinesscaseEvent(Businesscase bc, Date executionTime, String details)
  {
    super(bc, details, executionTime);
    myBC = bc;
  }

  public Class<?> getOutputWriterType()
  {
    return DatabaseWriter.class;
  }

  public Object getPayload()
  {
    return ++uniqueID;
  }

  public void execute(SimulatorController controller)
  {
    new DatabaseWriter().write(this);
    myBC.written(this);
  }

  public String getType()
  {
    return "DB-Notification";
  }

}
