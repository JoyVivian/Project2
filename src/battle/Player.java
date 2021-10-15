package battle;

import java.util.ArrayList;
import java.util.Collections;

import battle.euipments.Gear;
import battle.utils.RandomFactory;
import battle.utils.RandomValue;
import battle.weapons.Flail;
import battle.weapons.TwoHandedSwords;
import battle.weapons.Weapon;

public class Player {
  private String name;
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private int health;
  private ArrayList<Weapon> weapon = new ArrayList<>();
  private ArrayList<Gear> gears = new ArrayList<>();

  public String getName() {
    return name;
  }

  Player(String name) throws IllegalArgumentException {
    if (name == null) {
      throw new IllegalArgumentException("The name of a player can not be null.");
    }

    this.name = name;
    this.strength = this.getDice();
    this.constitution = this.getDice();
    this.dexterity = this.getDice();
    this.charisma = this.getDice();

    this.health = this.getEnhancedStrength() + this.getEnhancedConstitution()
            + this.getEnhancedDexterity() + this.getCharisma();
  }

  private int getDice() {
    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValueIns = randomFactory.createRandomInstance("RealRandom", 1, 6);
    int randomValue = randomValueIns.getRandomValue();
    while (randomValue == 1) {
      randomValue = randomValueIns.getRandomValue();
    }
    return randomValue;
  }

  public int getStrength() {
    return strength;
  }

  public int getConstitution() {
    return constitution;
  }

  public int getDexterity() {
    return dexterity;
  }

  public int getCharisma() {
    return charisma;
  }

  public int getHealth() {
    return health;
  }

  public int getEnhancedStrength() {
    int enhancedStrength = 0;
    for (Gear gear : gears) {
      enhancedStrength += gear.getAffectedAttrs()[0];
    }
    enhancedStrength += this.strength;
    return enhancedStrength;
  }

  public int getEnhancedConstitution() {
    int enhancedConstitution = 0;
    for (Gear gear : gears) {
      enhancedConstitution += gear.getAffectedAttrs()[1];
    }
    enhancedConstitution += this.constitution;
    return enhancedConstitution;
  }

  public int getEnhancedDexterity() {
    int enhancedDexterity = 0;
    for (Gear gear : gears) {
      enhancedDexterity += gear.getAffectedAttrs()[2];
    }
    enhancedDexterity += this.dexterity;
    return enhancedDexterity;
  }

  public int getEnhancedCharisma() {
    int enhancedCharisma = 0;
    for (Gear gear : gears) {
      enhancedCharisma += gear.getAffectedAttrs()[3];
    }
    enhancedCharisma += this.charisma;
    return enhancedCharisma;
  }

  private int[] getTempAttrs() {
    int[] tmpAttrs = new int[4];

    for (Gear gear : this.gears) {
      int[] eachGearAttrs = gear.getAffectedAttrs();
      for (int i = 0; i < 4; i++) {
        tmpAttrs[i] = eachGearAttrs[i];
      }
    }

    tmpAttrs[0] += this.strength;
    tmpAttrs[1] += this.constitution;
    tmpAttrs[2] += this.dexterity;
    tmpAttrs[3] += this.charisma;

    return tmpAttrs;
  }

  public int getStrikingPower(String type) {
    int[] tmpAttrs = this.getTempAttrs();

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValueIns = randomFactory.createRandomInstance(type, 1, 10);
    int randomValue = randomValueIns.getRandomValue();

    int strikingPower = this.strength + tmpAttrs[0] + randomValue;

    return strikingPower;
  }

  public int getAvoidanceAbility(String type) {
    int[] tmpAttrs = this.getTempAttrs();

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValueIns = randomFactory.createRandomInstance(type, 1, 6);
    int randomValue = randomValueIns.getRandomValue();

    int avoidanceAbility = this.dexterity + tmpAttrs[2] + randomValue;

    return avoidanceAbility;
  }

  public int getPotentialDamage(String type) {
    int potentialDamage = 0;

    for (Weapon weapon : this.weapon) {
      if (weapon instanceof TwoHandedSwords) {
        if (this.strength < 14) {
          potentialDamage += weapon.getDamage() / 2;
        } else {
          potentialDamage += weapon.getDamage();
        }
      } else if (weapon instanceof Flail) {
        if (this.dexterity < 14) {
          potentialDamage += weapon.getDamage() / 2;
        } else {
          potentialDamage += weapon.getDamage();
        }
      }

    }

    potentialDamage += this.getStrikingPower(type);
    return potentialDamage;
  }

  public void setWeapon(ArrayList<Weapon> weapon) {
    this.weapon = weapon;
  }

  public void setGears(ArrayList<Gear> gears) {
    Collections.sort(gears);
    this.gears = gears;
  }

  public String playerBasicInfo() {
    //basic information.
    String basicInfo = String.format("Name: %s, Strength: %s, Constitution: %s, Dexterity: %s, Charisma: %s"
            , this.name, String.valueOf(this.strength), String.valueOf(this.constitution)
            , String.valueOf(this.dexterity), String.valueOf(this.charisma)
    );
    return basicInfo;
  }

  public String playerEnhancedInfo() {
    //enhanced information.
    String enhancedInfo = String.format("Name: %s, Strength: %s, Constitution: %s, Dexterity: %s, Charisma: %s " +
                    "Health: %s", this.name, this.getEnhancedStrength(), this.getEnhancedConstitution(),
            this.getEnhancedDexterity(), this.getEnhancedCharisma(), this.getHealth()
    );

    return enhancedInfo;
  }

  public void setHealth(int health) {
    this.health = health;
  }
}
