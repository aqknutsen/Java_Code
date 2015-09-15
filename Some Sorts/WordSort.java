/* -----------------------------------------------------------------------------
 * File Name: WordSort.java
 * Author: Alec Knutsen, a991k109@ku.edu
 * Assignment:   EECS-168/169 Lab10
 * Description:  This class will ask the user how many words they want to store. It will create an array of strings of size specified by the user. 
 * It makes the user populate the array with words
 * It sorts the array by word length
 * Date: November 16, 2014
 ---------------------------------------------------------------------------- */
import java.util.Scanner;
public class WordSort {
	public static void main(String[] args) {
		long start, stop, elapsed;
		Scanner input = new Scanner(System.in);
		System.out.println("How many words do you want to make?"); // Prompts the user for how many words they want to store
		int total_nums = input.nextInt();
		while(total_nums <= 0) { // If the user enters a number less than or equal to 0 for the number of words to store, this loop runs. It will make the user enter the number of words to store greater than 0
			System.out.println("You must store more than one word!"); 
		}
		String[] my_array = new String[total_nums]; // Creates an array of Strings of a size specified of the user
		for (int i =0; i < total_nums; i++) { // This loop makes the user populate the array with words
			System.out.println("Enter a word: "); 
			String word = input.next();
			my_array[i] = word;
			while (word.length() <= 0) { // If the user does not enter a word with one character, this loop will run. It will make the user enter a word with a length greater than 0/
				System.out.print("Enter a word with at least one character: ");
				word = input.next();
				my_array[i] = word;
			}
		}
		System.out.println("Unsorted array:");
		for (int i =0; i < total_nums; i++) { // This loop prints the unsorted array
			System.out.print(my_array[i] + " ");
		}
		boolean sorted = false;
		start = System.nanoTime(); // Holds the start time of the sort
		while (! sorted) {
			sorted = true;
			for (int i =0; i < my_array.length-1; i++) { // This loop runs through all the indices of the array except the last element
				if (my_array[i].length() > my_array[i+1].length()) { // If the next array value length is greater than the previous array value length, this if statement runs
					sorted = false; // This will make the while loop run again
					String temp = my_array[i]; // This temporarily holds the previous array value
					my_array[i] = my_array[i+1]; // The previous array value gets swapped with the next array value
					my_array[i+1] = temp; // The next array value becomes the previous array value
				}
			}
		}
		stop = System.nanoTime(); // Holds the end time of the sort
		elapsed = stop - start; // Calculates the total sort time
		System.out.println("");
		System.out.println("");
		System.out.println("Staring sort at " + start);
		System.out.println("Stopping sort at " + stop);
		System.out.println("");
		System.out.println("Sorted Array: ");
		for (int i =0; i < my_array.length; i++) { // This loop prints the sorted array
			System.out.print(my_array[i] + " ");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("This sort took a total of " + elapsed + " nano seconds, or " + elapsed/1000000000.0 + " seconds"); // Prints the time the sort method took in nanoseconds and seconds
	}
}
