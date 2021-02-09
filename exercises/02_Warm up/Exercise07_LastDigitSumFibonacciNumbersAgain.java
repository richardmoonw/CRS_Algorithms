// We would like to find the last digit of a partial sum of Fibonacci numbers: 
// Fm +  Fm+1 + Fm + ... + Fn.

import java.util.Scanner;

public class Exercise07_LastDigitSumFibonacciNumbersAgain {
    
    public static void main (String[] args) {

        // Create the scanner for user input.
        Scanner input = new Scanner(System.in);

        long lower_limit, lower_cycle, lower_position, upper_limit, upper_cycle, 
            upper_position, number_of_chunks;
        int pisano_period_of_10, sum_last_digit, chunk_last_digits_agg;

        // The Pisano Period of 10 is 60.
        chunk_last_digits_agg = 1;
        sum_last_digit = 0;
        pisano_period_of_10 = 60;

        // Ask the user to enter the input data.
        lower_limit = input.nextLong();
        upper_limit = input.nextLong();

        input.close();

        // Define in which cycle of the Pisano Period the limits are. This can help us 
        // to know if they are in the same one (if that's the case we simply iterate from
        // the lower_limit position to the upper_limit position of the Pisano Period and 
        // make the correspondent addition).
        lower_cycle = lower_limit / pisano_period_of_10;
        upper_cycle = upper_limit / pisano_period_of_10;

        // Calculate in which position of the Pisano Period of 10 are each of the given 
        // limits.
        lower_position = lower_limit % pisano_period_of_10;
        upper_position = upper_limit % pisano_period_of_10;

        // If the lower_limit and the upper_limit are in the same cycle of the Pisano Period.
        if (upper_cycle == lower_cycle) {

            // Calculate the aggregate of the last digits from the lower_limit to the
            // upper_limit.
            sum_last_digit = calculateLastDigitOfFibonacciSum((int) lower_position, (int) upper_position);
        } 

        // If the cycles of the upper_limit and the lower_limit are adjacents.
        else if (upper_cycle - lower_cycle == 1) {

            // Add the aggregation of the last digits from the lower_limit to the end of 
            // the Pisano Period.
            sum_last_digit = (sum_last_digit + calculateLastDigitOfFibonacciSum((int) lower_position, pisano_period_of_10 - 1));

            // Add the aggregation of the last digits from 0 to the upper_limit position.
            sum_last_digit = (sum_last_digit + calculateLastDigitOfFibonacciSum(0 , (int) upper_position));
        }

        // If the upper_limit and the lower_limit are in different and non adjacent cycles of the Pisano Period.
        else if (upper_cycle != lower_cycle && upper_cycle - lower_cycle > 1) {

            // Add the aggregation of the last digits from the lower_limit to the end of 
            // the Pisano Period.
            sum_last_digit = (sum_last_digit + calculateLastDigitOfFibonacciSum((int) lower_position, pisano_period_of_10 - 1)) % 10;

            // Add the aggregation of the last digits from 0 to the upper_limit position.
            sum_last_digit = (sum_last_digit + calculateLastDigitOfFibonacciSum(0 , (int) upper_position)) % 10;


            number_of_chunks = (upper_limit - lower_limit) / pisano_period_of_10;
            chunk_last_digits_agg = calculateLastDigitOfFibonacciSum(0, pisano_period_of_10 - 1);

            sum_last_digit = (sum_last_digit + ((int) number_of_chunks * chunk_last_digits_agg) % 10) % 10;
        }

        System.out.println(sum_last_digit);

    }

    // Method used to calculate the addition of the last digits of a Fibonacci sequence.
    public static int calculateLastDigitOfFibonacciSum(int lower_limit, int upper_limit) {

        int sum_last_digit, temp, previous, current;
        sum_last_digit = 0;
        temp = 0; 
        previous = 0;
        current = 1;

        // If the Fibonacci requested is F0 or F1.
        if (upper_limit == 0) {
            return 0;
        }
        else if (upper_limit == 1) {
            return 1;
        }

        for(int i = 2; i <= upper_limit; i++) {

            temp = previous;
            previous = current;
            current = (current + temp) % 10;

            if (i >= lower_limit) {

                // If it is the first iteration (we shall add the value of F1).
                if(i == 2) {
                    sum_last_digit = (sum_last_digit + current) % 10;
                }

                sum_last_digit = (sum_last_digit + current) % 10;
            }
        }

        return sum_last_digit;
    }
    





}
