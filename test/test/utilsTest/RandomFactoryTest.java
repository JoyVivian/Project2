package test.utilsTest;

import org.junit.Before;
import org.junit.Test;

import battle.utils.FalseRandom;
import battle.utils.RandomFactory;
import battle.utils.RealRandom;

import static org.junit.Assert.*;

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