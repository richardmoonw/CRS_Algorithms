// The goal in this problem is to find the last digit of n-th Fibonacci number. 
// Recall that Fibonacci numbers grow exponentially fast.

import java.util.Scanner;

public class LastFibonacciDigit {
    
    public static void main(String[] args) {
        
        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);

        // Ask the user for a number.
        int number;
        number = input.nextInt();

        // Declare the array to store the last digit of the Fibonacci numbers.
        int lastFibonacciDigits[];
        lastFibonacciDigits = new int[number+1];
        lastFibonacciDigits[0] = 0;
        lastFibonacciDigits[1] = 1;

        // Calculate the last digit of the number-th element.
        for(int i = 2; i <= number; i++) {
            lastFibonacciDigits[i] = (lastFibonacciDigits[i-1] + lastFibonacciDigits[i-2]) % 10;
        }

        // Print the result and close the Scanner.
        System.out.print(lastFibonacciDigits[number]);
        input.close();
    }
}
