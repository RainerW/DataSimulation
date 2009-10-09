package de.bitnoise.datasim.controller;

import static org.junit.Assert.*;

import org.junit.Test;

public class DefaultControllerTest
{
  DefaultController sut = new DefaultController();

  @Test
  public void testTransformTicksPerMinuteToSleepTime() throws Exception
  {
    assertEquals(60 * 1000, sut.transformTicksPerMinuteToSleepTime(1));
    assertEquals(1000, sut.transformTicksPerMinuteToSleepTime(60));
    assertEquals(500, sut.transformTicksPerMinuteToSleepTime(120));
    assertEquals(250, sut.transformTicksPerMinuteToSleepTime(240));
  }
}
