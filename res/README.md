## 1. About
This is a model that implement a turn-based game. This model can create 
two players with random abilities. The two players can also get some gears
from an equiment bag and get one weapon separately from one armory.
The equipment bag has 40 gears and the armory has 10 weapons by default.
After wearing gears and getting weapons, they could fight with them or they just
fight barely using their hands. The model will output some fighting information
and the result the fight. Finally, users can use a keyboard input to decide
whether their want the two players using different gears and weapons to fight again.

## 2.Features
- Create two players
- Assign Weapons randomly
- Assign gears randomly
- Output basic information of two player
- Output gears and weapon information of the two player
- Calculate two players' enhanced attributes
- Make two players fight and get the fighting information and result.
- Rematch

## 3.How to run
(1) Open the CMD on Windows or Terminal on Linux and Mac.

(2) Go to the place you store Project2.jar using cd or dir.

(3) Type this command and press Enter.
```
Java -jar Project2.jar
```

## 4. How to use
(1) Follow step 3 above.

(2) After one match, you could press "y" and then press Enter to
have a new match. Or you can press other letters and then press Enter 
to exit this program.

## 5.Example
(1) Automatically create two players and assign them gears and weapons randomly.

(2) Make them fight and output their fighting information.

(3) Request a key input from the user.

(4) Hold a new match or exit the program.

## 6. Designs
(1) I add two field in Player class to help assign gears and weapons to players.

(2) Made every damage of an attack cause by a weapon random.  

## 7.Limitations
Weapons and Gears are hardcode in the constructors.

## 8. Assumptions
(1) Gears and Weapons are fixed.

(2) When finished a fight, the players' health will roll back and
new gears and weapons will assign to them to help them fight again.

## 9.Citations
Factory Method: https://www.geeksforgeeks.org/factory-method-design-pattern-in-java/