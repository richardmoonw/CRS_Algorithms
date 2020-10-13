// The least common multiple of two positive integers a and b is the least positive 
// integer m that is divisible by both a and b. The goal in this problem is that given
// two integers a and b, find their least common multiple.
import java.util.Scanner;

public class LeastCommonMultiple {
    public static void main (String[] args){

        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);

        // Ask the user to input 2 numbers.
        long numberOne, numberTwo;
        numberOne = input.nextLong();
        numberTwo = input.nextLong();

        // Calculate the Greatest Common Divisor.
        long gcd = findGCD(numberOne, numberTwo);

        // Calculate the Least Common Multiple. 
        // LCM = (Number1 * Number2) / GCD;
        long leastCommonMultiple = (numberOne * numberTwo) / gcd;

        // Print the result on screen and close the input.
        System.out.print(leastCommonMultiple);
        input.close();

    }

    // Greatest Common Divisor (Euclidean) algorithm:
    // function euclidGCD(a, b)
    //     if b = 0
    //         return a
    //     else
    //         a' = remainder when a is divided by b
    //         euclidGCD(b, a')
    public static long findGCD(long a, long b) {
        if (b == 0)
            return a;
        else {
            long temp = a;
            a = b;
            b = temp % b;
            return findGCD(a, b);
        }
    }
}