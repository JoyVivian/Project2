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
  public TwoHandedSwords(String name, String type) throws IllegalArgumentException{
    super(name);

    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 8, 12);
    this.damage = randomValue.getRandomValue();
  }

  @Override
  public int getDamage(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 8, 12);
    this.damage = randomValue.getRandomValue();

    return this.damage;
  }
}
