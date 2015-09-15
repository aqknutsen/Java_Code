
public class Animal {
	private String animal_type, animal_sound; // Creates two private variables animal_type and animal_sound
	public void setType(String animaltype) { // Method that takes the parameter animaltype and  sets the animal_type to animaltype
		animal_type = animaltype;
	}
	public void setSound(String animalsound) {// Method that takes the parameter animalsound and sets the animal_sound to animalsound
		animal_sound = animalsound;
	}
	public String getType() {// Method that takes no parameters and returns the animal_type
		return(animal_type);
	}
	public String getSound() {// Method that takes no parameters and returns the animal_sound
		return(animal_sound);
	}
}
