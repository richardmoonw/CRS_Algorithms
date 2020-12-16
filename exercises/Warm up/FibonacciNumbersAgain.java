// In this problem, your goal is to compute Fibonacci(n) modulo m, where n may be really huge: up to 10^14.
// For such values of n, an algorithm looping for n iterations will not fit into one second for sure. Therefore 
// we need to avoid such a loop.

import java.util.Scanner;


public class FibonacciNumbersAgain {
    
    public static void main(String[] args) {
        
        // Create the scanner for user input.
        Scanner input = new Scanner(System.in);

        long huge_number;
        int modulo, pisano_period, short_number, result;

        // Ask the user to enter the input.
        huge_number = input.nextLong();
        modulo = input.nextInt();

        input.close();
        
        // Calculate the Pisano period of the given modulo.
        pisano_period = calculatePisanoPeriod(modulo);

        // Get the Pisano Period's ith element to make easier the calculation of the
        // result. If we know that a given X number is in the ith position of the period,
        // we can make an easier loop from 2 to the ith element calculated instead of 
        // looping from 2 to the huge number to find the result.
        short_number = (int)(huge_number % pisano_period);

        // Calculate the result of the Fib(ith element) mod X.
        result = calculateFibonacciWithModulo(short_number, modulo);

        System.out.println(result);
    }

    // Function used to calculate the Fibonacci Numbers' Pisano Period taken a modulo.
    public static int calculatePisanoPeriod(int modulo) {

        // Declare and initialize the required variables.
        int period, temp, previous, current;
        period = 0;
        previous = 0;
        current = 1;

        // The Pisano period is the period within which the sequence of Fibonacci numbers taken 
        // modulo n repeats.
        for(int i=2; i<=modulo*modulo; i++) {
            period++;
            temp = previous;
            previous = current;

            // If you wanna calculate the Fibonacci of a given number X mod Y, you can caculate it and its
            // predecessors given the formula:
            // Fib(X) mod Y = [ Fib(X-1) + Fib(X-2) ] mod Y. 
            current = (temp + current) % modulo;

            // Every period start always with 01 (not repeated more than once in the period), 
            // so when we find these 2 numbers we can return the period length.
            if(previous == 0 && current == 1) {
                return period;
            }
        }
        
        return -1;
    }

    // Function used to calculate the modulo of a requested Fibonacci number.
    public static int calculateFibonacciWithModulo(int number, int modulo) {
        int temp, previous, current;

        previous = 0;
        current =1;

        // If you wanna calculate the Fibonacci of a given number X mod Y, you can caculate it and its
        // predecessors given the formula:
        // Fib(X) mod Y = [ Fib(X-1) + Fib(X-2) ] mod Y. 
        for(int i=2; i<=number; i++){
            temp = previous;
            previous = current;
            current = (temp + current) % modulo;
        }

        return current;
    }
}
