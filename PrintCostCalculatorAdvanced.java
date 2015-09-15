/* -----------------------------------------------------------------------------
 * File Name: PrintCostCalculator
 * Author: Alec Knutsen, a991k109@ku.edu
 * Assignment:   EECS-168/169 Homework 1
 * Description:  This program will accept inputs of type of number of pages, print type, print color, and user input if there is a sale or not.
 				 This program will return ink usage per page, total ink usage, estimated cost per page, total price, total price after tax, sale price if there is a sale, and sale price after tax if there is a sale. 
 * Date: September 23,2014
 ---------------------------------------------------------------------------- */
import java.util.Scanner;
public class PrintCostCalculatorAdvanced {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); 
		double ink_usage_per_page = 0; // Declare and initialize variable for ink_usage_per_page
		System.out.println("--- Price Estimator Program ---");
		System.out.print("Enter Number of Pages (digits only): "); // Prompts the user for the number of pages.
		int number_of_pages = input.nextInt(); // Stores the input for the number of pages.
		System.out.println();
		System.out.println("--- Select a Print Type ---");
		System.out.println("Enter T or t for Text");
		System.out.println("Enter I or i for Image");
		System.out.println("Enter C or c for Compressed Text");
		System.out.println("Enter S or s for statement");
		System.out.println("----------------------------");
		System.out.print("Enter Print Type: "); // Prompts the user for the print type.
		String input1 = input.next();
		char print_type = input1.charAt(0); // Converts the print type from the user to a character data type.
		while (print_type !='T' && print_type !='t' && print_type !='I' && print_type !='i' && print_type !='C' && print_type !='c' && print_type !='S' && print_type !='s') { // Keeps running if the print type is not entered as T,t,I,i,C,c,S,s. 
			System.out.println("Invalid entry for print type.");
			System.out.println("--- Select a Print Type ---");
			System.out.println("Enter T or t for Text");
			System.out.println("Enter I or i for Image");
			System.out.println("Enter C or c for Compressed Text");
			System.out.println("Enter S or s for statement");
			System.out.println("----------------------------");
			System.out.print("Enter Print Type: "); // Re-prompts the user for the print type.
			String input2 = input.next();
			print_type = input2.charAt(0);
		}
		System.out.println();
		System.out.println("--- Select a Print Color ---");
		System.out.println("Enter 0 for Grayscale");
		System.out.println("Enter 1 for Color");
		System.out.println("-----------------------------");
		System.out.print("Enter Print Color: "); // Prompts the user for print color.
		int print_color = input.nextInt(); // Stores the user input for print color. 
		while (print_color != 0 && print_color!= 1 ) { // Keeps Running if the user does not input 0 or 1 for print color.  
			System.out.println("Invalid entry for Print Color.");
			System.out.println("--- Select a Print Color ---");
			System.out.println("Enter 0 for Grayscale");
			System.out.println("Enter 1 for Color");
			System.out.println("-----------------------------");
			System.out.print("Enter Print Color: "); // Re-prompts the user for print color.
			print_color = input.nextInt();
		}
		System.out.println("-----------------------------");
		System.out.print("Is there a sale (y/n): ");
		String input2 = input.next(); // Stores the user answer in a String.
		char sale = input2.charAt(0); // Converts the answer from the user for a sale to a character data type. 
		if (print_type== 'T' || print_type=='t') { // Runs if the user input for print type as T or t and sets ink usage per page equal to 4300.
			ink_usage_per_page = 4300;
		}
		else if (print_type=='I' || print_type=='i') { // Runs if print type is entered as I or i for Image and sets ink usage per page equal to 15000.
			ink_usage_per_page = 15000;
		}
		else if (print_type=='C' || print_type=='c') { // Runs if the print type is entered as C or c for Compressed Text and sets ink usage per page to 25000.
			ink_usage_per_page = 25000;
		}
		else { // Runs if the user enters S or S for Statement because we have checked all other valid inputs for print type. Ink usage per page is set to 27000.
			ink_usage_per_page = 27000;
		}
		double total_ink_usage = number_of_pages * ink_usage_per_page; // Calculates the total ink usage by taking the number of pages * the ink usage per page.
		final double grayscale_ink_price_per_1000_dots = 0.03; // Sets the grayscale ink price per 1000 dots.
		final double color_ink_price_per_1000_dots = 0.11; // Sets the color ink price per 1000 dots.
		double grayscale_estimated_cost_per_page = ((ink_usage_per_page/1000.00) * grayscale_ink_price_per_1000_dots); // Calculates the estimated cost per page for grayscale. 
		double grayscale_total_cost = grayscale_estimated_cost_per_page * ((double) number_of_pages);// Calculates the total cost for grayscale.. 
		double grayscale_total_cost_after_tax = (grayscale_total_cost * 0.0063) + grayscale_total_cost; // Calculates the cost after tax for grayscale.
		double color_estimated_cost_per_page = ((ink_usage_per_page/1000.00) * color_ink_price_per_1000_dots);// Calculates the estimated cost per page for color. 
		double color_total_cost = color_estimated_cost_per_page * ((double) number_of_pages);// Calculates the total cost for color. 
		double color_total_cost_after_tax = (color_total_cost * 0.0063) + color_total_cost;// Calculates the cost after tax for color.
		double sale_price = color_total_cost/2.00; // Calculates the sale price if there is a sale.
		double sale_price_after_tax = (sale_price * 0.0063) + sale_price ; // Calculates the sale price after tax if there is a sale.
		if (print_color == 0){ // Runs if user input for print color is grayscale.
			System.out.println();
			System.out.println("--- Cost Estimate ---");
			System.out.println("Ink Usage Per Page: " + (int)ink_usage_per_page);
			System.out.printf("Total Ink Usage: %.2e\n",total_ink_usage);
			System.out.println();
			System.out.printf("Estimated Cost Per Page: $%.4f\n",grayscale_estimated_cost_per_page);  
			System.out.printf("Total Cost: $%.2f\n",grayscale_total_cost);;
			System.out.println();
			System.out.printf("Total Cost After Tax: $%.2f\n",grayscale_total_cost_after_tax);
		}
		else if (print_color == 1 && (sale == 'y' || sale== 'Y') && number_of_pages > 100){ // Runs if user input for print color is color, the user inputs Y or y for is there a sale, and the number of pages is greater than 100.
			System.out.println();
			System.out.println("--- Cost Estimate ---");
			System.out.println("Ink Usage Per Page: " + (int)ink_usage_per_page);
			System.out.printf("Total Ink Usage: %.2e\n",total_ink_usage);
			System.out.println();
			System.out.printf("Estimated Cost Per Page: $%.4f\n",color_estimated_cost_per_page);  
			System.out.printf("Total Cost: $%.2f\n",color_total_cost);
			System.out.println();
			System.out.printf("Sale Price: $%.2f\n",sale_price);
			System.out.printf("Total Cost After Tax On Sale Price: $%.2f\n", sale_price_after_tax);
			}
		else { // Runs if the user does not input a Y or y for sale or the user inputs a number of pages less than 100 with a color print. 
			System.out.println();
			System.out.println("--- Cost Estimate ---");
			System.out.println("Ink Usage Per Page: " + (int)ink_usage_per_page);
			System.out.printf("Total Ink Usage: %.2e\n",total_ink_usage);
			System.out.println();
			System.out.printf("Estimated Cost Per Page: $%.4f\n",color_estimated_cost_per_page);  
			System.out.printf("Total Cost: $%.2f\n",color_total_cost);
			System.out.println();
			System.out.printf("Total Cost After Tax: $%.2f\n",color_total_cost_after_tax);
		}
	}
}

