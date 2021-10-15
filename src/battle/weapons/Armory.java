package battle.weapons;

import java.util.ArrayList;

import battle.utils.RandomFactory;
import battle.utils.RandomValue;

public class Armory {
  public ArrayList<Weapon> weapons = new ArrayList<>();

  public Armory(String type) {
    Katanas katanas1 = new Katanas("sharp katanas", type);
    Katanas katanas2 = new Katanas("long katanas", type);

    Boradswords boradswords1 = new Boradswords("heavy broadsword", type);
    Boradswords broadswords2 = new Boradswords("nimble broadsword", type);

    TwoHandedSwords twoHandedSwords1 = new TwoHandedSwords("beautiful twoHandedSword", type);
    TwoHandedSwords twoHandedSwords2 = new TwoHandedSwords("deft towHandedSword", type);

    Axe axe1 = new Axe("dark axe", type);
    Axe axe2 = new Axe("toxic axe", type);

    Flail flail1 = new Flail("painful flail", type);
    Flail flail2 = new Flail("powerful flail", type);

    this.weapons.add(katanas1);
    this.weapons.add(katanas2);
    this.weapons.add(boradswords1);
    this.weapons.add(broadswords2);
    this.weapons.add(twoHandedSwords1);
    this.weapons.add(twoHandedSwords2);
    this.weapons.add(axe1);
    this.weapons.add(axe2);
    this.weapons.add(flail1);
    this.weapons.add(flail2);
  }

  public Weapon getOneWeapon(String type) {
    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValue = randomFactory.createRandomInstance(type, 0, 9);
    int randomIndex = randomValue.getRandomValue();
    return this.weapons.get(randomIndex);
  }
}
