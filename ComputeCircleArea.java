package lab2;
/* -----------------------------------------------------------------------------
*
* File Name:  ComputeCircleArea.java
* Author: Alec Knutsen, a991k109@ku.edu
* Assignment:   EECS-168/169 Lab 2
* Description:  This program will compute the area of the circle, where the radius is received
*                      from the user.
* Date: September 8,2014
*
---------------------------------------------------------------------------- */
import java.util.Scanner;
public class ComputeCircleArea {
	public static void main(String[] args) {
		final double PI = 3.141592;
		double radius, area;
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number for radius: ");
		radius = input.nextDouble();
		area = PI * radius * radius;
		System.out.println("The area for the circle of radius " + radius + " is " + area);
	}
}
