// You are organizing a funny competition for children. As a prize fund you have n candies.
// You would like to use these candies for top k places in a competition with a natural restriction
// that a higher place gets a larger number of candies. To make as many children happy as possible,
// you are going to find the largest value of k for which it is possible.
// The goal of this problem is to represent a given positive integer n as a sum of as many pairwise 
// distinct positive integers as possible. That is, to find the maximum k such that n can be written 
// as a1 + a2 + ... + ak where a1, ..., ak are positive integers and a1 != aj for all 1 <= i < j <= k.

import java.util.*;

public class Exercise06_MaximumNumberPrizes {

    public static void main (String[] args) {

        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);

        // Declare and ask the user to enter the input data.
        int numberOfCandies = 0;

        numberOfCandies = input.nextInt();

        Vector<Integer> candiesPrizes = new Vector<>();
        int currentPrize = 1;
        long leftoverCandies = 0;
        long candiesUsed = 0;

        // While the number of candies used is less than the number of candies available.
        while (candiesUsed < numberOfCandies) {

            // If there are candies enough to satisfy another 2 more better prizes.
            if (candiesUsed + currentPrize + (currentPrize + 1) <= numberOfCandies) {
                candiesUsed += currentPrize;
                candiesPrizes.add(currentPrize);
                currentPrize++;
            } else {
                leftoverCandies = numberOfCandies - candiesUsed;
                candiesPrizes.add((int) leftoverCandies);
                candiesUsed += leftoverCandies;
            }
        }

        // Print the results
        System.out.println(candiesPrizes.size());

        for(int i=0; i<candiesPrizes.size(); i++) {
            if (i < candiesPrizes.size() - 1) {
                System.out.print(candiesPrizes.elementAt(i) + " ");
            } else {
                System.out.println(candiesPrizes.elementAt(i));
            }
        }
    }
}