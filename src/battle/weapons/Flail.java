package battle.weapons;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

/**
 * Flail is weapon that can cause 8-12 damages.
 * This class is used to create Flail instances.
 */
public class Flail extends Weapon {
  /**
   * A constructor of Flail Class and is used to build Flail instances.
   *
   * @param name The name of the Flail instance.
   * @param type Represents which RandomValue object to generate.
   */
  public Flail(String name, String type) {
    super(name);

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 8, 12);
    this.damage = randomValue.getRandomValue();
  }
}
