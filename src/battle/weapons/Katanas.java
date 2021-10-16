package battle.weapons;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

/**
 * Katanas is weapon that can cause 4-6 damages.
 * This class is used to create Katanas objects.
 */
public class Katanas extends Weapon {
  /**
   * A construcotr of Katanas that is use to build Katanas instances.
   *
   * @param name The name of the Katanas instance.
   * @param type Represents which RandomValue object to generate.
   */
  public Katanas(String name, String type) {
    super(name);
    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 4, 6);
    this.damage = randomValue.getRandomValue();
  }
}
