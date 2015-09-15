package lab2;
/* -----------------------------------------------------------------------------
*
* File Name: CircleArea.java
* Author: Alec Knutsen, a991k109@ku.edu
* Assignment:   EECS-168/169 Lab 2
* Description:  This program will compute the area of a circle with a hard-coded radius.
* Date: September 8,2014
*
---------------------------------------------------------------------------- */
public class CircleArea {
	public static void main(String[] args) {
		final double PI = 3.141592;
		double radius, area;
		radius = 20;
		area = PI * radius * radius;
		System.out.println("The area for the ciricle of radius " + radius + " is " + area);
	}
}
