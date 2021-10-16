package test.weaponstests;

import org.junit.Before;
import org.junit.Test;

import battle.weapons.Armory;
import battle.weapons.Flail;
import battle.weapons.Weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A class that is used to test Armory class.
 */
public class ArmoryTest {
  private Armory armory;

  @Before
  public void setUp() throws Exception {
    armory = new Armory("FalseRandom");
  }

  @Test
  public void getOneWeapon() {
    Weapon flail = new Flail("powerful flail", "FalseRandom");
    assertEquals(flail, armory.getOneWeapon("FalseRandom"));
  }

  @Test
  public void testIAE() {
    try {
      new Armory(null);
      fail("The above instance should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }
  }
}