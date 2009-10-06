package de.bitnoise.datasim.generator;

import java.util.Date;

import de.bitnoise.datasim.controller.SimulatorController;

public abstract class AbstractSimulatorGenerator implements SimulatorGenerator
{

  protected SimulatorController fController;
  protected boolean fSimBause = false;

  public void createNextEvent(SimulatorController controller, Date now)
  {
  }

  public void registerSimulatorController(SimulatorController controller)
  {
    fController = controller;
  }

  public void simulationPause(boolean pause)
  {
    fSimBause =pause;
  }

  public void simulationStart()
  {
  }

  public void simulationStop()
  {
  }

}
