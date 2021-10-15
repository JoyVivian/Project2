package battle.weapons;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

public class Boradswords extends Weapon {
  public Boradswords(String name, String type) {
    super(name);
    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 6, 10);
    this.damage = randomValue.getRandomValue();
  }
}
