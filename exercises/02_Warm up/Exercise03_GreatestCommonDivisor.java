// The goal in this problem is to implement the Euclidean algorithm for computing the 
// greatest common divisor.

import java.util.Scanner;

public class Exercise03_GreatestCommonDivisor {
    
    public static void main(String[] args) {

        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);

        // Ask the user to input 2 numbers.
        int numberOne, numberTwo;
        numberOne = input.nextInt();
        numberTwo = input.nextInt();

        // Calculate the Greatest Common Divisor.
        int result = findGCD(numberOne, numberTwo);

        // Print the result on screen and close the input.
        System.out.println(result);
        input.close();
    }

    // Greatest Common Divisor (Euclidean) algorithm:
    // function euclidGCD(a, b)
    //     if b = 0
    //         return a
    //     else
    //         a' = remainder when a is divided by b
    //         euclidGCD(b, a')
    public static int findGCD(int a, int b) {
        if (b == 0)
            return a;
        else {
            int temp = a;
            a = b;
            b = temp % b;
            return findGCD(a, b);
        }
    }
}
