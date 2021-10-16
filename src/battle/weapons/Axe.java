package battle.weapons;


import battle.utils.RandomFactory;
import battle.utils.RandomValue;

/**
 * Axe is a weapon that can cause 6-10 damages. This class
 * is used to create Axe instances.
 */
public class Axe extends Weapon {
  /**
   * A constructor to build Axe instances.
   *
   * @param name The name if this Axe object.
   * @param type Represents which RandomValue object to generate.
   */
  public Axe(String name, String type) throws IllegalArgumentException {
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
