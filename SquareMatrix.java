/* File Name: SquareMatrix.java
 * Author: Alec Knutsen
 * KUID: 2798040
 * Email Address: a991k109@ku.edu
 * Homework Assignment Number: Homework 2
 * Description: This program will accept an input for the size of an nxn matrix. It will print an nxn matrix and the transpose of the martix.
 * Note: If the user chooses size > 3, my program still prints a matrix, but the numbers are not totally adjacent.
 * Last Changed: September 29, 2014
 */
import java.util.Scanner;
public class SquareMatrix {
	public static void main(String[] args) {
		int total = 0;
		int step_up = 0;
		int count = 1;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the size of the Square Matrix: "); // Prompts the user for the size of a nxn matrix.
		int size = input.nextInt(); // Stores the user input for size of  matrix.
		System.out.println("Square Matrix: ");
		for (int i = 0; i < size; i ++) { // Runs as many times as the user inputs for size. 
			for (int j =1; j <= size; j++){ //Runs as many times as the user inputs for size.
				total = step_up + j; // Sets total equal to step_up + j.
				System.out.print(total); // Prints the total 
				System.out.print(" "); // Prints a space after the number
			}
		step_up += size; // Sets step_up equal to step_up plus size.
		System.out.println(""); // Prints a new line each time the loop runs.
		}
		System.out.println(""); // Prints a space between the old matrix and the word Transpose. 
		System.out.println("Transpose: ");
		for (int i = 1; i <= size; i ++) { // Runs as many times as the user inputs for size.
			count = i;
			System.out.print(count); // Prints the integer i.
			System.out.print(" ");
			for (int j =1; j < size; j++){ // Runs as many times as the user inputed for size. 
				count += size; // Sets count equal to count plus size.
				System.out.print(count); // Prints the count.
				System.out.print(" "); // Prints a space after each number.
			}
		System.out.println(""); // Prints a new line each time the loop iterates. 
		}	
	}
}
