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
 * A class that is used to test Battle class.
 */
public class BattleTest {
  private Battle battle;

  @Before
  public void setUp() throws Exception {
    ArrayList<Player> players = new ArrayList<>();
    Player player1 = new Player("Bang Liu", "FalseRandom");
    Player player2 = new Player("Yu Xiang", "FalseRandom");
    players.add(player1);
    players.add(player2);

    Bag equipmentBag = new Bag();

    Armory armory = new Armory("FalseRandom");

    battle = new Battle(players, equipmentBag, armory);
  }

  @Test
  public void assignGears() {
    String gearsInfo = "Gears for Player1: \n" +
            " [Gear{Type = class battle.euipments.Headgear, " +
            "name='fighting headgear', affectedAttrs=[0, 2, 0, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='alcohol', affectedAttrs=[0, 0, -5, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='large blood medicine', affectedAttrs=[0, 1, 0, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion, " +
            "name='large charming medicine', affectedAttrs=[0, 0, 0, 99]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='large dexterity medicine', affectedAttrs=[0, 0, 6, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion, " +
            "name='medium charming medicine', affectedAttrs=[0, 0, 0, 1]}\n" +
            ", Gear{Type = class battle.euipments.Potion, " +
            "name='small blood medicine', affectedAttrs=[0, 1, 0, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion, " +
            "name='strong medicine', affectedAttrs=[6, 0, 0, 0]}\n" +
            ", Gear{Type = class battle.euipments.Belt," +
            " name='garbage belt', affectedAttrs=[7, 1, 0, 0]}\n" +
            "BeltSize = MEDIUM\n" +
            ", Gear{Type = class battle.euipments.Belt, " +
            "name='gold belt', affectedAttrs=[0, 2, 3, 0]}\n" +
            "BeltSize = MEDIUM\n" +
            ", Gear{Type = class battle.euipments.Belt," +
            " name='lovely belt', affectedAttrs=[0, 0, 1, 0]}\n" +
            "BeltSize = SMALL\n" +
            ", Gear{Type = class battle.euipments.Belt," +
            " name='power belt', affectedAttrs=[0, 4, 1, 0]}\n" +
            "BeltSize = LARGE\n" +
            ", Gear{Type = class battle.euipments.Belt," +
            " name='silk belt', affectedAttrs=[0, 0, 0, 5]}\n" +
            "BeltSize = SMALL\n" +
            ", Gear{Type = class battle.euipments.Footwear," +
            " name='cumbersome footwear', affectedAttrs=[0, 0, -10, 0]}\n" +
            "] \n" +
            " Gears for Player2: \n" +
            " [Gear{Type = class battle.euipments.Headgear," +
            " name='stupid headgear', affectedAttrs=[0, -1, 0, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion, " +
            "name='APTX 4869', affectedAttrs=[0, 0, 0, 999]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='medium dexterity medicine', affectedAttrs=[0, 0, 3, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='painKiller', affectedAttrs=[0, 3, 0, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='small charming medicine', affectedAttrs=[0, 0, 0, 1]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='small dexterity medicine', affectedAttrs=[0, 0, 1, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='strength medicine', affectedAttrs=[3, 0, 0, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='toxic', affectedAttrs=[0, -1, 0, 0]}\n" +
            ", Gear{Type = class battle.euipments.Potion," +
            " name='trioxide', affectedAttrs=[-2, 0, 0, 0]}\n" +
            ", Gear{Type = class battle.euipments.Belt, " +
            "name='heavy belt', affectedAttrs=[9, 0, 0, 9]}\n" +
            "BeltSize = LARGE\n" +
            ", Gear{Type = class battle.euipments.Belt, " +
            "name='poor belt', affectedAttrs=[0, -1, 0, -2]}\n" +
            "BeltSize = LARGE\n" +
            ", Gear{Type = class battle.euipments.Belt," +
            " name='tight belt', affectedAttrs=[0, -5, 0, 0]}\n" +
            "BeltSize = SMALL\n" +
            ", Gear{Type = class battle.euipments.Footwear, " +
            "name='firm footwear', affectedAttrs=[0, 0, 4, 0]}\n" +
            "] \n";
    assertEquals(gearsInfo, battle.assignGears("FalseRandom"));
  }

  @Test
  public void assignWeapon() {
    assertEquals("Weapon for Player1: [Weapon{name='powerful flail', damage=12}]\n" +
            " Weapon for Player2: [Weapon{name='sharp katanas', damage=6}]",
            battle.assignWeapon("FalseRandom"));
  }

  @Test
  public void fight() {
    //TODO:Failed this test.
    assertEquals("Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "Player Bang Liu attack Player Yu Xiang and the damage is:0\n" +
            "Player Yu Xiang attack Player Bang Liu and the damage is:0\n" +
            "The match come to a draw.", battle.fight("FalseRandom"));
  }
}