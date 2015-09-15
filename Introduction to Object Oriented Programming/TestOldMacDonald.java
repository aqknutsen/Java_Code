import java.util.Scanner;
public class TestOldMacDonald {
	public static void main(String[] args){
	 Scanner input = new Scanner(System.in); // Creates a new instance of the Scanner class
	 Animal animalA = new Animal(); // Creates a new instance of the Animal class stored in animalA
	 OldMacDonald md = new OldMacDonald();// Creates a new instance of the OldMacDonald class stored in md
	 System.out.print("Input an animal: ");
	 String input1 = input.next(); // Stores the user input for animal type in input1
	 System.out.print("What sound does an: " + input1 + " make?: ");
	 String sound = input.next(); // Stores the user input for the animal sound in sound
	 animalA.setSound(sound); // Calls the Animal class setSound method with the user input for sound as a parameter
	 animalA.setType(input1);// Calls the Animal class setType method with the user input for animal type as a parameter
	 md.setAnimal(animalA); // Calls the setAnimal method of the OldMacDonald class to set animalA equal to the reference of the variable animal in the OldMacDonald class
	 md.sing(); // Calls the sing method of the OldMacDonald class

	}
}
