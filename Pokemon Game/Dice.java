/* -----------------------------------------------------------------------------
 * File Name: Dice.java
 * Author: Alec Knutsen, a991k109@ku.edu
 * Assignment:   EECS-168/169 Homework 3
 * Description:  This class will create a dice with the number of sides inputed when the class is instantiated. 
 * Date: October 31, 2014
 ---------------------------------------------------------------------------- */
import java.util.Random;
public class Dice {
	Random my_rand = new Random(); // Declares a new instance of the Random class stored in the variable my_rand
	private int num_sides; 
	
	/* 
	 * Constructor that sets the number of sides of a dice to the parameter that is inputed when the class created
	 * @param int sides - An integer for the number of sides of a dice 
	 * @return No return value
	 */
	Dice(int sides) {
		num_sides = sides;
	}
	
	/*
	 * Method that returns a random integer from 1 up to num_sides. Thus, this method functions as a dice roll with the number of sides determined by num_sides
	 * @param No parameters
	 * @return Returns a random integer from 1 up to num_sides
	 */
	public int roll( ) {
		return(1+ my_rand.nextInt(num_sides)); // Note that the nextInt method of the random class will return an int from 0 up to num_sides-1. Thus our range for our return value our is from 1 to num_sides.
	}
}