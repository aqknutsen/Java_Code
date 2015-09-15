package lab2;
/* -----------------------------------------------------------------------------
*
* File Name:  ConvertTemperature.java
* Author: Alec Knutsen, a991k109@ku.edu
* Assignment:   EECS-168/169 Lab 2
* Description:  This program will convert the input temperature from Fahrenheit to Celsius.
* Date: September 8, 2014
*
---------------------------------------------------------------------------- */
import java.util.Scanner;
public class ConvertTemperature {
	public static void main(String[] args) {
		double Farenheit; 
		double Celsius;
		double constant1, constant2, constant3;
		constant1 = 32;
		constant2 = 5;
		constant3 = 9;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the temperature in degrees Farenheit: ");
		Farenheit = input.nextDouble();
		Celsius = (Farenheit - constant1) * (constant2/constant3);
		System.out.println("*Conversion:");
		System.out.println(Farenheit + " degrees Farenheit = " + Celsius + " degrees Celsius.");
		
	}
}
