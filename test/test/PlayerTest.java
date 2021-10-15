package test;

import org.junit.Before;
import org.junit.Test;

import battle.Player;

import static org.junit.Assert.*;

public class PlayerTest {
  private Player player;

  @Before
  public void setUp() throws Exception {
    player = new Player("Bang Liu");
  }

  @Test
  public void getName() {
    assertEquals("Bang Liu", player.getName());
  }

  @Test
  public void getStrength() {
  }

  @Test
  public void getConstitution() {
  }

  @Test
  public void getDexterity() {
  }

  @Test
  public void getCharisma() {
  }

  @Test
  public void getHealth() {
  }

  @Test
  public void getEnhancedStrength() {
  }

  @Test
  public void getEnhancedConstitution() {
  }

  @Test
  public void getEnhancedDexterity() {
  }

  @Test
  public void getEnhancedCharisma() {
  }

  @Test
  public void getStrikingPower() {
  }

  @Test
  public void getAvoidanceAbility() {
  }

  @Test
  public void getPotentialDamage() {
  }

  @Test
  public void setWeapon() {
  }

  @Test
  public void setGears() {
  }

  @Test
  public void playerBasicInfo() {
  }

  @Test
  public void playerEnhancedInfo() {
  }

  @Test
  public void setHealth() {
  }
}