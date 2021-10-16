package test.utilstest;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import battle.utils.FalseRandom;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * A class that is used to test FalseRandom class.
 */
public class FalseRandomTest {
  private FalseRandom falseRandom;

  @Before
  public void setUp() throws Exception {
    falseRandom = new FalseRandom(0, 9);
  }

  @Test
  public void getRandomValue() {
    assertEquals(9, falseRandom.getRandomValue());
  }

  @Test
  public void getRandomValues() {
    int num = 20;

    List<Integer> randomValues = falseRandom.getRandomValues(num);

    int i = 0;
    int index = 0;
    while (index < num) {
      assertEquals(i, (int) randomValues.get(index));
      i += 2;
      index++;
    }
  }

  @Test
  public void testEquals() {
    assertEquals(new FalseRandom(0, 9), falseRandom);
    assertNotEquals(new FalseRandom(7, 18), falseRandom);
  }

  @Test
  public void testHashCode() {
    assertEquals(new FalseRandom(0, 9).hashCode(), falseRandom.hashCode());
    assertNotEquals(new FalseRandom(7, 18).hashCode(), falseRandom.hashCode());
  }
}