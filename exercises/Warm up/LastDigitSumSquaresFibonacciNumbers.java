// Compute the last digit of F0^2 + F1^2 + ... + Fn^2.

import java.util.Scanner;

public class LastDigitSumSquaresFibonacciNumbers {
    
    public static void main (String[] args) {

        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);

        long huge_number, position_at_period;
        int pisano_period_of_10, sum_last_digit;

        position_at_period = 0;
        pisano_period_of_10 = 60;
        sum_last_digit = 0;

        // Ask the user to enter the input.
        huge_number = input.nextLong();

        input.close();

        // Define which position in the Pisano Period the huge number has.
        position_at_period = huge_number % pisano_period_of_10;

        sum_last_digit = calculateLastDigitofFibonacciSumSquaresNumbers((int) position_at_period);

        System.out.println(sum_last_digit);
    }

    public static int calculateLastDigitofFibonacciSumSquaresNumbers (int position) {

        int result, temp, previous, current;

        result = 0;
        temp = 0;
        previous = 0;
        current = 1;

        // If the position is the first or second one within the Pisano Period.
        if (position == 0) {
            return 0;
        }
        else if (position == 1) {
            return 1;
        }

        for(int i = 2; i <= position; i++) {
            temp = previous;
            previous = current;
            current = (temp + current) % 10;
        }

        // The result of the squares aggregation within a Fibonacci Sequence is expressed as follows:
        // Σ F1^2, F2^2, ... , Fn^2 = Fn * (Fn + Fn-1).
        // The same formula can be applied if we are looking only for the last digits.
        result = (current * ((current + previous) % 10)) % 10;

        return result;
    }
    

}
