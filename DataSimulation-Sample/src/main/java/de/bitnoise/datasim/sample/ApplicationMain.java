package de.bitnoise.datasim.sample;

import de.bitnoise.datasim.DataSimulator;

/**
 */
public class ApplicationMain
{

  public static void main(String[] args)
  {
    DataSimulator sim = new DataSimulator();

    BusinesscaseGenerator businesscaseGenerator = new BusinesscaseGenerator();

    sim.registerGenerator(businesscaseGenerator);
    
    sim.runSimulation(true);
  }
}
