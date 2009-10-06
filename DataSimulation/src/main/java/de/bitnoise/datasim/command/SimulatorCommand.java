package de.bitnoise.datasim.command;

import de.bitnoise.datasim.controller.SimulatorController;

public interface SimulatorCommand
{
  public void execute(SimulatorController controller);
}
