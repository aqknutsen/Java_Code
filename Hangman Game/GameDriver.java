/* 
 * File Name: HangMan.java
 * Author: Ale Knutsen
 * KUID: 2798040
 * Email Address: a991k109@ku.edu
 * Homework Assignment Number: #4
 * Description: This class implements a HangMan game. 
 * Last Change: December 6, 2014
 */
import java.util.Scanner;
public class GameDriver {
	
	/*
	 * The main method runs the hangman game
	 * @param No parameters
	 * @return None
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // We declare an instance of the Scanner Class called input
		System.out.println("");
		System.out.print("Enter a secret word: "); // The user enters a secret_word 
		String secret_word = input.nextLine();
		for (int i =0; i<100; i++) { // We print 100 empty lines so that the secret_word is not scene 
			System.out.println("");
		}
		HangMan HangManTest = new HangMan(secret_word); // We declare a new instance of the HangMan class called HangManTest and pass the user entered secret_word as a parameter
		String word; // This variable is used to hold the word if the user enters a word as a guess 
		while (!(HangManTest.isGameOver())) { // This while loop runs the game as the method GameOver does not return true. If it does, then the user guessed the secret word or is out of guesses
			
			/*
			 * These three print statements display info for the disguised_word, the number of guesses, and the number of misses
			 */
			System.out.println("");
			System.out.println("Guess this: " + HangManTest.getDisguisedWord());
			System.out.println("Guesses so far: " + HangManTest.getGuessCount());
			System.out.println("Misses: " + HangManTest.getMissedMarker());
			
