package battle;

import battle.euipments.Gear;
import battle.utils.RandomFactory;
import battle.utils.RandomValue;
import battle.weapons.Flail;
import battle.weapons.TwoHandedSwords;
import battle.weapons.Weapon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to create player instances.
 * A player can have some basic attributes and this
 * class stores these attributes and help calculalate
 * their enhanced attributes when they wear gears and use
 * weapons.
 */
public class Player {
  private String name;
  private int strength;
  private int constitution;
  private int dexterity;
  private int charisma;
  private int health;
  private List<Weapon> weapon;
  private List<Gear> gears;

  /**
   * A constructor of Player to build Player class.
   *
   * @param name The name of the player.
   * @param type Represents which RandomValue object to generate.
   * @throws IllegalArgumentException When the parameter is null, it will throw IAE.
   */
  public Player(String name, String type) throws IllegalArgumentException {
    if (name == null) {
      throw new IllegalArgumentException("The name of a player can not be null.");
    }

    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    this.name = name;
    this.strength = this.getDice(type);
    this.constitution = this.getDice(type);
    this.dexterity = this.getDice(type);
    this.charisma = this.getDice(type);
    this.weapon = new ArrayList<>();
    this.gears = new ArrayList<>();

    this.health = this.getEnhancedStrength() + this.getEnhancedConstitution()
            + this.getEnhancedDexterity() + this.getCharisma();
  }

  /**
   * Get the name of the Player.
   *
   * @return A string contains the player's name.
   */
  public String getName() {
    return name;
  }

  private int getDice(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValueIns = randomFactory.createRandomInstance(type, 1, 6);
    int randomValue = randomValueIns.getRandomValue();
    while (randomValue == 1) {
      randomValue = randomValueIns.getRandomValue();
    }
    return randomValue;
  }

  /**
   * Get the strength of the Player.
   *
   * @return A string contains the player's strength.
   */
  public int getStrength() {
    return strength;
  }

  /**
   * Get the constitution of the player.
   *
   * @return A string contains the player's constitution.
   */
  public int getConstitution() {
    return constitution;
  }

  /**
   * Get the dexterity of the player.
   *
   * @return A string contains the player's dexterity.
   */
  public int getDexterity() {
    return dexterity;
  }

  /**
   * Get the charisma of the player.
   *
   * @return A string contains the player's charisma.
   */
  public int getCharisma() {
    return charisma;
  }

  /**
   * Get the health of the player.
   *
   * @return A Integer contains the player's health.
   */
  public int getHealth() {
    return health;
  }

  /**
   * Get the strength of the player after wearing gears.
   *
   * @return A Integer contains the player's strength after wearing gears.
   */
  public int getEnhancedStrength() {
    int enhancedStrength = 0;
    for (Gear gear : gears) {
      enhancedStrength += gear.getAffectedAttrs()[0];
    }
    enhancedStrength += this.strength;
    enhancedStrength = enhancedStrength < 0 ? 0 : enhancedStrength;
    return enhancedStrength;
  }

  /**
   * Get the constitution of the player after wearing gears.
   *
   * @return A Integer contains the player's constitution after wearing gears.
   */
  public int getEnhancedConstitution() {
    int enhancedConstitution = 0;
    for (Gear gear : gears) {
      enhancedConstitution += gear.getAffectedAttrs()[1];
    }
    enhancedConstitution += this.constitution;
    enhancedConstitution = enhancedConstitution < 0 ? 0 : enhancedConstitution;
    return enhancedConstitution;
  }

  /**
   * Get the dexterity of the player after wearing gears.
   *
   * @return A Integer contains the player's dexterity after wearing gears.
   */
  public int getEnhancedDexterity() {
    int enhancedDexterity = 0;
    for (Gear gear : gears) {
      enhancedDexterity += gear.getAffectedAttrs()[2];
    }
    enhancedDexterity += this.dexterity;
    enhancedDexterity = enhancedDexterity < 0 ? 0 : enhancedDexterity;
    return enhancedDexterity;
  }

