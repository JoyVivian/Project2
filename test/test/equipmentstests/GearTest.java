package test.equipmentstests;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import battle.euipments.Belt;
import battle.euipments.BeltSize;
import battle.euipments.Footwear;
import battle.euipments.Gear;
import battle.euipments.Headgear;
import battle.euipments.Potion;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * A class that is used to test the Gear class.
 */
public class GearTest {
  private Gear belt;
  private Gear belt2;
  private Gear belt3;

  private Gear footwear;
  private Gear footwear2;
  private Gear footWear3;

  private Gear headgear;
  private Gear headgear2;
  private Gear headgear3;

  private Gear potion;
  private Gear potion2;
  private Gear potion3;

  @Before
  public void setUp() throws Exception {
    belt = new Belt("god belt", new int[]{1, 0, 1, 0}, BeltSize.LARGE);
    belt2 = new Belt("awkward belt", new int[]{-1, 0, -1, 0}, BeltSize.SMALL);
    belt3 = new Belt("heavy belt", new int[]{99, 0, 0, 99}, BeltSize.LARGE);

    footwear = new Footwear("fast footwear", new int[]{0, 0, 21, 0});
    footwear2 = new Footwear("gorgeous footwear", new int[]{0, 0, 255, 0});
    footWear3 = new Footwear("poor footwear", new int[]{0, 0, -999, 0});

    headgear = new Headgear("stupid headwear", new int[]{0, -50, 0, 0});
    headgear2 = new Headgear("ragged header", new int[]{0, -30, 0, 0});
    headgear3 = new Headgear("elated header", new int[]{0, 999, 0, 0});

    potion = new Potion("APTX 4869", new int[]{0, 0, 0, 999});
    potion2 = new Potion("strong medicine", new int[]{66, 0, 0, 0});
    potion3 = new Potion("large charming medicine", new int[]{0, 0, 0, 99});
  }

  @Test
  public void getAffectedAttrs() {
    assertEquals(true, Arrays.equals(new int[]{1, 0, 1, 0}, belt.getAffectedAttrs()));
    assertEquals(true, Arrays.equals(new int[]{0, 0, 21, 0}, footwear.getAffectedAttrs()));
    assertEquals(true, Arrays.equals(new int[]{0, -50, 0, 0}, headgear.getAffectedAttrs()));
    assertEquals(true, Arrays.equals(new int[]{0, 0, 0, 999}, potion.getAffectedAttrs()));
  }

  @Test
  public void compareTo() {
    assertEquals(1, belt.compareTo(headgear));
    assertEquals(1, belt.compareTo(potion));
    assertEquals(-1, belt.compareTo(footwear));

    assertEquals(1, footwear.compareTo(headgear));
    assertEquals(1, footwear.compareTo(potion));
    assertEquals(1, footwear.compareTo(belt));

    assertEquals(-1, headgear.compareTo(footwear));
    assertEquals(-1, headgear.compareTo(potion));
    assertEquals(-1, headgear.compareTo(belt));

    assertEquals(-1, potion.compareTo(footwear));
    assertEquals(-1, potion.compareTo(belt));
    assertEquals(1, potion.compareTo(headgear));
  }

  @Test
  public void compareImplHeadGear() {
    assertEquals(-1, headgear.compareImpl((Headgear) headgear2));
    assertEquals(-1, headgear.compareImpl((Headgear) headgear3));
  }

  @Test
  public void testCompareImplPotion() {
    assertEquals(1, potion.compareImpl((Potion) potion2));
    assertEquals(1, potion.compareImpl((Potion) potion3));
  }

  @Test
  public void testCompareImplBelt() {
    assertEquals(-1, belt.compareImpl((Belt) belt2));
    assertEquals(1, belt.compareImpl((Belt) belt3));
  }

  @Test
  public void testCompareImplFootWear() {
    assertEquals(1, footwear.compareImpl((Footwear) footwear2));
    assertEquals(1, footwear.compareImpl((Footwear) footWear3));
  }

  @Test
  public void getPriority() {
    assertEquals(2, belt.getPriority());
    assertEquals(1, footwear.getPriority());
    assertEquals(4, headgear.getPriority());
    assertEquals(3, potion.getPriority());
  }

  @Test
  public void testToString() {
    assertEquals("Gear{Type = class battle.euipments.Belt, name='god belt'," +
            " affectedAttrs=[1, 0, 1, 0]}\n" +
            "BeltSize = LARGE\n", belt.toString());
    assertEquals("Gear{Type = class battle.euipments.Footwear, name='fast footwear', " +
            "affectedAttrs=[0, 0, 21, 0]}\n", footwear.toString());
    assertEquals("Gear{Type = class battle.euipments.Headgear, " +
            "name='stupid headwear', affectedAttrs=[0, -50, 0, 0]}\n", headgear.toString());
    assertEquals("Gear{Type = class battle.euipments.Potion, name='APTX 4869'," +
            " affectedAttrs=[0, 0, 0, 999]}\n", potion.toString());
  }

  @Test
  public void testEquals() {
    assertEquals(new Belt("god belt", new int[]{1, 0, 1, 0}, BeltSize.LARGE), belt);
    assertEquals(new Footwear("fast footwear", new int[]{0, 0, 21, 0}), footwear);
    assertEquals(new Headgear("stupid headwear", new int[]{0, -50, 0, 0}), headgear);
    assertEquals(new Potion("APTX 4869", new int[]{0, 0, 0, 999}), potion);
  }

  @Test
  public void testHashCode() {
    assertEquals(new Belt("god belt", new int[]{1, 0, 1, 0},
            BeltSize.LARGE).hashCode(), belt.hashCode());
    assertEquals(new Footwear("fast footwear", new int[]{0, 0, 21, 0}).hashCode(),
            footwear.hashCode());
    assertEquals(new Headgear("stupid headwear", new int[]{0, -50, 0, 0}).hashCode(),
            headgear.hashCode());
    assertEquals(new Potion("APTX 4869", new int[]{0, 0, 0, 999}).hashCode(),
            potion.hashCode());
  }

  @Test
  public void getName() {
    assertEquals("god belt", belt.getName());
    assertEquals("fast footwear", footwear.getName());
    assertEquals("stupid headwear", headgear.getName());
    assertEquals("APTX 4869", potion.getName());
  }

  @Test
  public void testIAE() {
    try {
      new Belt(null, null, null);
      fail("The instance above should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }

    try {
      new Footwear(null, null);
      fail("The instance above should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }

    try {
      new Headgear(null, null);
      fail("The instance above should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }

    try {
      new Potion(null, null);
      fail("The instance above should throw an IAE");
    } catch (Exception e) {
      //test successful.
    }
  }
}