/* 
 * File Name: HangMan.java
 * Author: Ale Knutsen
 * KUID: 2798040
 * Email Address: a991k109@ku.edu
 * Homework Assignment Number: #4
 * Description: This class contains a number of method's that return booleans. The methods will be used to implement a Hangman game in GameDriver.java
 * Last Change: December 6, 2014
 */
public class HangMan {
	
	/*
	 *We initially declare a number of variables that will be used throughout our class. 
	 */
	private final String secret_word;
	private char[] disguised_word;
	private int guessCount;
	private int missesCount;
	private int MAX_GUESS;;
	private char[] missedMarkers;
	private static int gamesPlayed; // Note this static variable will hold the number of games played and is not associated with an instance of the hangman class
	private int word_guess;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*
	 * Constructor: This constructor sets initial values for all our variables above
	 * 
	 * 
	 * 
	 * 
	 */
	HangMan(String secret_word1) {
		secret_word = secret_word1.toLowerCase(); // The variable secret word is set to the parameter passed into the constructor
		disguised_word = new char[secret_word.length()]; // We declare a character array disguised_word with the same length as secret_word
		for (int i =0; i < disguised_word.length; i++) { // This for loop is used to fill the disguised_word array with ? or spaces if there are any
			char a = secret_word.charAt(i);
			a = Character.toLowerCase(a);
			if (a == ' ') {
				disguised_word[i] = ' ';
			}
			else {
				disguised_word[i] = '?';
			}
		}
		MAX_GUESS = 7; // The maximum number of guesses is set to 0
		missedMarkers = new char[MAX_GUESS]; // The missedMarkers array is initialized to an array of size seven
		for (int i =0; i < MAX_GUESS; i++) {
			missedMarkers[i] = 'O'; // This for loop fills the missedMarkers array with zeros
		}
		guessCount = 0; // The number of guesses is initially set to 0
		missesCount = 0; // The number of misses is initially set to 0
		gamesPlayed++; // The number of games played gets incremented each time a new hangman class is created
	}
	
	/*
	 * PreConditions: We assume the parameter passed in and the variable secret_word are not null
	 * PostConditions: This method will return true if the parameter character is found within the secret_word. Else it will return false
	 * @param char C
	 * @return boolean
	 */
	public boolean guessCharacter(char c) {
		gamesPlayed++;
		int count = 0; // Holds a useful count
		for (int i =0; i < secret_word.length(); i++) { // This loop runs to compare every character of secret_word to the parameter passed in
			char a = secret_word.charAt(i);
			if (compareChar(Character.toLowerCase(c), a)) { // If a character of secret word matches the character parameter, the disguised_word array at the same index is made to a letter instead of a question mark
				disguised_word[i] = Character.toLowerCase(c); 
			}
			else { // Count is incremented if the character is not found in the secret_word character for each character in secret_word
				count++;
			}
		}
		if (count == secret_word.length()) { // If the count is as great as the secret_word length, the character was not found in the word
			missedMarkers[missesCount] = 'X'; // An X replaces an 0 in the missedMarkers array at the index of misses
			missesCount++; // We update the misses count by one
			guessCount++;// We update the guesses count by one
			return(false);// We return false if a letter is not found in secret_word
		}
		else { // If a character is found in the secret word, this else statement runs
			guessCount++; // We update the guess count
			return(true); // We return true if a letter is found in secret_word
		}
	}
	
	/*
	 * PreConditions: We assume disguised_word, secret_word, and missesCount are not null
	 * PostConditions: This method returns true if the secret_word is found or the user used up their seven guesses. Else it returns false
	 * @param No parameters
	 * @return boolean
	 */
	public boolean isGameOver() {
		if (getDisguisedWord().toLowerCase().equals(secret_word)) { // If the disguised_word matches the secret_word, this statement runs
			resetGuessessAllowed(); // This resets the word_guess variable so that the user can guess a word one time again in the next game
			return(true);
		}
		else if (missesCount == MAX_GUESS) { // If the user used up there seven guesses, this runs 
			resetGuessessAllowed(); // This resets the word_guess variable so that the user can guess a word one time again in the next game
			return(true);
		}
		else {// If the game is not over, we return false
			return(false); 
		}
	}
	
