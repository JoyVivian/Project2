package battle.euipments;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used to create equipmentbag instance. The bag constains
 * 40 gears that players can use the methods inside this class to choose
 * their gears randomly.
 */
public class Bag {
  private List<Gear> gears;

  /**
   * This is constructor for Bag class. When constructed,
   * the instance would contain 40 gears.
   */
  public Bag() {
    this.gears = new ArrayList<>();

    Headgear headgear1 = new Headgear("fighting headgear", new int[]{0, 2, 0, 0});
    Headgear headgear2 = new Headgear("stupid headgear", new int[]{0, -1, 0, 0});
    Headgear headgear3 = new Headgear("king headgear", new int[]{0, 666, 0, 0});
    Headgear headgear4 = new Headgear("ragged header", new int[]{0, -3, 0, 0});
    Headgear headgear5 = new Headgear("elated header", new int[]{0, 9, 0, 0});

    Footwear footwear1 = new Footwear("firm footwear", new int[]{0, 0, 4, 0});
    Footwear footwear2 = new Footwear("cumbersome footwear", new int[]{0, 0, -10, 0});
    Footwear footwear3 = new Footwear("gorgeous footwear", new int[]{0, 0, 5, 0});
    Footwear footwear4 = new Footwear("beautiful footwear", new int[]{0, 0, 5, 0});
    Footwear footwear5 = new Footwear("poor footwear", new int[]{0, 0, -9, 0});

    Belt belt1 = new Belt("lovely belt", new int[]{50, 0, 1, 0}, BeltSize.SMALL);
    Belt belt2 = new Belt("tight belt", new int[]{0, -5, 0, 0}, BeltSize.SMALL);
    Belt belt3 = new Belt("gold belt", new int[]{0, 2, 3, 0}, BeltSize.MEDIUM);
    Belt belt4 = new Belt("heavy belt", new int[]{9, 0, 0, 9}, BeltSize.LARGE);
    Belt belt5 = new Belt("power belt", new int[]{0, 4, 1, 0}, BeltSize.LARGE);
    Belt belt6 = new Belt("poor belt", new int[]{19, -1, 0, -2}, BeltSize.LARGE);
    Belt belt7 = new Belt("garbage belt", new int[]{7, 1, 0, 0}, BeltSize.MEDIUM);
    Belt belt8 = new Belt("cool belt", new int[]{-7, 0, 0, 10}, BeltSize.MEDIUM);
    Belt belt9 = new Belt("silk belt", new int[]{0, 0, 0, 5}, BeltSize.SMALL);
    Belt belt10 = new Belt("leather belt", new int[]{0, 0, 2, 0}, BeltSize.SMALL);
    Belt belt11 = new Belt("cloth belt", new int[]{0, -10, -5, 0}, BeltSize.SMALL);
    Belt belt12 = new Belt("iron belt", new int[]{100, 0, 0, 0}, BeltSize.LARGE);
    Belt belt13 = new Belt("copper belt", new int[]{0, 3, 0, 0}, BeltSize.SMALL);
    Belt belt14 = new Belt("strong belt", new int[]{1, 2, 0, 0}, BeltSize.LARGE);
    Belt belt15 = new Belt("silver belt", new int[]{7, 2, 0, 0}, BeltSize.MEDIUM);

    Potion potion1 = new Potion("APTX 4869", new int[]{0, 0, 0, 999});
    Potion potion2 = new Potion("strong medicine", new int[]{6, 0, 0, 0});
    Potion potion3 = new Potion("painKiller", new int[]{70, 0, 0, 0});
    Potion potion4 = new Potion("small blood medicine", new int[]{0, 1, 0, 0});
    Potion potion5 = new Potion("toxic", new int[]{0, -1, 0, 0});
    Potion potion6 = new Potion("large blood medicine", new int[]{0, 1, 0, 0});
    Potion potion7 = new Potion("small charming medicine", new int[]{28, 0, 0, 0});
    Potion potion8 = new Potion("medium charming medicine", new int[]{0, 0, 0, 1});
    Potion potion9 = new Potion("trioxide", new int[]{-2, 0, 0, 0});
    Potion potion10 = new Potion("large charming medicine", new int[]{0, 0, 0, 99});
    Potion potion11 = new Potion("small dexterity medicine", new int[]{0, 0, 1, 0});
    Potion potion12 = new Potion("alcohol", new int[]{90, 0, 0, 0});
    Potion potion13 = new Potion("medium dexterity medicine", new int[]{-30, 0, 3, 0});
    Potion potion14 = new Potion("large dexterity medicine", new int[]{0, 0, 6, 0});
    Potion potion15 = new Potion("strength medicine", new int[]{3, 0, 0, 0});

    gears.add(headgear1);
    gears.add(headgear2);
    gears.add(headgear3);
    gears.add(headgear4);
    gears.add(headgear5);

    gears.add(footwear1);
    gears.add(footwear2);
    gears.add(footwear3);
    gears.add(footwear4);
    gears.add(footwear5);

    gears.add(belt1);
    gears.add(belt2);
    gears.add(belt3);
    gears.add(belt4);
    gears.add(belt5);
    gears.add(belt6);
    gears.add(belt7);
    gears.add(belt8);
    gears.add(belt9);
    gears.add(belt10);
    gears.add(belt11);
    gears.add(belt12);
    gears.add(belt13);
    gears.add(belt14);
    gears.add(belt15);

    gears.add(potion1);
    gears.add(potion2);
    gears.add(potion3);
    gears.add(potion4);
    gears.add(potion5);
    gears.add(potion6);
    gears.add(potion7);
    gears.add(potion8);
    gears.add(potion9);
    gears.add(potion10);
    gears.add(potion11);
    gears.add(potion12);
    gears.add(potion13);
    gears.add(potion14);
    gears.add(potion15);
  }

  /**
   * This method is used to choose 20 gears from the bag instance randomly.
   *
   * @param type Represents generating random values for game logic or for tests.
   * @return An ArrayList of 20 randomly choosed gears.
   */
  public List<Gear> getGears(String type) throws IllegalArgumentException {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    ArrayList<Gear> onePlayerGears = new ArrayList<>();
    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValuesIns = randomFactory.createRandomInstance(type, 0, 39);

    List<Integer> randomIndexes = randomValuesIns.getRandomValues(20);
    for (int randomValue : randomIndexes) {
      Gear gear = this.gears.get(randomValue);

      onePlayerGears.add(this.gears.get(randomValue));
    }

    return (ArrayList<Gear>) onePlayerGears.clone();
  }

  /**
   * After randomly choosing 20 gears, get another 20 remained gears
   * in the bag.
   *
   * @param usedGears An ArrayList of used gears.
   * @return An ArrayList of 20 remained gears.
   */
  public List<Gear> getRemainGears(List<Gear> usedGears) throws IllegalArgumentException {
    if (usedGears == null) {
      throw new IllegalArgumentException("usedGears can not be null.");
    }
    ArrayList<Gear> remainGears = new ArrayList<>();

    for (Gear gear : this.gears) {
      if (!usedGears.contains(gear)) {
        remainGears.add(gear);
      }
    }

    return (ArrayList<Gear>) remainGears.clone();
  }
}
