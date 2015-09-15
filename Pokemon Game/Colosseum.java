/* -----------------------------------------------------------------------------
 * File Name: Colosseum.java
 * Author: Alec Knutsen, a991k109@ku.edu
 * Assignment:   EECS-168/169 Homework 3
 * Description:  This class will allow two users to create a pokemon and to fight the pokemon. The user will be prompted to play again. If they fight again, they will create a new pokemon to fight the winner.
 * Date: October 31, 2014
 ---------------------------------------------------------------------------- */
import java.util.Scanner;
public class Colosseum {
	public static void main(String[] args) {
		int count_rounds = 0;
		Scanner input = new Scanner(System.in);
		Pokemon Pokemon1 = new Pokemon(); // Creates a new Pokemon object called Pokemon1
		Pokemon Pokemon2 = new Pokemon(); // Creates a new Pokemon object called Pokemon2
		Pokemon Winner_Pokemon = Pokemon1; // Creates a new Pokemon object called Winner_Pokemon. Winner_Pokemon will go on to fight again. Winner_Pokemon will by default be the first-most pokemon created if there is a draw
		Dice d2 = new Dice(2); // Creates a new dice object with two sides
		System.out.println("Player 1, build your Pokemon!");
		System.out.println("=====================");
		Pokemon1.userBuild(); // Calls the userbuild method if the Pokemon class to let the user create the first pokemon
		System.out.println("Player 2, build your Pokemon!");
		System.out.println("=====================");
		Pokemon2.userBuild(); // Calls the userbuild method if the Pokemon class to let the user create the second pokemon
		System.out.println(Pokemon1.getName() + " will roll a D2, to decides who goes first.");
		int roll = d2.roll(); // Uses the roll method of the dice class to get an integer between 1 and 2
		System.out.print(Pokemon1.getName() + " rolls a " + roll);
		if (roll == 1) { // This if statement runs if the dice roll is a 1, implying that the first pokemon created goes first
			count_rounds = 0; // This variable will hold the round count. We initially set it to 0
			System.out.println(", so " + Pokemon1.getName() + " will go first.");
			for (int i = 1; i <=10; i++) { // This for loop will run ten times, making the pokemon fight for ten rounds
				System.out.println("");
				System.out.println("Round " + i + "!");
				System.out.println("");
				if (Pokemon1.attack(Pokemon2)) { // This if statement will run the attack method of the Pokemon class. Pokemon1 attacks Pokemon2. If the attack method returns true, Pokemon2 has been defeated and the loop breaks
					break;
				}
				else if (Pokemon2.attack(Pokemon1)) { // This else if statement will run the attack method of the Pokemon class. Pokemon2 attacks Pokemon1. If the attack method returns true, Pokemon1 has been defeated, the winner is set to Pokemon2, and the loop breaks
					Winner_Pokemon = Pokemon2;
					break;
				}
				count_rounds++; // This increments the round count
			}
		}
		else { // This else statement runs if the dice roll is a 2, implying that the second pokemon created goes first
			count_rounds = 0; // This variable will hold the round count. We initially set it to 0
			System.out.println(", so " + Pokemon2.getName() + " will go first.");
			for (int i = 1; i <=10; i++) { // This for loop will run ten times, making the pokemon fight for ten rounds
				System.out.println("");
				System.out.println("Round " + i + "!");
				System.out.println("");
				if (Pokemon2.attack(Pokemon1)) { // This if statement will run the attack method of the Pokemon class. Pokemon2 attacks Pokemon1. If the attack method returns true, Pokemon1 has been defeated, the winner is set to Pokemon2, and the loop breaks
					Winner_Pokemon = Pokemon2;
					break;
				}
				else if (Pokemon1.attack(Pokemon2)) { // This else if statement will run the attack method of the Pokemon class. Pokemon1 attacks Pokemon2. If the attack method returns true, Pokemon2 has been defeated and the loop breaks
					break;
				}
				count_rounds++; // This increments the round count
			}
		}
		if (count_rounds == 10) { // This if statement runs if the pokemon fight for 10 rounds. This if statement will run to show the user the battle was a draw
			System.out.println("Both fighters are still standing!It's a draw!");
			System.out.println("Since there is no winner, the first pokemon created will fight again.");
		}
		System.out.println("");
		System.out.print("Do you want to create a new pokemon and fight against the winner? Enter Y for Yes and N for No!"); // Prompts the user if they want to play again
		String answer = input.next(); // Holds the user input 
		while (answer.equalsIgnoreCase("Y")) { // If the user wants to play again, this loop will keep running
			Pokemon New_Pokemon = new Pokemon(); // Creates a new object of the Pokemon class each time the loop runs. 
			Winner_Pokemon.setUpgradedAttack(Winner_Pokemon.getAttack()); // Resets the previous winner's attack points
			Winner_Pokemon.setUpgradedDefense(Winner_Pokemon.getDefense()); // Resets the previous winner's defense points
			Winner_Pokemon.setUpdatedHP(Winner_Pokemon.getHP()); // Resets the previous winner's health points.
			System.out.println("");
			System.out.println("New Player, build your Pokemon!");
			System.out.println("=====================");
			New_Pokemon.userBuild(); // Calls the userbuild method of the pokemon class to allow the user to customize a new pokemon each time the loop runs
			System.out.println(Winner_Pokemon.getName() + " will roll a D2, to decides who goes first.");
			int new_roll = d2.roll(); // Uses the roll method of the dice class to get an integer between 1 and 2
			System.out.print(Winner_Pokemon.getName() + " rolled a " + new_roll);
			if (new_roll == 1) { // This if statement runs if the dice roll is a 1, implying that the previous winner goes first
				count_rounds = 0; // This variable will hold the round count. We initially set it to 0
				System.out.println(", so " + Winner_Pokemon.getName() + " will go first.");
				for (int i = 1; i <=10; i++) { // This for loop will run ten times, making the pokemon fight for ten rounds
					System.out.println("");
					System.out.println("Round " + i + "!");
					System.out.println("");
					if (Winner_Pokemon.attack(New_Pokemon)) { // This if statement will run the attack method of the Pokemon class. The previous winner attacks the new pokemon. If the attack method returns true, new pokemon has been defeated and the loop breaks
						break;
					}
					else if (New_Pokemon.attack(Winner_Pokemon)) { // This else if statement will run the attack method of the Pokemon class. The new pokemon attacks the previous winner. If the attack method returns true, the previous winner has been defeated, the loop breaks, and the new pokemon becomes winner_pokemon
						Winner_Pokemon = New_Pokemon;
						break;
					}
					count_rounds ++; // This increments the round count
				}
			}
			else {
				count_rounds = 0; // This variable will hold the round count. We initially set it to 0
				System.out.println(", so " + New_Pokemon.getName() + " will go first.");
				for (int i = 1; i <=10; i++) { // This for loop will run ten times, making the pokemon fight for ten rounds
					System.out.println("");
					System.out.println("Round " + i + "!");
					System.out.println("");
					if (New_Pokemon.attack(Winner_Pokemon)) { // This if statement will run the attack method of the Pokemon class. The new pokemon attacks the previous winner. If the attack method returns true, the previous winner has been defeated, the loop breaks, and the new pokemon becomes winner_pokemon
						Winner_Pokemon = New_Pokemon;
						break;
					}
					else if (Winner_Pokemon.attack(New_Pokemon)) { // This if statement will run the attack method of the Pokemon class. The previous winner attacks the new pokemon. If the attack method returns true, new pokemon has been defeated and the loop breaks
						break;
					}
					count_rounds++; // This if statement will run the attack method of the Pokemon class. The previous winner attacks the new pokemon. If the attack method returns true, new pokemon has been defeated and the loop breaks
				}
			}
			if (count_rounds == 10) { // This if statement runs if the pokemon fight for 10 rounds. This if statement will run to show the user the battle was a draw
				System.out.println("Both fighters are still standing!It's a draw!");
				System.out.println("Since there is no winner, the first pokemon created will fight again.");
			}
			System.out.println("");
			System.out.print("Do you want to create a new pokemon and fight against the winner? Enter Y for Yes and N for No!"); // Prompts the user if they want to play again
			answer = input.next(); // Holds the user input 
		}
		System.out.println("Thank you for playing!");
	}
}