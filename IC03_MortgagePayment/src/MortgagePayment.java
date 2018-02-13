
/*
    Nguyen, Nguyen
    CS A170
    02/11/2018

    IC03_MortgagePayment
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class MortgagePayment {

	public static void main(String[] args) {
		// Variables
		double monthlyPayment, monthlyInterest, rate = .04, balance;
		Scanner consoleScanner = new Scanner(System.in);
		NumberFormat formatter = NumberFormat.getCurrencyInstance();

		// Get the input
		monthlyPayment = Prompt("Please enter your mortgage payment: $", consoleScanner);
		balance = Prompt("Please enter outstanding balance on mortgage: $", consoleScanner);

		// Close the scanner
        consoleScanner.close();
        
		// Calculations
		monthlyInterest = balance * rate / 12;

		// Display the result
		System.out.println();
		System.out.println("Of your " + formatter.format(monthlyPayment) + " mortgage payment:");
		System.out.println(formatter.format(monthlyInterest) + " goes to interest");
		System.out.println(formatter.format(monthlyPayment - monthlyInterest) + " goes to principal");
	}

	public static double Prompt(String message, Scanner scanner) {
		// Variables
		double result;

		// Print the message
		System.out.print(message);

		// Loop until user enters a valid number
		while (!scanner.hasNextDouble()) {
			// Print error
			System.out.println("\nError. You must to enter a valid number.");

			// Print the message again
			System.out.print(message);

			// Next token
			scanner.next();
		}

		// Get the number
		result = scanner.nextDouble();

		// Check if the number is positive or negative
		if (result >= 0) {
			// Return the number
			return result;
		} else {
			// Print error
			System.out.println("\nSorry. You should enter a POSITIVE number.\n");

			// Recursion
			return Prompt(message, scanner);
		}
	}
}
