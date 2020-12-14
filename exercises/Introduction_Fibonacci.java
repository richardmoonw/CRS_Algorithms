// Recall the definition of Fibonacci sequence: F0=0, F1=1, Fi = Fi-1 + Fi-2 for i >= 2. 
// The goal in this problem is to implement an efficient algorithm for computing Fibonacci numbers.

import java.util.Scanner;

class Introduction_Fibonacci {
    public static void main(String[] args) {

        // Create the scanner for user input.
        Scanner input = new Scanner(System.in);

        // Ask the user for a number.
        int position;
        position = input.nextInt();

        // Calculate the result the number-th element of the Fibonacci sequence.
        int result = calculateFibonacci(position);

        // Print the result on screen and close the Scanner.
        System.out.print(result);
        input.close();
    } 

    // Method used to calculate Fibonacci iteratively.
    static int calculateFibonacci(int number) {

        if (number <= 1) {
            return number;
        }

        // Declare the first Fibonacci numbers.
        int previous = 0;
        int current = 1;
        int temp;

        // Find the number-th element of the Fibonacci sequence.
        for (int i = 2; i <= number; i++) {
            temp = previous;
            previous = current;
            current = previous + temp;
        }
        
        // Return the result.
        return current;
    }
}