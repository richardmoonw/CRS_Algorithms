// Recall the definition of Fibonacci sequence: F0=0, F1=1, Fi = Fi-1 + Fi-2 for i >= 2. 
// The goal in this problem is to implement an efficient algorithm for computing Fibonacci numbers.

import java.util.Scanner;

class Fibonacci {
    public static void main(String[] args) {

        // Create the scanner for user input.
        Scanner input = new Scanner(System.in);

        // Ask the user for a number.
        int position = input.nextInt();

        // Calculate the result of the Fibonacci sequence at the given position.
        int result = calculateFibonacci(position);

        // Print the result on screen and close the Scanner.
        System.out.print(result);
        input.close();
    } 

    // Method used to calculate Fibonacci recursively. (It is not the best solution but it
    // is the requirement [despite it is asked to develop a efficient algorithm and this is not])
    static int calculateFibonacci(int number) {
        if (number <= 1) {
            return number;
        }
        else {
            return calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
        }
    }
}