package de.bitnoise.datasim.tracker;

import java.util.Date;

import de.bitnoise.datasim.controller.SimulatorController;

public interface SimulatorTracker
{

  void processTracker(SimulatorController defaultController, Date now);
  
}
