/* -----------------------------------------------------------------------------
 * File Name: Lab11.java
 * Author: Alec Knutsen, a991k109@ku.edu
 * Assignment:   EECS-168/169 Lab10
 * Description:  This class will ask the user how many numbers they want to store. It will create an array of random integers of size specified by the user. 
 * It will sort the array in ascending or descending order depending on the user's preference. It will display the time of how long the sort took in nanoseconds and seconds.
 * Date: November 16, 2014
 ---------------------------------------------------------------------------- */
import java.util.Random;
import java.util.Scanner;
public class Lab11 {
	public static void main(String[] args) {
		BubbleSort mysort = new BubbleSort(); // Creates a new instance of the BubbleSort class 
		Random my_random = new Random(); // Creates a new instance of the random class
		Scanner input = new Scanner(System.in);
		System.out.println("How many random numbers do you want to make?"); // Prompts the user for how many numbers they want to store
		int total_nums = input.nextInt();
		while(total_nums <= 0) { // If the user enters a number less than or equal to 0 for the number of integers to store, this loop runs. It will make the user enter the number of integers to store greater than 0
			System.out.println("You must store more than one number!");
		}
		int[] my_array = new int[total_nums]; // Creates an array of integers of a size specified of the user
		for (int i =0; i < total_nums; i++) { // This loop populates the array with random integers between 0 and 255
			my_array[i] = my_random.nextInt(256);
		}
		System.out.print("Would you lie to sort the array in acending or descending order? (0 for ascending, 1 for descending): "); // Prompts the user if they want to sort the array in ascending or descending order
		int answer = input.nextInt();
		System.out.println("");
		System.out.println("Unsorted array:"); 
		for (int i =0; i < total_nums; i++) { // This loop prints the unsorted array
			System.out.print(my_array[i] + " ");
		}
		System.out.println("");
		System.out.println("");
		if (answer == 0) { // If the user wants to sort the array in ascending order, this if statement runs. It calls the ascending method of the BubbleSort class
			mysort.ascending(my_array);
		}
		else if (answer == 1) {// If the user wants to sort the array in descending order, this if statement runs. It calls the ascending method of the BubbleSort class
			mysort.descending(my_array);
		}
	}

}
