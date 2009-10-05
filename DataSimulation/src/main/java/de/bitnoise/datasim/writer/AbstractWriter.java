package de.bitnoise.datasim.writer;

import java.util.List;

import de.bitnoise.datasim.events.SimulatorEvent;

public abstract class AbstractWriter implements SimulatorWriter
{
  public boolean canHandle(Class<?> type)
  {
    for (Class<?> allowed : canHandleEventsOfSubclass())
    {
      try
      {
        type.asSubclass(allowed);
        return true;
      }
      catch (ClassCastException cce)
      {
      }
    }
    return false;
  }

  public void write(SimulatorEvent event)
  {
    try
    {
      writeSafe(event);
    }
    catch (Exception e)
    {
      e.printStackTrace();
    }
  }

  abstract protected void writeSafe(SimulatorEvent event) throws Exception;

  abstract protected Class<?>[] canHandleEventsOfSubclass();

}
