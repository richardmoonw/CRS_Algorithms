// In this very first programming challenge, your goal is to implement a program that 
// reads two digits from the standard input and prints their sum to the standard output. 
// @author: Ricardo Luna.

import java.util.Scanner;

class Sum {
	public static void main (String[] args) {
		
		// Create the input to enter data. 
		Scanner input = new Scanner(System.in);

		// Declare and define the variables required.
		int number1, number2, result;
		number1 = input.nextInt();
		number2 = input.nextInt();

		// Calculate the result.
		result = number1 + number2;

		// Print the result and close the input.
		System.out.print(Integer.toString(result));
		input.close();
	}
}