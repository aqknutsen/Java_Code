import java.util.Scanner;
class NumberGuessingGame {
	public static void main(String[] args) {
		int my_number = 73;
		Scanner input = new Scanner(System.in);
		System.out.println("Welcome to the  number guessing game.");
		System.out.print("Guess a number: ");
		int guess = input.nextInt();
		do {
			if (guess < my_number) {
				System.out.println("Sorry your guess is too low.");
			}
			else {
				System.out.println("Sorry, your guess is too high.");
			}
			System.out.print("Guess a number: ");
			guess = input.nextInt();
		}
		while (guess != my_number);
		System.out.println("You win!");
	}

}