  /**
   * Get the charisma of the player after wearing gears.
   *
   * @return A Integer contains the player's charisma after wearing gears.
   */
  public int getEnhancedCharisma() {
    int enhancedCharisma = 0;
    for (Gear gear : gears) {
      enhancedCharisma += gear.getAffectedAttrs()[3];
    }
    enhancedCharisma += this.charisma;
    enhancedCharisma = enhancedCharisma < 0 ? 0 : enhancedCharisma;
    return enhancedCharisma;
  }

  /**
   * Get the Striking power of the player after wearing gears.
   *
   * @return A Integer contains the player's striking power after wearing gears.
   */
  public int getStrikingPower(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValueIns = randomFactory.createRandomInstance(type, 1, 10);
    int randomValue = randomValueIns.getRandomValue();

    int strikingPower = this.getEnhancedStrength() + randomValue;

    return strikingPower;
  }

  /**
   * Get the avoidance ability of the player after wearing gears.
   *
   * @return A Integer contains the player's avoidance ability after wearing gears.
   */
  public int getAvoidanceAbility(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    RandomFactory randomFactory = new RandomFactory();
    RandomValue randomValueIns = randomFactory.createRandomInstance(type, 1, 6);
    int randomValue = randomValueIns.getRandomValue();

    int avoidanceAbility = this.getEnhancedDexterity() + randomValue;

    return avoidanceAbility;
  }

  /**
   * Get the potential damage of the player after wearing gears.
   *
   * @return A Integer contains the player's potential damage after wearing gears.
   */
  public int getPotentialDamage(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    int potentialDamage = 0;

    for (Weapon weapon : this.weapon) {
      if (weapon instanceof TwoHandedSwords) {
        if (this.strength < 14) {
          potentialDamage += weapon.getDamage(type) / 2;
        } else {
          potentialDamage += weapon.getDamage(type);
        }
      } else if (weapon instanceof Flail) {
        if (this.dexterity < 14) {
          potentialDamage += weapon.getDamage(type) / 2;
        } else {
          potentialDamage += weapon.getDamage(type);
        }
      }else {
        potentialDamage += weapon.getDamage(type);
      }

    }

    potentialDamage += this.getEnhancedStrength() ;
    return potentialDamage;
  }

  /**
   * Assign a weapon to the player.
   *
   * @param weapon An ArrayList of Weapon that should assign to player.
   */
  public void setWeapon(List<Weapon> weapon) throws IllegalArgumentException{
    if (weapon == null) {
      throw new IllegalArgumentException("weapon should not be null");
    }

    this.weapon = weapon;
  }

  /**
   * Assign gears to the player.
   *
   * @param gears An ArrayList of Gears that should assign to player.
   */
  public void setGears(List<Gear> gears) throws IllegalArgumentException {
    if (gears == null) {
      throw new IllegalArgumentException("gears should not be null");
    }
    Collections.sort(gears);
    this.gears = gears;
  }

  /**
   * Return basic information of a player.
   *
   * @return A string contains the basic information of a player.
   */
  public String playerBasicInfo() {
    //basic information.
    String basicInfo = String.format("Name: %s, Strength: %s, Constitution: %s,"
                    + " Dexterity: %s, Charisma: %s",
            this.name, String.valueOf(this.strength), String.valueOf(this.constitution),
            String.valueOf(this.dexterity), String.valueOf(this.charisma)
    );
    return basicInfo;
  }

  /**
   * Return attributes of the player after they wear gears and use a weapon.
   *
   * @param type Represents which RandomValue object to generate.
   * @return A string contains the attributes information of a player
   *     after they wear gears and use a weapon.
   */
  public String playerEnhancedInfo(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    //enhanced information.
    String enhancedInfo = String.format("Name: %s, Strength: %s, Constitution: %s, "
                    + "Dexterity: %s, Charisma: %s "
                    + "Health: %s" + " StrikingPower: %s " + "AvoidAbility: %s",
            this.name, this.getEnhancedStrength(), this.getEnhancedConstitution(),
            this.getEnhancedDexterity(), this.getEnhancedCharisma(), this.getHealth(),
            this.getStrikingPower(type), this.getAvoidanceAbility(type)
    );

    return enhancedInfo;
  }

  /**
   * Set the health field of the player.
   *
   * @param health The health value that should be set to.
   */
  public void setHealth(int health) {
    this.health = health;
  }
}
