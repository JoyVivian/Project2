package battle.weapons;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

/**
 * TwoHandedSwords is a weapon that can cause 8-12 damages.
 * This class is used to generate TwoHandedSwords objects.
 */
public class TwoHandedSwords extends Weapon {
  /**
   * A constructor of TwoHandedSwords class to build TwoHandedSwords objects.
   *
   * @param name The name of the TwoHandedSwords object.
   * @param type Represents which RandomValue object to generate.
   */
  public TwoHandedSwords(String name, String type) {
    super(name);
    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 8, 12);
    this.damage = randomValue.getRandomValue();
  }
}
