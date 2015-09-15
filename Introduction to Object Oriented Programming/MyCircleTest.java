public class MyCircleTest {
	public static void main(String[] args) {
		MyCircle circle1 = new MyCircle(); // Declares a new circle called myCircle
        circle1.radius = 5.5; //Assigns the radius a value of 5.5
        System.out.println("My circle hasa a radius of " + circle1.radius + "."); //Displays a message to the screen that says "My circle has a radius of <put the radius here>"
        double theArea, theCircum; //Declares two doubles, theArea and theCircum
        theArea = circle1.area(); //Uses the method area() from myCircle to store the area in theArea                         
        theCircum = circle1.circumference(); //Uses the method circumference() from myCircle to store the circumference in theCircum
        System.out.println("The area is " + theArea + "."); //Displays a message to the screen "The area is <put the area here>"
        System.out.println("The circumference is " + theCircum + "."); //Displays a message to the screen "The circumference is <put the circumference here>"
        System.out.println("The diameter is " + circle1.diameter() + "."); //Uses only a method call to diameter(), writes a message to the screen "The diameter is <put the diameter here>"
	}
}