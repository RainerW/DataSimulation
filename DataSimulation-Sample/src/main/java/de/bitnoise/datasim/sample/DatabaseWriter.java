package de.bitnoise.datasim.sample;

import de.bitnoise.datasim.events.SimulatorEvent;

public class DatabaseWriter
{


  public void write(SimulatorEvent event)
  {
    System.out.println("Writing : " + event);
  }

}
