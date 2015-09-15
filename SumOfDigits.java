import java.util.Scanner;
public class SumOfDigits {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a No:");
		int user_num = input.nextInt();
		int answer = addDigits(user_num);
		System.out.println("The sum of the digits is: " + answer);
		System.out.println("Want to try again> y= 1/ n=0:");
		int try_again = input.nextInt();
		if (try_again == 0) {
			System.out.println("Thank you!");
		}
		while (try_again == 1) {
			System.out.println("Please enter a No:");
			int user_num1 = input.nextInt();
			int answer1 = addDigits(user_num1);
			System.out.println("The sum of the digits is: " + answer1);
			System.out.println("Want to try again> y= 1/ n=0:");
			try_again = input.nextInt();
		}
	}
	public static int addDigits(int x) {
		int my_sum = 0;
		while (x > 0) {
			my_sum = my_sum + (x%10);
			x = x / 10;		
		}
		return (my_sum);
	}

}
