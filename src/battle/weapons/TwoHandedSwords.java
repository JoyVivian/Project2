package battle.weapons;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

public class TwoHandedSwords extends Weapon {
  public TwoHandedSwords(String name, String type) {
    super(name);
    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 8, 12);
    this.damage = randomValue.getRandomValue();
  }
}
