/* -----------------------------------------------------------------------------
 * File Name: ArrayHelper.java
 * Author: Alec Knutsen, a991k109@ku.edu
 * Assignment:   EECS-168/169 Lab09
 * Description:  This class contains six methods. 
 * One method prints a two-dimensional array.
 * Two methods calculate the sum for a one dimensional array and two dimensional array
 * Two methods calculate the average for a one dimensional array and two dimensional array
 * One method prints the transpose of a two dimensional array
 * Date: November 3, 2014
 ---------------------------------------------------------------------------- */
public class ArrayHelper {
	
	/* 
	 * This method prints a two dimensional array with each elements seperated by commas
	 * @param int[][] array - This method takes a two dimensional array as a parameter
	 * @return No return value
	 */
	public void print2DArray(int[][] array) {
		for (int i =0; i < array.length; i++) { // This loop controls the rows of the dimensional array
			for (int j =0; j < array[i].length; j++) { // This loop controls the columns of the two dimensional array
				if (j + 1 == array[i].length ) { // This if statement will run if it is at the last element of the row. It prints the last element in the row
					System.out.print((array[i][j])); 
				}
				else { // This else statement will run if it is not at the last element of the row. It prints each element in a two dimensional array followed by a comma if it is not the last element in the row
					System.out.print(array[i][j] + ", "); // 
				}
			}
			System.out.println(""); // This prints a space after each row in the two dimensional array
		}
	}
	
	/* 
	 * This method calculates the sum of all the values in a one dimensional array
	 * @param int[] array - This method takes a one dimensional array as a parameter
	 * @return int count - This method returns the sum of the values of a one dimensional array
	 */
	public int arraySum(int[] array) {
		int count = 0;
		for (int i =0; i < array.length; i++) { // This loop adds all the values for a one dimensional array
			count += array[i];
		}
		return(count); // This returns the sum of all the values for a one dimensional array
	}
	
	/* 
	 * This method calculates the average of all the values in a one dimensional array
	 * @param int[] array - This method takes a one dimensional array as a parameter
	 * @return int count - This method returns the average of the values of a one dimensional array
	 */
	public double arrayAvg(int[] array) {
		int count = 0;
		for (int i =0; i < array.length; i++) { // This loop sums all the values for a one dimensional array
			count += array[i];
		}
		return(count/array.length); // This returns the average of all the values for a one dimensional array
	}
	
	/* 
	 * This method calculates the sum of all the values in a two dimensional array
	 * @param int[][] array - This method takes a two dimensional array as a parameter
	 * @return int count - This method returns the sum of the values of a two dimensional array
	 */
	public int arraySum2D(int[][] array) {
		int count = 0;
		for (int i =0; i < array.length; i++) { // This loop controls the rows of the two dimensional array
			for (int j =0; j < array[i].length; j++) { // This loop controls the columns of the two dimensional array
				count += array[i][j]; // This sums all the values in a two dimensional array
			}
		}
		return(count); // This returns the sum of all the values for a two dimensional array
	}
	
	/* 
	 * This method calculates the average of all the values in a two dimensional array
	 * @param int[][] array - This method takes a two dimensional array as a parameter
	 * @return int count - This method returns the average of the values of a two dimensional array
	 */
	public double arrayAvg2D(int[][] array) {
		int count = 0;
		int length =0;
		for (int i =0; i < array.length; i++) { // This loop controls the rows of the two dimensional array
			length = array[i].length;
			for (int j =0; j < array[i].length; j++) { // This loop controls the columns of the two dimensional array
				count += array[i][j]; // This sums all the values in a two dimensional array
			}
		}
		return(count/(array.length*length)); // This returns the average of all the values for a two dimensional array
	}
	/* 
	 * This method transposes a matrix
	 * @param int[][] array - This method takes a two dimensional array as a parameter
	 * @return int[][] - This method returns a two dimensional array that is the transpose of the parameter
	 */
	public int[][] transpose(int[][] array) {
		int size;
		size = array.length;
		int[][] transpose = new int [size][size];
		for (int i = 0; i < array.length; i++) { // This loop controls the rows of the two dimensional array
			for (int j =0; j < array[i].length; j++) { // This loop controls the columns of the two dimensional array
				transpose[i][j] = array[j][i]; // This takes a new two dimensional array, and reverses the indices of the old two dimensional array
			}
		}
		return(transpose); // Here we return the tranposed matrix
	}
}
