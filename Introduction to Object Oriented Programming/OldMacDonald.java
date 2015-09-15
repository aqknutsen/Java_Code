
public class OldMacDonald {
	Animal animal; // Declares a variable of type Animal
	public void setAnimal(Animal animal1) { // Method that takes a parameter of type Animal and sets the animal variable equal to the reference of the animal1 parameter
		animal = animal1;
	}
	public Animal getAnimal() { // Method that takes no parameters and returns the variable animal
		return(animal);
	}
	public void sing() { // Method that takes no parameters, returns nothing, and prints the Old MacDonald song
		System.out.println("Let's sing!");
		System.out.println("Old MacDonald had a farm, EE-I-EE-I-O");
		System.out.println("And on the farm he had a " + animal.getType() + " EE-I-EE-I-O");
		System.out.println("With a " + animal.getSound()+ "-"+ animal.getSound()+ " here, and a " + animal.getSound() + "-" + animal.getSound() + " there,");
		System.out.println("Here a " + animal.getSound() + ", there a " + animal.getSound() + ", everywhere a " +  animal.getSound()+ "-" + animal.getSound() + ",");
		System.out.println("Old MacDonald had a farm, EE-I-EE-I-O");
	}
}
