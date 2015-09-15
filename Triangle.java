import java.util.Scanner;
public class Triangle {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the number of asteriks for the base of the triangle: ");
		int number_of_asteriks = input.nextInt();
		for ( int i = 1; i <= number_of_asteriks; i++) {
			for (int j =number_of_asteriks - i; j < number_of_asteriks; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
}
