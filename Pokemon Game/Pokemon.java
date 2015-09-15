/* -----------------------------------------------------------------------------
 * File Name: Pokemon.java
 * Author: Alec Knutsen, a991k109@ku.edu
 * Assignment:   EECS-168/169 Homework 3
 * Description:  This class contains one constructor and two methods. The constructor initializes all the private variables.
 * One method allows the user to build a pokemon.
 * The other method makes a pokemon attack another pokemon.
 * Date: October 31, 2014
 ---------------------------------------------------------------------------- */
import java.util.Scanner;
public class Pokemon {
	Scanner input = new Scanner(System.in);
	private int original_hp, updated_hp, original_attack_level, upgraded_attack_level, original_defense_level, upgraded_defense_level;
	private String name;
	private Dice d6, d20;
	
	/* 
	 * Constructor that sets three of our private variables to 0, our private String variable to the empty string, and creates two instances of our dice class.
	 * @param No parameters
	 * @return No return value
	 */
	Pokemon() {
		original_hp = 0;
		original_attack_level = 0;
		original_defense_level = 0;
		name = "";
		d6 = new Dice(6);
		d20 = new Dice(20);
		
		/* 
		 * We have seven set methods to set values for our seven private variables
		 * @param int sides - Each set method takes a parameter. The value of our seven private variables is assigned to the parameter.
		 * @return No return value
		 */
	}
	public void setHP(int h_p) {
		original_hp = h_p;
	}
	public void setUpdatedHP(int nhp) {
		updated_hp = nhp;
	}
	public void setAttack(int attack) {
		original_attack_level = attack;
	}
	public void setUpgradedAttack(int ua){
		upgraded_attack_level = ua;
	}
	public void setDefense(int defense) {
		original_defense_level = defense;
	}
	public void setUpgradedDefense(int ud) {
		upgraded_defense_level = ud;
	}
	public void setName(String Name) {
		name = Name;
	}
	
	/* 
	 * We have seven get methods to return values for our seven private variables
	 * @param No parameters
	 * @return Each get method return the value for our seven private variables
	 */
	public int getHP() {
		return(original_hp);
	}
	public int getUpdatedHP() {
		return(updated_hp);
	}
	public int getAttack() {
		return(original_attack_level);
	}
	public int getUpgradedAttack() {
		return(upgraded_attack_level);
	}
	public int getDefense() {
		return(original_defense_level);
	}
	public int getUpgradedDefense() {
		return(upgraded_defense_level);
	}
	public String getName() {
		return name;
	}
	
