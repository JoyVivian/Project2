package test.utilsTest;


import battle.utils.RealRandom;

import static org.junit.Assert.assertEquals;

public class RealRandomTest {
  private RealRandom randomValue1;
  private RealRandom randomValue2;

  @org.junit.Before
  public void setUp() throws Exception {
    //Test generating randomValue from 4 to 6.
    randomValue1 = new RealRandom(4, 6);

    //Test generating randomValue from 6 to 10.
    randomValue2 = new RealRandom(6, 10);
  }

  @org.junit.Test
  public void getRandomValue() {
    assertEquals(true,
            randomValue1.getRandomValue() >= 4 && randomValue1.getRandomValue() <= 6);

    assertEquals(true,
            randomValue2.getRandomValue() >= 6 && randomValue2.getRandomValue() <= 10);
  }
}