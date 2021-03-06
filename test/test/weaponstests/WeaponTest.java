package test.weaponstests;

import org.junit.Before;
import org.junit.Test;

import battle.weapons.Axe;
import battle.weapons.Boradswords;
import battle.weapons.Flail;
import battle.weapons.Katanas;
import battle.weapons.TwoHandedSwords;
import battle.weapons.Weapon;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A class that is used to test Weapon Class.
 */
public class WeaponTest {
  private Weapon axe;
  private Weapon broadSwords;
  private Weapon flail;
  private Weapon katanas;
  private Weapon twoHandedSwords;

  @Before
  public void setUp() throws Exception {
    axe = new Axe("small axe", "FalseRandom");
    broadSwords = new Boradswords("golden sword", "FalseRandom");
    flail = new Flail("silver flail", "FalseRandom");
    katanas = new Katanas("heavy katanas", "FalseRandom");
    twoHandedSwords = new TwoHandedSwords("super twohandswords", "FalseRandom");
  }

  @Test
  public void getName() {
    assertEquals("small axe", axe.getName());
    assertEquals("golden sword", broadSwords.getName());
    assertEquals("silver flail", flail.getName());
    assertEquals("heavy katanas", katanas.getName());
    assertEquals("super twohandswords", twoHandedSwords.getName());
  }

  @Test
  public void getDamage() {
    assertEquals(10, axe.getDamage("FalseRandom"));
    assertEquals(10, broadSwords.getDamage("FalseRandom"));
    assertEquals(12, flail.getDamage("FalseRandom"));
    assertEquals(6, katanas.getDamage("FalseRandom"));
    assertEquals(12, twoHandedSwords.getDamage("FalseRandom"));
  }

  @Test
  public void testEquals() {
    assertEquals(new Axe("small axe", "FalseRandom"), axe);
    assertEquals(new Boradswords("golden sword", "FalseRandom"), broadSwords);
    assertEquals(new Flail("silver flail", "FalseRandom"), flail);
    assertEquals(new Katanas("heavy katanas", "FalseRandom"), katanas);
    assertEquals(new TwoHandedSwords("super twohandswords", "FalseRandom"), twoHandedSwords);
  }

  @Test
  public void testHashCode() {
    assertEquals(new Axe("small axe", "FalseRandom").hashCode(), axe.hashCode());
    assertEquals(new Boradswords("golden sword", "FalseRandom").hashCode(), broadSwords.hashCode());
    assertEquals(new Flail("silver flail", "FalseRandom").hashCode(), flail.hashCode());
    assertEquals(new Katanas("heavy katanas", "FalseRandom").hashCode(), katanas.hashCode());
    assertEquals(new TwoHandedSwords("super twohandswords", "FalseRandom").hashCode(),
            twoHandedSwords.hashCode());
  }

  @Test
  public void testToString() {
    assertEquals("Weapon{name='small axe', damage=10}", axe.toString());
    assertEquals("Weapon{name='golden sword', damage=10}", broadSwords.toString());
    assertEquals("Weapon{name='silver flail', damage=12}", flail.toString());
    assertEquals("Weapon{name='heavy katanas', damage=6}", katanas.toString());
    assertEquals("Weapon{name='super twohandswords', damage=12}", twoHandedSwords.toString());
  }

  @Test
  public void testIAE() {
    try {
      new Axe(null, null);
      fail("The instance above should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }

    try {
      new Boradswords(null, null);
      fail("The instance above should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }

    try {
      new Flail(null, null);
      fail("The instance above should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }

    try {
      new Katanas(null, null);
      fail("The instance above should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }

    try {
      new TwoHandedSwords(null, null);
      fail("The instance above should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }
  }
}