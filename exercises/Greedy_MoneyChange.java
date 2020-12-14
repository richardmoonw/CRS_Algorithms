// The goal in this problem is to find the minimum number of coins needed to change the input
// value (an integer) into coins with denominations 1, 5 and 10.

import java.util.Scanner;

public class Greedy_MoneyChange {
    public static void main(String[] args) {
        
        // Create the scanner for user input.
        Scanner input = new Scanner(System.in);

        // Ask the user to enter the total amount of money.
        int total;
        total = input.nextInt();
        input.close();

        // Initialize a variable to represent the minimum number of coins required.
        int number_of_coins = 0;

        // Define the possible coins' values (sorted from the largest to the smallest).
        int[] possible_coins = new int[] {10, 5, 1};

        // Declare a variable to iterate over the possible coins' values array.
        int current_coin = 0;

        // While the total has not been covered at all.
        while(total != 0) {

            number_of_coins += total/possible_coins[current_coin];
            total = total % possible_coins[current_coin];
            current_coin += 1;
         
        }

        System.out.println(number_of_coins);

    }

}
