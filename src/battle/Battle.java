package battle;

import java.util.ArrayList;
import java.util.Collections;

import battle.euipments.Bag;
import battle.euipments.Belt;
import battle.euipments.Footwear;
import battle.euipments.Gear;
import battle.euipments.Headgear;
import battle.euipments.Potion;
import battle.weapons.Armory;
import battle.weapons.Katanas;
import battle.weapons.Weapon;

public class Battle {
  private ArrayList<Player> players;
  private Bag equipmentBag;
  private Armory armory;

  Battle(ArrayList<Player> players, Bag equipmentBag, Armory armory) {
    this.players = players;
    this.equipmentBag = equipmentBag;
    this.armory = armory;

    Player player1 = this.players.get(0);
    Player player2 = this.players.get(1);

  }

  public String assignGears(String type) {
    Player player1 = this.players.get(0);
    Player player2 = this.players.get(1);
    ArrayList<Gear> player1Gears = equipmentBag.getGears(type);
    ArrayList<Gear> filteredPlayer1Gears = this.filterGears(player1Gears);
    Collections.sort(filteredPlayer1Gears);
    player1.setGears(filteredPlayer1Gears);

    //Make sure that two players use different gears.
    ArrayList<Gear> player2Gears = equipmentBag.getRemainGears(player1Gears);
    ArrayList<Gear> filteredPlayer2Gears = this.filterGears(player2Gears);
    Collections.sort(filteredPlayer2Gears);
    player2.setGears(filteredPlayer2Gears);

    player1.setHealth(player1.getEnhancedStrength() + player1.getEnhancedConstitution() +
            player1.getEnhancedDexterity() + player1.getEnhancedCharisma());

    player2.setHealth(player2.getEnhancedStrength() + player2.getEnhancedConstitution() +
            player2.getEnhancedDexterity() + player2.getEnhancedCharisma());

    return String.format("Gears for Player1: \n %s \n Gears for Player2: \n %s \n"
            , filteredPlayer1Gears, filteredPlayer2Gears);
  }

  private ArrayList<Gear> filterGears(ArrayList<Gear> playerGears) {
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
          case SMALL -> beltUnit += 1;
          case MEDIUM -> beltUnit += 2;
          case LARGE -> beltUnit += 4;
        }

        if (beltUnit <= 10) {
          filteredGears.add(gear);
        }else {
          isBeltFull = true;
        }
      } else if (gear instanceof Potion){
        filteredGears.add(gear);
      }else {
        continue;
      }
    }

    return filteredGears;
  }

  public String assignWeapon(String type) {
    Player player1 = this.players.get(0);
    Player player2 = this.players.get(1);

    ArrayList<Weapon> weapons1 = this.getOneWeapon(type);
    ArrayList<Weapon> weapons2 = this.getOneWeapon(type);

    //Make sure that two players will get different weapons.
    while (weapons2.equals(weapons1)) {
      weapons2 = this.getOneWeapon(type);
    }

    player1.setWeapon(weapons1);
    player2.setWeapon(weapons2);

    return String.format("Weapon for Player1: %s\n Weapon for Player2: %s"
            , weapons1.toString(), weapons2.toString());
  }

  private ArrayList<Weapon> getOneWeapon(String type) {
    ArrayList<Weapon> weapons = new ArrayList<>();
    Weapon weapon = armory.getOneWeapon(type);
    weapons.add(weapon);
    if (weapon instanceof Katanas) {
      Weapon weapon2 = armory.getOneWeapon(type);
      if (weapon2 instanceof Katanas) {
        weapons.add(weapon2);
      }
    }
    return weapons;
  }

  public String fight(String type) {
    String fightInfo = "";

    Player player1 = this.players.get(0);
    Player player2 = this.players.get(1);

    while (player1.getHealth() > 0 && player2.getHealth() > 0) {
      if (player1.getEnhancedCharisma() >= player2.getEnhancedCharisma()) {
        fightInfo += this.attack(player1, player2, type);
        fightInfo += this.attack(player2, player1, type);
      } else {
        fightInfo += this.attack(player2, player1, type);
        fightInfo += this.attack(player1, player2, type);
      }
    }

    if (player1.getHealth() <= 0) {
      fightInfo += String.format("Player %s is the winner.\n", player2.getName());
    } else {
      fightInfo += String.format("Player %s is the winner.\n", player1.getName());
    }

    return fightInfo;
  }

  private String attack(Player firstHand, Player secondHand, String type) {
    String attackInfo = "";
    if (firstHand.getStrikingPower(type) > secondHand.getAvoidanceAbility(type)) {
      int actualDamage = firstHand.getPotentialDamage(type) - secondHand.getConstitution();
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
