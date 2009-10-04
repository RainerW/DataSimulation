package de.bitnoise.datasim;

/**
 */
public class ApplicationMain
{

  public static void main(String[] args)
  {
    DataSimulator sim = new DataSimulator();

    BusinesscaseGenerator businesscaseGenerator = new BusinesscaseGenerator();

    sim.registerInput(businesscaseGenerator);

    sim.runSimulation();
  }
}
