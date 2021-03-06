package battle;

import battle.euipments.Bag;
import battle.euipments.Belt;
import battle.euipments.Footwear;
import battle.euipments.Gear;
import battle.euipments.Headgear;
import battle.euipments.Potion;
import battle.weapons.Armory;
import battle.weapons.Katanas;
import battle.weapons.Weapon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Battle has two players and one equipment bag and one armory.
 * This class contains methods to assign gears and weapons to two players
 * and return their fighting information.
 */
public class Battle {
  private ArrayList<Player> players;
  private Bag equipmentBag;
  private Armory armory;

  /**
   * A constructor of Battle that build Battle objects.
   *
   * @param players      An ArrayList that contains two players.
   * @param equipmentBag An ArrayList of gears that can be assigned to players.
   * @param armory       An ArrayList of weapons that can be assigned to players.
   */
  public Battle(ArrayList<Player> players, Bag equipmentBag, Armory armory)
          throws IllegalArgumentException {
    if (players == null || equipmentBag == null || armory == null) {
      throw new IllegalArgumentException("name, equimentBag, " +
              "armory should not be null.");
    }

    this.players = players;
    this.equipmentBag = equipmentBag;
    this.armory = armory;
  }

  /**
   * Assign gears to two player randomly.
   *
   * @param type Represents which RandomValue object to generate.
   * @return A string shows the information of gears that were assigned to each player.
   */
  public String assignGears(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    Player player1 = this.players.get(0);


    List<Gear> player1Gears = equipmentBag.getGears(type);
    List<Gear> filteredPlayer1Gears = this.filterGears(player1Gears);

    Collections.sort(filteredPlayer1Gears);
    player1.setGears(filteredPlayer1Gears);

    //Make sure that two players use different gears.
    Player player2 = this.players.get(1);
    List<Gear> player2Gears = equipmentBag.getRemainGears(player1Gears);
    List<Gear> filteredPlayer2Gears = this.filterGears(player2Gears);
    Collections.sort(filteredPlayer2Gears);
    player2.setGears(filteredPlayer2Gears);

    player1.setHealth(player1.getEnhancedStrength() + player1.getEnhancedConstitution()
            + player1.getEnhancedDexterity() + player1.getEnhancedCharisma());

    player2.setHealth(player2.getEnhancedStrength() + player2.getEnhancedConstitution()
            + player2.getEnhancedDexterity() + player2.getEnhancedCharisma());

    return String.format("Gears for Player1: \n %s \n Gears for Player2: \n %s \n",
            filteredPlayer1Gears, filteredPlayer2Gears);
  }

  private List<Gear> filterGears(List<Gear> playerGears) throws IllegalArgumentException {
    if (playerGears == null) {
      throw new IllegalArgumentException("playerGears should not be null.");
    }

    ArrayList<Gear> filteredGears = new ArrayList<>();

    Boolean isWearedHeadwear = false;
    Boolean isWearedFootwear = false;
    Boolean isBeltFull = false;
    int beltUnit = 0;

    for (Gear gear : playerGears) {
      //Apply constraints on gears.
      if (gear instanceof Headgear && !isWearedHeadwear) {
        filteredGears.add(gear);
        isWearedHeadwear = true;
      } else if (gear instanceof Footwear && !isWearedFootwear) {
        filteredGears.add(gear);
        isWearedFootwear = true;
      } else if (gear instanceof Belt && !isBeltFull) {
        //Calculate Belt Unit.
        switch (((Belt) gear).getBeltSize()) {
          case SMALL:
            beltUnit += 1;
            break;
          case MEDIUM:
            beltUnit += 2;
            break;
          case LARGE:
            beltUnit += 4;
            break;
          default:
            break;
        }

        if (beltUnit <= 10) {
          filteredGears.add(gear);
        } else {
          isBeltFull = true;
        }
      } else if (gear instanceof Potion) {
        filteredGears.add(gear);
      } else {
        continue;
      }
    }

    return (ArrayList<Gear>) filteredGears.clone();
  }

  /**
   * Assign weapons to two players.
   *
   * @param type Represents which RandomValue object to generate.
   * @return A String shows the information of weapons that were assigned to each player.
   */
  public String assignWeapon(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    Player player1 = this.players.get(0);
    Player player2 = this.players.get(1);

    List<Weapon> weapons1 = this.getOneWeapon(type);
    List<Weapon> weapons2 = this.getRemainWeapon(type, weapons1);

    player1.setWeapon(weapons1);
    player2.setWeapon(weapons2);

    return String.format("Weapon for Player1: %s\n Weapon for Player2: %s",
            weapons1.toString(), weapons2.toString());
  }

  private ArrayList<Weapon> getRemainWeapon(String type, List<Weapon> weapons) {
    ArrayList<Weapon> remainWeapons = (ArrayList<Weapon>) armory.getAnotherWeapon(type, weapons);
    return (ArrayList<Weapon>) remainWeapons.clone();
  }

  private ArrayList<Weapon> getOneWeapon(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    ArrayList<Weapon> weapons = new ArrayList<>();
    Weapon weapon = armory.getOneWeapon(type);
    weapons.add(weapon);
    if (weapon instanceof Katanas) {
      Weapon weapon2 = armory.getOneWeapon(type);
      if (weapon2 instanceof Katanas) {
        weapons.add(weapon2);
      }
    }
    return (ArrayList<Weapon>) weapons.clone();
  }

  /**
   * A method that make two players fight and return the fighting information.
   *
   * @param type Represents which RandomValue object to generate.
   * @return A string contains the fighting information of two players.
   */
  public String fight(String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    String fightInfo = "";

    Player player1 = this.players.get(0);
    Player player2 = this.players.get(1);

    int roundCount = 0;

    while (player1.getHealth() > 0 && player2.getHealth() > 0 && roundCount < 100) {
      if (player1.getEnhancedCharisma() >= player2.getEnhancedCharisma()) {
        fightInfo += this.attack(player1, player2, type);
        fightInfo += this.attack(player2, player1, type);
      } else {
        fightInfo += this.attack(player2, player1, type);
        fightInfo += this.attack(player1, player2, type);
      }
      roundCount++;
    }

    if (player1.getHealth() > 0 && player2.getHealth() > 0 && roundCount >= 100) {
      fightInfo += String.format("The match come to a draw.");
    } else if (player1.getHealth() <= 0 && player2.getHealth() > 0) {
      fightInfo += String.format("Player %s is the winner.\n", player2.getName());
    } else if (player2.getHealth() <= 0 && player1.getHealth() > 0) {
      fightInfo += String.format("Player %s is the winner.\n", player1.getName());
    }

    return fightInfo;
  }

  private String attack(Player firstHand, Player secondHand, String type) {
    if (type == null || type.isEmpty()) {
      throw new IllegalArgumentException("RandomValue instance must hava a type.");
    }

    String attackInfo = "";
    if (firstHand.getStrikingPower(type) > secondHand.getAvoidanceAbility(type)) {
      int actualDamage = firstHand.getPotentialDamage(type) - secondHand.getEnhancedConstitution();
      actualDamage = actualDamage < 0 ? 0 : actualDamage;
      secondHand.setHealth(secondHand.getHealth() - actualDamage);
      attackInfo += String.format("Player %s attack Player %s and the damage is:%s\n",
              firstHand.getName(), secondHand.getName(), Integer.valueOf(actualDamage));
    } else {
      attackInfo += String.format("Player %s attack Player %s and the damage is: 0\n",
              firstHand.getName(), secondHand.getName());
    }

    return attackInfo;
  }
}
