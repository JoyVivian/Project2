package battle.weapons;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

public class Flail extends Weapon {
  public Flail(String name, String type) {
    super(name);

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 8, 12);
    this.damage = randomValue.getRandomValue();
  }
}
