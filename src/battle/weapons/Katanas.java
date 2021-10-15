package battle.weapons;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

public class Katanas extends Weapon {
  Katanas(String name, String type) {
    super(name);
    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 4, 6);
    this.damage = randomValue.getRandomValue();
  }
}