			if ((HangManTest.areWordGuessesAllowed())) { // If the user has not guessed a word yet, this if statement runs. It allows the user to enter a character or a word as a guess
				System.out.print("Enter your guess character or word: "); 
				word = input.nextLine();
				if (word.length() >= 2) { // If the user enters more than two characters, we interpret this as a word
					if (HangManTest.guessWord(word)) { // If the user enters the correct word, they won! The while loop is broken, and the game is over
						System.out.println("Congratulations! You guessed the  secret word: " + word + " in " + HangManTest.getGuessCount() + " guess(es)!");
						break;
					}
					else { // If the user does not enter the right word, this else statement runs
						System.out.println("This is not the correct word.");
						if (word.length()!= HangManTest.getDisguisedWord().length()) { // If the user entered the wrong length, we let them know
							System.out.println("The length is incorrect. Your word had length " + word.length() + " but the secret word has length " + HangManTest.getDisguisedWord().length() + ".");
						}
					}
				}
				else { // If the user enters less than two characters, we interpret this as a character, and this else statement runs
					int x = 0; // This is a useful variable to hold a count. It will help us determine print statements 
					char a = word.charAt(0); // We convert the string to a character at index 0
					for (int i =0;i < HangManTest.getDisguisedWord().length(); i++) { // This for loop checks to see if the user guessed an already found letter
						if (HangManTest.getDisguisedWord().charAt(i) == a) {
							System.out.println("You already guessed that letter!");
							x++; // If the user guessed a found letter already, we increment x by one
							break; // We break the for loop once we know the user has guessed a found letter already
						}
					}
					if (x <1) { // If the user has not entered a guessed, found letter twice, this if statement runs
						if (HangManTest.guessCharacter(a)){ // If the character guessed is found in the secret_word, the guessCharacter method returns true, and this if statement runs
						System.out.println(Character.toLowerCase(a) + " is in the secret word!");
						}
						else{ // If the character guessed is not found in the secret_word, the guessCharacter method returns false, and this else statement runs
							System.out.println(Character.toLowerCase(a) + " is not in the secret word. Death draws closer.");
						}
					}
				}
			}
			else { // If the user has already tried to guess the word, this statement runs. It does not let the user guess a word, only a character
				int x =0;// This is a useful variable to hold a count. It will help us determine print statements 
				System.out.print("Enter your guess character: "); 
				word = input.next(); // Word holds the users guessed character
				while (word.length() > 1) { // This loop does not let the user guess a word. It will keep running until the user only enters one character
					System.out.println("You already entered a word. You must enter a charcter not word!"); 
					System.out.print("Enter your guess character: "); 
					word = input.next();
				}
				char a = word.charAt(0); // Because word is a string, we have to convert it to a character
				for (int i =0;i < HangManTest.getDisguisedWord().length(); i++) { // This for loop checks to see if the user guessed an already found letter
					if (HangManTest.getDisguisedWord().charAt(i) == a) {
						System.out.println("You already guessed that letter!");
						x++; // If the user guessed a found letter already, we increment x by one
						break; // We break the for loop once we know the user has guessed a found letter already
					}
				}
				if (x <1) { // If the user has not entered a guessed, found letter twice, this if statement runs
					if (HangManTest.guessCharacter(a)){  // If the character guessed is found in the secret_word, the guessCharacter method returns true, and this if statement runs
					System.out.println(Character.toLowerCase(a) + " is in the secret word!");
					} 
					else{ // If the character guessed is not found in the secret_word, the guessCharacter method returns false, and this else statement runs
						System.out.println(Character.toLowerCase(a) + " is not in the secret word. Death draws closer.");
					}
				}
			}
		}
		if (HangManTest.getMissesCount()==7  && !(HangManTest.isFound())) { // This method returns true if the user ran out of guesses and they did not find the correct word. The isFound method will return false
			System.out.println("");
			System.out.println("Game Over!");
			System.out.println("You died. Next time, guess as if your life depended on it.");
			
		}
		else if (HangManTest.isFound()){ // This statement runs if the user found the correct word. The isFound method will return true
			System.out.println("");
			System.out.println("Game Over!");
			System.out.println("Congratulations! You guessed the  secret word: " + HangManTest.getDisguisedWord() + " in " + HangManTest.getGuessCount() + " guess(es)!");
		}
		System.out.println("Do you want to play again? (yes/no)"); // We ask the user if they want to play again
		String answer = input.next();
		while (!(answer.equalsIgnoreCase("Yes")) && !(answer.equalsIgnoreCase("No"))) { // If the user does not enter yes or no (case insensitive), the while loop will prompt them to answer yes or no
			System.out.println("Either enter yes or no!");
			System.out.println("Do you want to play again? (yes/no)");
			answer = input.next();
		}
		while (answer.equalsIgnoreCase("Yes")) { // This while loop runs if the user wants to play again.
			System.out.println("");
			System.out.print("Enter a new secret word: "); // We ask the user to enter a new secret word stored in secret_word
			input.nextLine(); 
			secret_word = input.nextLine();
			for (int i =0; i<100; i++) { // We print one-hundred lines so that the secret_word cannot be seen
				System.out.println("");
			}
			HangMan newMan = new HangMan(secret_word); // We create a new instance f the HangMan class called newMan with secret_word as a parameter
			String new_word; // We create a string new_word to hold user guesses
			while (!(newMan.isGameOver()) && !(newMan.isFound())) { // This while loop runs the game as the method GameOver does not return true. If it does, then the user guessed the secret word or is out of guesses
				
				/*
				 * These three print statements display info for the disguised_word, the number of guesses, and the number of misses
				 */
				System.out.println("");
				System.out.println("Guess this: " + newMan.getDisguisedWord());
				System.out.println("Guesses so far: " + newMan.getGuessCount());
				System.out.println("Misses: " + newMan.getMissedMarker());
				
				if ((newMan.areWordGuessesAllowed())) { // If the user has not guessed a word yet, this if statement runs. It allows the user to enter a character or a word as a guess
					System.out.print("Enter your guess character or word: "); 
					new_word = input.nextLine();
					if (new_word.length() >= 2) { // If the user enters more than two characters, we interpret this as a word
						if (newMan.guessWord(new_word)) { // If the user enters the correct word, they won! The while loop is broken, and the game is over
							System.out.println("Congratulations! You guessed the  secret word: " + new_word + " in " + newMan.getGuessCount() + " guess(es)!");
							break;
						}
						else { // If the user does not enter the right word, this else statement runs
							System.out.println("This is not the correct word.");
							if (new_word.length()!= newMan.getDisguisedWord().length()) { // If the user entered the wrong length, we let them know
								System.out.println("The length is incorrect. Your word had length " + new_word.length() + " but the secret word has length " + newMan.getDisguisedWord().length() + ".");
							}
						}
					}
					else { // If the user enters less than two characters, we interpret this as a character, and this else statement runs
						int x =0; // This is a useful variable to hold a count. It will help us determine print statements 
						char a = new_word.charAt(0); // We convert the string new_word to a character at index 0
						for (int i =0;i < newMan.getDisguisedWord().length(); i++) { // This for loop checks to see if the user guessed an already found letter
							if (newMan.getDisguisedWord().charAt(i) == a) {
								System.out.println("You already guessed that letter!");
								x++; // If the user guessed a found letter already, we increment x by one
								break; // We break the for loop once we know the user has guessed a found letter already
							}
						}
						if (x <1) { // If the user has not entered a guessed, found letter twice, this if statement runs
							if (newMan.guessCharacter(a)){ // If the character guessed is found in the secret_word, the guessCharacter method returns true, and this if statement runs
							System.out.println(Character.toLowerCase(a) + " is in the secret word!");
							}
							else{ // If the character guessed is not found in the secret_word, the guessCharacter method returns false, and this else statement runs
								System.out.println(Character.toLowerCase(a) + " is not in the secret word. Death draws closer.");
							}
						}
					}
				}
				else { // If the user has already tried to guess the word, this statement runs. It does not let the user guess a word, only a character
					int x =0; // This is a useful variable to hold a count. It will help us determine print statements 
					System.out.print("Enter your guess character: "); 
					new_word = input.next(); // new_word holds the users guessed character
					while (new_word.length() > 1) { // This loop does not let the user guess a word. It will keep running until the user only enters one character
						System.out.println("You already entered a word. You must enter a charcter not word!"); 
						System.out.print("Enter your guess character: ");
						new_word = input.next();
					}
					char a = new_word.charAt(0); // Because word is a string, we have to convert it to a character
					for (int i =0;i < newMan.getDisguisedWord().length(); i++) { // This for loop checks to see if the user guessed an already found letter
						if (newMan.getDisguisedWord().charAt(i) == a) {
							System.out.println("You already guessed that letter!");
							x++; // If the user guessed a found letter already, we increment x by one
							break; // We break the for loop once we know the user has guessed a found letter already
						}
					}
					if (x <1) { // If the user has not entered a guessed, found letter twice, this if statement runs
						if (newMan.guessCharacter(a)){ // If the character guessed is found in the secret_word, the guessCharacter method returns true, and this if statement runs
						System.out.println(Character.toLowerCase(a) + " is in the secret word!");
						}
						else{ // If the character guessed is not found in the secret_word, the guessCharacter method returns false, and this else statement runs
							System.out.println(Character.toLowerCase(a) + " is not in the secret word. Death draws closer.");
						}
					}
				}
			}
			if (newMan.getMissesCount()==7 && !(newMan.isFound())) { // This method returns true if the user ran out of guesses and they did not find the correct word. The isFound method will return false
				System.out.println("");
				System.out.println("Game Over!");
				System.out.println("You died. Next time, guess as if your life depended on it.");
				
			}
			else if (newMan.isFound()) { // This statement runs if the user found the correct word. The isFound method will return true
				System.out.println("");
				System.out.println("Game Over!");
				System.out.println("Congratulations! You guessed the  secret word: " + newMan.getDisguisedWord() + " in " + newMan.getGuessCount() + " guess(es)!");
			}
			System.out.println("Do you want to play again? (yes/no)"); // We ask the user if they want to play again
			answer = input.next();
			while (!(answer.equalsIgnoreCase("Yes")) && !(answer.equalsIgnoreCase("No"))) { // If the user does not enter yes or no (case insensitive), the while loop will prompt them to answer yes or no
				System.out.println("Either enter yes or no!");
				System.out.println("Do you want to play again? (yes/no)");
				answer = input.next();
			}
		}
		System.out.println("Thanks for playing " + HangMan.getGamesPlayed() + " game(s) of Hang Man!"); // If the user does not want to play anymore, we print the number of games they played using the static variable gamesPlayed
	}
}
