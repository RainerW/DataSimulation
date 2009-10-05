package de.bitnoise.datasim.writer;

import de.bitnoise.datasim.events.SimulatorEvent;

public interface SimulatorWriter
{

  boolean canHandle(Class<?> type);

  void write(SimulatorEvent event);

}
