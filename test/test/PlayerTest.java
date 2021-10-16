package test;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import battle.Battle;
import battle.Player;
import battle.euipments.Bag;
import battle.weapons.Armory;

import static org.junit.Assert.assertEquals;

/**
 * A class that is used to test Player class.
 */
public class PlayerTest {
  private Player player;
  private Player player2;
  private final String randomType = "FalseRandom";

  @Before
  public void setUp() throws Exception {
    player = new Player("Bang Liu", randomType);
    player2 = new Player("Yu Xiang", randomType);
  }

  @Test
  public void getName() {
    assertEquals("Bang Liu", player.getName());
  }

  @Test
  public void getStrength() {
    assertEquals(6, player.getStrength());
  }

  @Test
  public void getConstitution() {
    assertEquals(6, player.getConstitution());
  }

  @Test
  public void getDexterity() {
    assertEquals(6, player.getDexterity());
  }

  @Test
  public void getCharisma() {
    assertEquals(6, player.getCharisma());
  }

  @Test
  public void getHealth() {
    assertEquals(24, player.getHealth());
  }

  @Test
  public void getEnhancedStrength() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    assertEquals(19, player.getEnhancedStrength());
    assertEquals(16, player2.getEnhancedStrength());
  }

  @Test
  public void getEnhancedConstitution() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    assertEquals(17, player.getEnhancedConstitution());
    assertEquals(17, player.getEnhancedConstitution());
  }

  @Test
  public void getEnhancedDexterity() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    assertEquals(2, player.getEnhancedDexterity());
    assertEquals(14, player2.getEnhancedDexterity());
  }

  @Test
  public void getEnhancedCharisma() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    assertEquals(111, player.getEnhancedCharisma());
    assertEquals(1013, player2.getEnhancedCharisma());
  }

  @Test
  public void getStrikingPower() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    //Striking Power = this.getEnhancedStrength() + rand(1, 10)
    assertEquals(29, player.getStrikingPower(randomType));
    assertEquals(26, player2.getStrikingPower(randomType));
  }

  @Test
  public void getAvoidanceAbility() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    //AvoidanceAbility = this.getEnhancedDexterity() + rand(1, 6)
    assertEquals(8, player.getAvoidanceAbility(randomType));
    assertEquals(20, player2.getAvoidanceAbility(randomType));
  }

  @Test
  public void getPotentialDamage() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    //Potential Damage = this.getEnhancedStrength() + weaponDamage and mind two special weapons.
    assertEquals(25, player.getPotentialDamage(randomType));
    assertEquals(16, player2.getPotentialDamage(randomType));
  }

  @Test
  public void playerBasicInfo() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    assertEquals("Name: Bang Liu, Strength: 6, Constitution: 6, Dexterity: 6, Charisma: 6",
            player.playerBasicInfo());
    assertEquals("Name: Yu Xiang, Strength: 6, Constitution: 6, Dexterity: 6, Charisma: 6",
            player2.playerBasicInfo());
  }

  @Test
  public void playerEnhancedInfo() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    assertEquals("Name: Bang Liu, Strength: 19, Constitution: 17," +
            " Dexterity: 2, Charisma: 111 Health: 149 StrikingPower: 29 AvoidAbility: 8",
            player.playerEnhancedInfo(randomType));

    assertEquals("Name: Yu Xiang, Strength: 16," +
                    " Constitution: 1, Dexterity: 14," +
                    " Charisma: 1013 Health: 1044 StrikingPower: 26 AvoidAbility: 20",
            player2.playerEnhancedInfo(randomType));
  }

  @Test
  public void setHealth() {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory(randomType);

    Battle battle = new Battle(players, equipmentBag, armory);

    battle.assignGears(randomType);
    battle.assignWeapon(randomType);

    assertEquals(149, player.getHealth());
    player.setHealth(12);
    assertEquals(12, player.getHealth());
  }
}