/* File Name: Lab6_Strings.java
 * Author: Alec Knutsen
 * KUID: 2798040
 * Email Address: a991k109@ku.edu
 * Assignment: Lab6
 * Description: This program will accept an input for an array size greater than 0, and it will accept input for words in the array
 * It will output the largest word and smallest word.
 * Last Changed: October 5, 2014
 */
import java.util.Scanner;
public class Lab6_Strings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String max;
		String min;
		System.out.print("Input an array size for your words array: ");
		int array_size = input.nextInt();
		while (array_size <= 0) {
			System.out.print("Enter an array size greater than zero: ");
				array_size = input.nextInt();
			}
		String[] my_Array = new String[array_size];
		System.out.println("Now please enter " + array_size + " words.");
		for (int i = 0; i <= array_size-1; i++) {
			System.out.print("Input a word: ");
			String user_word = input.next();
			my_Array[i] = user_word;
		}
		max = my_Array[0];
		for (int j = 0; j <= array_size - 1; j++) {
			String each_string = my_Array[j];
			if (each_string.length() >= max.length()) {
				max = each_string;
			}
		}
		System.out.println("The longest word is: " + max);
		min = my_Array[0];
		for (int k = 0; k <= array_size - 1; k++) {
			String each_string = my_Array[k];
			if (each_string.length() <= min.length()) {
				min = each_string;
			}
		}
		System.out.println("The shortest word is: " + min);
	}
}
