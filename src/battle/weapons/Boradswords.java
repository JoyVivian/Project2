package battle.weapons;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

/**
 * Broadswords is a weapon that can cause 6-10 damages.
 * This class is used to create Broadswords instances.
 */
public class Boradswords extends Weapon {
  /**
   * A constructor that used to construct Broadswords objects.
   *
   * @param name The name of the Broadswords object.
   * @param type Represents which RandomValue object to generate.
   */
  public Boradswords(String name, String type) {
    super(name);

    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 6, 10);
    this.damage = randomValue.getRandomValue();
  }

  @Override
  public int getDamage(String type) {

    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 6, 10);
    this.damage = randomValue.getRandomValue();

    return this.damage;
  }
}
