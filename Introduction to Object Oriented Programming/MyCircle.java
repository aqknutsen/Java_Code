public class MyCircle {
    private final double PI = 3.141592;//Define the constant PI.
    public double radius; //The MyCircle class has one property: radius
    public double diameter() {//Makes a method that calculates the diameter of a circle. Recall the radius is half of the diameter.
    	double diameter = 2.0*radius;
    	return(diameter);
    }
    public double area() { //Make a method that returns the area of a Circle.
    	double area = PI * radius * radius;
    	return(area);
    }
    public double circumference() { //Makes a method that returns the circumference of a Circle.
    	double circumference = 2.0 * PI * radius;
    	return(circumference);
    }
}