	/* 
	 * The attack method is used to make two pokemon fight.
	 * @param Pokemon opponent - The parameter is the opponent of the Pokemon for which the method is called.
	 * @return boolean - The method returns a boolean which allows us to tell when the fighting has ended.
	 */
	public boolean attack(Pokemon opponent) {
		if (upgraded_attack_level != original_attack_level + 5 && upgraded_defense_level != original_defense_level + 5) { // This if statement will run if the user has not upgraded attack or defense. It will prompt the user if they want to upgrade attack or defense.
			System.out.println("Do you want " + name + " to cast a spell to increase attack level by five points, to cast a spell to increase defense level by five points, or to preform a physical attack?");
			System.out.print("Enter AL to increase attack level, DL to increase defense level. Enter anything else to preform a physical attack: ");
			String answer = input.next();
			System.out.println("");
			if (answer.equalsIgnoreCase("AL")) { // This if statement will run if the user enters input for increasing attack level
				System.out.println("You're attack level has been upgraded from " + original_attack_level + " to " + (original_attack_level + 5)); 
				System.out.println("");
				setUpgradedAttack(original_attack_level + 5);
				System.out.println("");
				return(false);
			}
			else if (answer.equalsIgnoreCase("DL")) { // This if statement will run if the user enters input for increasing defense level
				System.out.println("You're defense level has been upgraded from " + original_defense_level + " to " + (original_defense_level + 5));
				System.out.println("");
				setUpgradedDefense(original_defense_level + 5);
				System.out.println("");
				return(false);
			}
			else { // This else statement runs if the user enters anything besides AL and DL. It will make the pokemon fight.
				System.out.println(name + " is attacking " + opponent.getName());
				int attack_bonus = d20.roll(); // We use the roll method of the dice class to get a number between 1 and 20 for the attack bonus
				System.out.println(name + " rolls an attack bonus of " + attack_bonus);
				int defense_bonus = d20.roll(); // We use the roll method of the dice class to get a number between 1 and 20 for the defense bonus
				System.out.println(opponent.getName() + " rolls a defense bonus of " + defense_bonus);
				if (upgraded_attack_level + attack_bonus > opponent.getUpgradedDefense() + defense_bonus) { // This if statement runs if the pokemon has a succesful attack against the opponent. In this if statement, the opponent will lose hp.
					System.out.println("The attack hits dealing 3-D6 damage!");
					int roll1 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
					int roll2 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
					int roll3 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
					System.out.println("The rolls are " + roll1 + ", " + roll2 + ", and " + roll3 + " totaling " + (roll1 + roll2 + roll3) + " damage!");
					opponent.setUpdatedHP((opponent.getUpdatedHP()-(roll1+roll2+roll3))); // This adjusts the opponent's hp based on how much damage they lost
					if (opponent.getUpdatedHP() <= 0) { // This if statement runs if the opponent has lost all there hp, and ends the game
						System.out.println(opponent.getName() + " has 0 hit points left");
						System.out.println(opponent.getName() + " has been defeated!");
						System.out.println("");
						return(true);
					}
					else { // This else statement runs if the opponent has been attacked and lost hp, but has not run out of hp yet
					System.out.println(opponent.getName() + " has " + opponent.getUpdatedHP()  + " hit points left");
					System.out.println("");
					return(false);
					}
				}
				else { // This else statement runs if the attack of the pokemon was unsuccessful
					System.out.println("The attack missed!");
					System.out.println("");
					return(false);
				}
			}
		}
		else if (upgraded_attack_level != original_attack_level + 5 && upgraded_defense_level == original_defense_level + 5) { // This else if statement runs if the user has upgraded defense, but not attack. It prompts the user if they want to upgrade attack.
			System.out.println("Do you want " + name + " to cast a spell to increase attack level by five points, or or to preform a physical attack?");
			System.out.print("Enter AL to increase attack level. Enter anything else to preform a physical attack: ");
			String answer = input.next();
			System.out.println("");
			if (answer.equalsIgnoreCase("AL")) { // This if statement will run if the user enters input for increasing attack level
				System.out.println("You're attack level has been upgraded from " + original_attack_level + " to " + (original_attack_level + 5)); 
				System.out.println("");
				setUpgradedAttack(original_attack_level + 5);
				System.out.println("");
				return(false);
			}
			else { // This else statement runs if the user enters anything besides AL to increase attack. It will make the pokemon fight.
				System.out.println(name + " is attacking " + opponent.getName());
				int attack_bonus = d20.roll(); // We use the roll method of the dice class to get a number between 1 and 20 for the attack bonus
				System.out.println(name + " rolls an attack bonus of " + attack_bonus);
				int defense_bonus = d20.roll(); // We use the roll method of the dice class to get a number between 1 and 20 for the defense bonus
				System.out.println(opponent.getName() + " rolls a defense bonus of " + defense_bonus);
				if (upgraded_attack_level + attack_bonus > opponent.getUpgradedDefense() + defense_bonus) { // This if statement runs if the pokemon has a succesful attack against the opponent. In this if statement, the opponent will lose hp.
					System.out.println("The attack hits dealing 3-D6 damage!");
					int roll1 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
					int roll2 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
					int roll3 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
					System.out.println("The rolls are " + roll1 + ", " + roll2 + ", and " + roll3 + " totaling " + (roll1 + roll2 + roll3) + " damage!");
					opponent.setUpdatedHP((opponent.getUpdatedHP()-(roll1+roll2+roll3))); // This adjusts the opponent's hp based on how much damage they lost
					if (opponent.getUpdatedHP() <= 0) { // This if statement runs if the opponent has lost all there hp, and ends the game
						System.out.println(opponent.getName() + " has 0 hit points left");
						System.out.println(opponent.getName() + " has been defeated!");
						System.out.println("");
						return(true);
					}
					else { // This else statement runs if the opponent has been attacked and lost hp, but has not run out of hp yet
					System.out.println(opponent.getName() + " has " + opponent.getUpdatedHP()  + " hit points left");
					System.out.println("");
					return(false);
					}
				}
				else { // This else statement runs if the attack of the pokemon was unsuccessful
					System.out.println("The attack missed!");
					System.out.println("");
					return(false);
				}
			}
		}
		else if (upgraded_attack_level == original_attack_level + 5 && upgraded_defense_level != original_defense_level + 5) { // This else if statement runs if the user has upgraded the attack level, but not the defense level. It will ask the user if they want to increase defense level
			System.out.println("Do you want " + name + " to cast a spell to increase defense level by five points, or or to preform a physical attack?");
			System.out.print("Enter DL to increase defense level. Enter anything else to preform a physical attack: ");
			String answer = input.next();
			System.out.println("");
			if (answer.equalsIgnoreCase("DL")) { // This if statement will run if the user enters input for increasing defense level
				System.out.println("You're defense level has been upgraded from " + original_defense_level + " to " + (original_defense_level + 5)); 
				System.out.println("");
				setUpgradedDefense(original_defense_level + 5);
				System.out.println("");
				return(false);
			}
			else { // This else statement runs if the user enters anything besides DL for increasing defense level. It will make the pokemon fight.
				System.out.println(name + " is attacking " + opponent.getName());
				int attack_bonus = d20.roll(); // We use the roll method of the dice class to get a number between 1 and 20 for the attack bonus
				System.out.println(name + " rolls an attack bonus of " + attack_bonus);
				int defense_bonus = d20.roll(); // We use the roll method of the dice class to get a number between 1 and 20 for the defense bonus
				System.out.println(opponent.getName() + " rolls a defense bonus of " + defense_bonus);
				if (upgraded_attack_level + attack_bonus > opponent.getUpgradedDefense() + defense_bonus) { // This if statement runs if the pokemon has a succesful attack against the opponent. In this if statement, the opponent will lose hp.
					System.out.println("The attack hits dealing 3-D6 damage!");
					int roll1 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
					int roll2 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
					int roll3 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
					System.out.println("The rolls are " + roll1 + ", " + roll2 + ", and " + roll3 + " totaling " + (roll1 + roll2 + roll3) + " damage!");
					opponent.setUpdatedHP((opponent.getUpdatedHP()-(roll1+roll2+roll3))); // This adjusts the opponent's hp based on how much damage they lost
					if (opponent.getUpdatedHP() <= 0) { // This if statement runs if the opponent has lost all there hp, and ends the game
						System.out.println(opponent.getName() + " has 0 hit points left");
						System.out.println(opponent.getName() + " has been defeated!");
						System.out.println("");
						return(true);
					}
					else { // This else statement runs if the opponent has been attacked and lost hp, but has not run out of hp yet
					System.out.println(opponent.getName() + " has " + opponent.getUpdatedHP()  + " hit points left");
					System.out.println("");
					return(false);
					}
				}
				else { // This else statement runs if the attack of the pokemon was unsuccessful
					System.out.println("The attack missed!");
					System.out.println("");
					return(false);
				}
			}
		}
		else { // This else statement runs if the user has upgraded attack level and defense level. It will automate the fight
			System.out.println(name + " is attacking " + opponent.getName());
			int attack_bonus = d20.roll(); // We use the roll method of the dice class to get a number between 1 and 20 for the attack bonus
			System.out.println(name + " rolls an attack bonus of " + attack_bonus);
			int defense_bonus = d20.roll(); // We use the roll method of the dice class to get a number between 1 and 20 for the defense bonus
			System.out.println(opponent.getName() + " rolls a defense bonus of " + defense_bonus);
			if (upgraded_attack_level + attack_bonus > opponent.getUpgradedDefense() + defense_bonus) { // This if statement runs if the pokemon has a succesful attack against the opponent. In this if statement, the opponent will lose hp.
				System.out.println("The attack hits dealing 3-D6 damage!");
				int roll1 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
				int roll2 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
				int roll3 = d6.roll(); // We use the roll method of the dice class to get a random number between 1 and 6
				System.out.println("The rolls are " + roll1 + ", " + roll2 + ", and " + roll3 + " totaling " + (roll1 + roll2 + roll3) + " damage!");
				opponent.setUpdatedHP((opponent.getUpdatedHP()-(roll1+roll2+roll3))); // This adjusts the opponent's hp based on how much damage they lost
				if (opponent.getUpdatedHP() <= 0) { // This if statement runs if the opponent has lost all there hp, and ends the game
					System.out.println(opponent.getName() + " has 0 hit points left");
					System.out.println(opponent.getName() + " has been defeated!");
					System.out.println("");
					return(true);
				}
				else { // This else statement runs if the opponent has been attacked and lost hp, but has not run out of hp yet
				System.out.println(opponent.getName() + " has " + opponent.getUpdatedHP()  + " hit points left");
				System.out.println("");
				return(false);
				}
			}
			else { // This else statement runs if the attack of the pokemon was unsuccessful
				System.out.println("The attack missed!");
				System.out.println("");
				return(false);
			}
		}
	}
	
