/* File Name: Lab6.java
 * Author: Alec Knutsen
 * KUID: 2798040
 * Email Address: a991k109@ku.edu
 * Assignment: Lab6
 * Description: This program will accept an input for an array size greater than 0, and it will accept input for numbers in the array
 * It will output each number the user inputs in the array, 
 * the sum of the array values, the average of the array values, the largest value, and the smallest value.
 * Last Changed: October 5, 2014
 */
import java.util.Scanner;
public class Lab6 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int my_sum = 0;
		int my_max;
		int my_min;
		double my_average;
		System.out.print("Input an array size: ");
		int array_size = input.nextInt();
		while (array_size <= 0) {
			System.out.print("Enter an array size greater than zero: ");
				array_size = input.nextInt();
			}
		int[] my_Array = new int[array_size];
		System.out.println("Now please enter " + array_size + " numbers.");
		for (int i = 0; i <= array_size - 1; i++) {
			System.out.print("Input a number into your array: ");
			int array_number = input.nextInt();
			my_Array[i] = array_number;
		}
		System.out.println("Here are all the numbers in your array: ");
		for (int j = 0; j <= array_size - 1; j++) {
			System.out.println(my_Array[j]);
		}
		for (int k =0; k <= array_size -1; k++) {
			my_sum += my_Array[k];
		}
		System.out.println("The sum of all the values is: " + my_sum);
		my_average = ((double) my_sum)/((double) array_size);
		System.out.println("The average of all the values is: " + my_average);
		my_max = my_Array[0];
		for (int l =0; l<= array_size -1; l++) {
			if (my_Array[l] >= my_max) {
				my_max = my_Array[l];
			}
		}
		System.out.println("The largest value is: " + my_max);
		my_min = my_Array[0];
		for (int m =0; m<= array_size -1; m++) {
			if (my_Array[m] <= my_min) {
				my_min = my_Array[m];
			}
		}
		System.out.println("The smallest value is: " + my_min);
	}
}
