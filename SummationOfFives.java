import java.util.Scanner;
public class SummationOfFives {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("Please input a positive integer as the end value: ");
		int end_value = input.nextInt();
		int count = 5;
		int count_1 = 0;
		int count_2;
		int count_3 = 0;
		while (count < end_value) {
			count_1 += count;
			count += 5;
		}
	System.out.println("The summation is: " + count_1);
	}
}