	/* 
	 * The userBuild method interacts with the user to allow the user to name, to set the heath points, to set the attack points, and to set the defense points of the pokemon. The user must enter valid input to continue
	 * @param No parameters
	 * @return No return value
	 */
	public void userBuild() {
		System.out.print("Please name your pokemon: ");
		name = input.next();
		System.out.println("");
		System.out.print("How many hit points will it have? (1-50): ");
		original_hp = input.nextInt(); // Stores the user input for hp
		updated_hp = original_hp; // Gives the updated hp the initial value of the user input for hp
		while (original_hp > 50 || original_hp < 1) { // This while loop forces the user to enter an hp between 1 and 50
			System.out.println("");
			System.out.print("Sorry. The hit points must be between 1 and 50: ");
			original_hp = input.nextInt();
			updated_hp = original_hp;
		}
		System.out.println("");
		System.out.println("Split fifty points between attack level and defense level.");
		System.out.print("Enter your attack level (1-49): ");
		original_attack_level = input.nextInt(); // Stores the user input for attack level
		upgraded_attack_level = original_attack_level; // Gives the updated attack level the initial value of the user input for attack level
		while (original_attack_level >= 50 || original_attack_level < 1) { // This while loop forces the user to enter an attack level between 1 and 49
			System.out.println("");
			System.out.print("Sorry. The attack level must be between 1 and 49: ");
			original_attack_level = input.nextInt();
			upgraded_attack_level = original_attack_level;
		}
		System.out.println("");
		System.out.print("Enter your defense level (1-" + (50-original_attack_level) + "):");
		original_defense_level = input.nextInt(); // Stores the user input for defense level
		upgraded_defense_level = original_defense_level; // Gives the updated defense level the initial value of the user input for defense level
		while (original_attack_level + original_defense_level > 50 || original_defense_level < 1) { // This while loop forces the user to enter a defense level between 1 and 50-attack level
			System.out.println("");
			System.out.print("Sorry the defense level must be between 1 and " + (50-original_attack_level) + ":");
			original_defense_level = input.nextInt();
			upgraded_defense_level = original_defense_level;
		}
		System.out.println("");
	}
}