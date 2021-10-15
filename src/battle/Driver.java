package battle;

import java.util.ArrayList;
import java.util.Scanner;

import battle.euipments.Bag;
import battle.weapons.Armory;

public class Driver {
  private static void match(Player player1, Player player2) {
    ArrayList<Player> players = new ArrayList<>();
    players.add(player1);
    players.add(player2);

    System.out.println("This is the basic information of two players: \n");
    System.out.println("The basic information for player1: ");
    System.out.println(player1.playerBasicInfo());
    System.out.println("\n");
    System.out.println("The basic information for player2: ");
    System.out.println(player2.playerBasicInfo());
    System.out.println("\n");

    Bag equipmentBag = new Bag();
    Armory armory = new Armory("RealRandom");
    Battle battle = new Battle(players, equipmentBag, armory);

    System.out.println("Gears information for two players: ");
    System.out.println(battle.assignGears("RealRandom"));
    System.out.println("\n");

    System.out.println("Weapons information for two players: ");
    System.out.println(battle.assignWeapon("RealRandom"));
    System.out.println("\n");

    System.out.println("The information for two players when they wear gears and use a weapon: \n");

    System.out.println("The information for the first player: ");
    System.out.println(player1.playerEnhancedInfo());
    System.out.println("\n");

    System.out.println("The information for the second player: ");
    System.out.println(player2.playerEnhancedInfo());

    System.out.println("The information when they fight: \n");
    System.out.println(battle.fight("RealRandom"));

    System.out.println("\n");
    System.out.println("Do you want to rematch? If yes press y, preess other keys to quit.");

    Scanner keyInput = new Scanner(System.in);
    while (keyInput.nextLine().equals("y")) {
      player1.setHealth(player1.getEnhancedStrength() + player1.getEnhancedConstitution()
              + player1.getEnhancedDexterity() + player1.getEnhancedCharisma());

      player2.setHealth(player2.getEnhancedStrength() + player2.getEnhancedConstitution()
              + player2.getEnhancedDexterity() + player2.getEnhancedCharisma());

      match(player1, player2);
    }
  }


  public static void main(String[] args) {
    System.out.println("Once upon a time, there were two outstanding man with superior military ability." +
            "One is called Bang Liu, another one is called Yu Xiang. They fight for their faith and" +
            "the throne. Let's see who will have a good luck and win the match");

    Player player1 = new Player("Bang Liu");
    Player player2 = new Player("Yu Xiang");

    match(player1, player2);
  }
}
