/* -----------------------------------------------------------------------------
 * File Name: ArrayRunner.java
 * Author: Alec Knutsen, a991k109@ku.edu
 * Assignment:   EECS-168/169 Lab09
 * Description:  This class lets the user create a two dimensional array. 
 * It will print the array. 
 * It will calculate the sum and average for each row in the array.
 * It will calculate the sum and average for the whole two dimensional array
 * It will transpose the two dimensional array if it is a square array
 * Date: November 3, 2014
 ---------------------------------------------------------------------------- */
import java.util.Scanner;
public class ArrayRunner {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); // Create a new instance of the scanner class
		ArrayHelper array_instance = new ArrayHelper(); // Create a new instance of the array helper class
		System.out.println("Let's make an array!");
		System.out.println("How many rows?: ");
		int rows = input.nextInt(); // Stores the user input for the number of rows of a two dimensional array
		System.out.println("How many columns?: ");
		int columns = input.nextInt(); // Stores the user input for the number of columns of a two dimensional array
		int[][] my_array = new int[rows][columns]; // Creates a two dimensional array with the size designated by the user
		for (int i =0; i < my_array.length; i++) { // This loop controls each row in the two dimensional array
			for (int j =0; j < my_array[i].length; j++) { // This loop controls each column in the two dimensional array
				System.out.print("Enter a value for position (" + i + "," + j +"): "); 
				int values = input.nextInt(); // Stores the user input for entered values
				my_array[i][j] = values; // This lets the user enter values for each element in the two dimensional array
			}
		}
		array_instance.print2DArray(my_array); // Calls the print2DArray method of the ArrayHelper class to print the user array
		int[] oned_array; // Creates a one dimensional array
		for (int i =0; i < my_array.length; i++) {
			oned_array = my_array[i]; // Sets the one dimensional array to each row array of the two dimensional array
			System.out.println("row " + i + ": sum = " + array_instance.arraySum(oned_array) + ", avg = " + array_instance.arrayAvg(oned_array)); // Uses the arraySum and arrayAvg method of the ArrayHelper class to print the sum and average for each row in the two dimensional array
		}
		System.out.println("The sum for the entire array is " + array_instance.arraySum2D(my_array)); // Uses the arraySum2D method of the ArrayHelper class to print the sum for the two dimensional array
		System.out.println("The average for the entire array is " + array_instance.arrayAvg2D(my_array)); // Uses the arrayAvg2D method of the ArrayHelper class to print the average for the two dimensional array
		if (rows != columns) { // This if statement runs if the user matrix is not square. It lets the user no the transpose cannot be generated.
			System.out.println("I cannot tranpose this array!");
		}
		else { // This else statement runs if the user matrix is square
			System.out.println("The tranpose matrx is: ");
			int[][] transpose = array_instance.transpose(my_array); // We use the transpose method of the ArrayHelper class to transpose the user matrix
			array_instance.print2DArray(transpose); // Calls the print2DArray method of the ArrayHelper class to print the tranpose
		}
	}	

}
