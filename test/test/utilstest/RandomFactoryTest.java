package test.utilstest;

import org.junit.Before;
import org.junit.Test;

import battle.utils.FalseRandom;
import battle.utils.RandomFactory;
import battle.utils.RealRandom;

import static org.junit.Assert.assertEquals;

/**
 * A class that is used to test RandomFactory class.
 */
public class RandomFactoryTest {
  private RandomFactory randomFactory;

  @Before
  public void setUp() throws Exception {
    randomFactory = new RandomFactory();
  }

  @Test
  public void createRandomInstance() {
    assertEquals(new RealRandom(0, 6),
            randomFactory.createRandomInstance("RealRandom", 0, 6));
    assertEquals(new FalseRandom(1, 7),
            randomFactory.createRandomInstance("FalseRandom", 1, 7));
  }
}