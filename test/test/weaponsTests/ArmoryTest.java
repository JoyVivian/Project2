package test.weaponsTests;

import org.junit.Before;
import org.junit.Test;

import battle.weapons.Armory;
import battle.weapons.Flail;
import battle.weapons.Weapon;

import static org.junit.Assert.*;

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
}