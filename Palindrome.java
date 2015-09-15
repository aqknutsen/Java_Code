import java.util.Scanner;
public class Palindrome {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter a No: ");
		int user_num = input.nextInt();
		System.out.println("The length of the Number is " + lengthOfNumber(user_num));
		System.out.println("The reverse of the Number is " + reverse(user_num));
		if (isPalindrome(user_num) == true) {
			System.out.println("The number is a Palindrome.");
		}
		else {
			System.out.println("The number is not a Palindrome.");
		}
	}
	public static boolean isPalindrome(int x) {
		if (reverse(x) == x) {
			return (true);
		}
		else {
			return(false);
		}
	}
	public static int reverse(int x) {
		int reverse = 0;
		int remainder = 0;
		while (x > 0 && lengthOfNumber(x) < x) {
			remainder = x %10; // 
			x = x / 10;
			reverse = reverse * 10 + remainder; // prints the ones digit, then ten's digit, then hundreds digit
			
		}
		return (reverse);
	}
	public static int lengthOfNumber(int x) {
		String length = "" + x;
		int length1 = length.length();
		return(length1);
	}
}
