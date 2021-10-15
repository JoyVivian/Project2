package test.equipmentsTests;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import battle.euipments.Bag;
import battle.euipments.Belt;
import battle.euipments.BeltSize;
import battle.euipments.Footwear;
import battle.euipments.Gear;
import battle.euipments.Headgear;
import battle.euipments.Potion;

import static org.junit.Assert.assertEquals;

public class BagTest {
  private Bag bag;
  private ArrayList<Gear> usedGears = new ArrayList<>();
  private ArrayList<Gear> remainGears = new ArrayList<>();

  @Before
  public void setUp() throws Exception {
    bag = new Bag();

    Headgear headgear1 = new Headgear("fighting headgear", new int[]{0, 25, 0, 0});
    Headgear headgear3 = new Headgear("king headgear", new int[]{0, 666, 0, 0});
    Headgear headgear5 = new Headgear("elated header", new int[]{0, 999, 0, 0});

    Footwear footwear2 = new Footwear("cumbersome footwear", new int[]{0, 0, -100, 0});
    Footwear footwear4 = new Footwear("beautiful footwear", new int[]{0, 0, 555, 0});

    Belt belt1 = new Belt("lovely belt", new int[]{0, 0, 10, 0}, BeltSize.SMALL);
    Belt belt3 = new Belt("gold belt", new int[]{0, 28, 37, 0}, BeltSize.MEDIUM);
    Belt belt5 = new Belt("power belt", new int[]{0, 44, 21, 0}, BeltSize.LARGE);
    Belt belt7 = new Belt("garbage belt", new int[]{7, 1, 0, 0}, BeltSize.MEDIUM);
    Belt belt9 = new Belt("silk belt", new int[]{0, 0, 0, 55}, BeltSize.SMALL);
    Belt belt11 = new Belt("cloth belt", new int[]{0, -10, -5, 0}, BeltSize.SMALL);
    Belt belt13 = new Belt("copper belt", new int[]{0, 34, 0, 0}, BeltSize.SMALL);
    Belt belt15 = new Belt("silver belt", new int[]{78, 23, 0, 0}, BeltSize.MEDIUM);

    Potion potion2 = new Potion("strong medicine", new int[]{66, 0, 0, 0});
    Potion potion4 = new Potion("small blood medicine", new int[]{0, 1, 0, 0});
    Potion potion6 = new Potion("large blood medicine", new int[]{0, 100, 0, 0});
    Potion potion8 = new Potion("medium charming medicine", new int[]{0, 0, 0, 10});
    Potion potion10 = new Potion("large charming medicine", new int[]{0, 0, 0, 99});
    Potion potion12 = new Potion("alcohol", new int[]{0, 0, -50, 0});
    Potion potion14 = new Potion("large dexterity medicine", new int[]{0, 0, 60, 0});

    usedGears.add(headgear1);
    usedGears.add(headgear3);
    usedGears.add(headgear5);

    usedGears.add(footwear2);
    usedGears.add(footwear4);

    usedGears.add(belt1);
    usedGears.add(belt3);
    usedGears.add(belt5);
    usedGears.add(belt7);
    usedGears.add(belt9);
    usedGears.add(belt11);
    usedGears.add(belt13);
    usedGears.add(belt15);

    usedGears.add(potion2);
    usedGears.add(potion4);
    usedGears.add(potion6);
    usedGears.add(potion8);
    usedGears.add(potion10);
    usedGears.add(potion12);
    usedGears.add(potion14);

    Headgear headgear2 = new Headgear("stupid headgear", new int[]{0, -100, 0, 0});
    Headgear headgear4 = new Headgear("ragged header", new int[]{0, -30, 0, 0});

    Footwear footwear1 = new Footwear("firm footwear", new int[]{0, 0, 74, 0});
    Footwear footwear3 = new Footwear("gorgeous footwear", new int[]{0, 0, 255, 0});
    Footwear footwear5 = new Footwear("poor footwear", new int[]{0, 0, -999, 0});

    Belt belt2 = new Belt("tight belt", new int[]{0, -50, 0, 0}, BeltSize.SMALL);
    Belt belt4 = new Belt("heavy belt", new int[]{99, 0, 0, 99}, BeltSize.LARGE);
    Belt belt6 = new Belt("poor belt", new int[]{0, -11, 0, -32}, BeltSize.LARGE);
    Belt belt8 = new Belt("cool belt", new int[]{-7, 0, 0, 100}, BeltSize.MEDIUM);
    Belt belt10 = new Belt("leather belt", new int[]{0, 0, 23, 0}, BeltSize.SMALL);
    Belt belt12 = new Belt("iron belt", new int[]{100, 0, 0, 0}, BeltSize.LARGE);
    Belt belt14 = new Belt("strong belt", new int[]{12, 23, 0, 0}, BeltSize.LARGE);

    Potion potion1 = new Potion("APTX 4869", new int[]{0, 0, 0 ,999});
    Potion potion3 = new Potion("painKiller", new int[]{0, 34, 0, 0});
    Potion potion5 = new Potion("toxic", new int[]{0, -100, 0, 0});
    Potion potion7 = new Potion("small charming medicine", new int[]{0, 0, 0, 1});
    Potion potion9 = new Potion("trioxide", new int[]{-23, 0, 0, 0});
    Potion potion11 = new Potion("small dexterity medicine", new int[]{0, 0, 14, 0});
    Potion potion13 = new Potion("medium dexterity medicine", new int[]{0, 0, 30, 0});
    Potion potion15 = new Potion("strength medicine", new int[]{13, 0, 0, 0});

    remainGears.add(headgear2);
    remainGears.add(headgear4);

    remainGears.add(footwear1);
    remainGears.add(footwear3);
    remainGears.add(footwear5);

    remainGears.add(belt2);
    remainGears.add(belt4);
    remainGears.add(belt6);
    remainGears.add(belt8);
    remainGears.add(belt10);
    remainGears.add(belt12);
    remainGears.add(belt14);

    remainGears.add(potion1);
    remainGears.add(potion3);
    remainGears.add(potion5);
    remainGears.add(potion7);
    remainGears.add(potion9);
    remainGears.add(potion11);
    remainGears.add(potion13);
    remainGears.add(potion15);
  }

  @Test
  public void getGears() {;
    assertEquals(usedGears, bag.getGears("FalseRandom"));
  }

  @Test
  public void getRemainGears() {
    assertEquals(remainGears, bag.getRemainGears(usedGears));
  }
}