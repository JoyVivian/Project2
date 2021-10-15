package test.utilsTest;


import org.junit.Test;

import java.util.HashSet;

import battle.euipments.Headgear;
import battle.utils.RealRandom;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class RealRandomTest {
  private RealRandom randomValue1;
  private RealRandom randomValue2;
  private RealRandom randomValue3;

  @org.junit.Before
  public void setUp() throws Exception {
    //Test generating randomValue from 4 to 6.
    randomValue1 = new RealRandom(4, 6);

    //Test generating randomValue from 6 to 10.
    randomValue2 = new RealRandom(6, 10);

    randomValue3 = new RealRandom(0, 39);
  }

  @org.junit.Test
  public void getRandomValue() {
    assertEquals(true,
            randomValue1.getRandomValue() >= 4 && randomValue1.getRandomValue() <= 6);

    assertEquals(true,
            randomValue2.getRandomValue() >= 6 && randomValue2.getRandomValue() <= 10);
  }

  @Test
  public void getRandomValues() {
    int num = 20;
    HashSet<Integer> randomValues = randomValue3.getRandomValues(num);

    for (int randomValue : randomValues) {
      assertEquals(true, randomValue >= 0 && randomValue <= 39);
    }
  }

  @Test
  public void testEquals() {
    assertEquals(new RealRandom(4, 6), randomValue1);
    assertNotEquals(new RealRandom(4, 6), randomValue2);
  }

  @Test
  public void testHashCode() {
    assertEquals(new RealRandom(4, 6).hashCode(), randomValue1.hashCode());
    assertNotEquals(new RealRandom(4, 6).hashCode(), randomValue2.hashCode());
  }
}