	/*
	 * PreConditions: We assume secret_word and disguised_word are not null
	 * PostConditions: This method returns true if the secret_word is found. Else it returns false
	 * @param No parameters
	 * @return boolean
	 */
	public boolean isFound() { 
		if (getDisguisedWord().toLowerCase().equals(secret_word)) { // If the disguised_word matches the secret_word, this statement runs
			resetGuessessAllowed();// This resets the word_guess variable so that the user can guess a word one time again in the next game
			return(true);
		}
		else {// If the user did not guess the secret word, we return false
			return(false);
		}
	}
	
	/*
	 * PreConditions: We assume the array disguised_word is not null
	 * PostConditions: This method will take each character at the index in the char array disguised_word. It will concatenate the characters into a word
	 * @param No parameters
	 * @return Returns a string representing all the characters in the disguised_word
	 */
	public String getDisguisedWord() {
		String word = "";
		for (int i=0; i < disguised_word.length; i++) { // We concatenate each element in the disguised_word array to form a string
			word += disguised_word[i];
		}
		return(word);
	}
	
	/*
	 * PreConditions: We assume guessCount is not null
	 * PostConditions: This method returns the number of guesses
	 * @param No parameters
	 * @return Returns int guessCount
	 */
	public int getGuessCount() {
		return(guessCount);
	}
	
	/*
	 * PreConditions: We assume missesCount is not null
	 * PostConditions: This method returns the number of misses
	 * @param No parameters
	 * @return Returns int missesCount
	 */
	public int getMissesCount() {
		return(missesCount);
	}
	
	/*
	 * PreConditions: We assume the array missdMarkers is not null
	 * PostConditions: This method will take each character at the index in the char array missedMarkers. It will concatenate the characters into a word
	 * @param No parameters
	 * @return Returns a string representing all the characters in the missedMarkers
	 */
	public String getMissedMarker() {
		String word = "";
		for (int i=0; i < missedMarkers.length; i++) { // We concatenate each element in the missedMarkers array to form a string
			word += missedMarkers[i];
		}
		return(word);
	}
	
	/*
	 * PreConditions: We assume the parameter entered is not null and assume secret_word and guessCount are not null
	 * PostConditions: This method will return true if the secret_word matches the entered parameter
	 * @param String word
	 * @return boolean
	 */
	public boolean guessWord(String word) {
		word= word.toLowerCase();
		if (word.equals(secret_word)) { // If the word parameter matches the secret_word, we update the guessCount and return true 
			guessCount++;
			return(true);
		}
		else { // If the word parameter does not match the secret_word, we update the guessCount and return false
			word_guess = 1; // This variable is updated to one to prevent the user from guessing a word multiple times in one game
			guessCount++;
			return(false);
		}
	}
	
	/*
	 * PreConditions: We assume word_guess is not null
	 * PostConditions: This method returns true if the user has not guessed a word yet. Else it returns false
	 * @param No parameters
	 * @return Returns a boolean
	 */
	public boolean areWordGuessesAllowed() {
		if (word_guess == 1) { // If the user has guessed a word, word_guess will be equal to 1. Thus, we return false since the user has already used their one guess
			return(false);
		}
		else { // If the user has  not guessed a word, word_guess will be equal to 0. Thus, we return true since the user has not already used their one guess
			return(true);
		}
	}
	
	/*
	 * PreConditions: None
	 * PostConditions: This methods returns the number of games played
	 * Note: 
	 * @param No parameters
	 * @return Returns an int that is the number of games played
	 */
	public static int getGamesPlayed() {
		return(gamesPlayed);
	}
	/*
	 * PreConditions: None
	 * PostConditions: This method sets the word_guess variable equal to zero. After a game is played, this method will be called so that the user can have one word guess in the next game
	 * Note: This is a private helper method
	 * @param No parameters
	 * @return Returns a random integer from 1 up to num_sides
	 */
	private void resetGuessessAllowed() { 
		word_guess = 0;
	}
	
	/*
	 * PreConditions: We assume the two characters entered as parameters are not null
	 * PostConditions: This method compares two characters. If the characters are the same it returns true. Else it returns false.
	 * Note: This is an extra, private helper method to be used in guessCharacter
	 * @param No parameters
	 * @return Returns a random integer from 1 up to num_sides
	 */
	private boolean compareChar (char a, char b) {
		if (a == b) { // We return true if two characters are equal
			return(true);
		}
		else { // We return false if the characters are not equal
			return(false);
		}
	}
}
