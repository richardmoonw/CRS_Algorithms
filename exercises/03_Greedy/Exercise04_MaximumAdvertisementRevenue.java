// You have n ads to place on a popular Internet page. For each ad. you know how much is the 
// advertiser willing to pay for one click on this ad. You have set up n slost on your page and
// estimated the expected number of clicks per day for each slot. Now, your goal is to distribute
// the ads among the slots to maximize the total revenue. 

// Given two sequences a1, a2, ..., an (ai is the profit per click of the i-th ad) and
// b1, b2, ..., bn (bi is the average number of clicks per day of the i-th slot), we need to 
// partition them into n pairs (ai, bi) such that the sum of their products is maximized.  

import java.util.*;

public class Exercise04_MaximumAdvertisementRevenue {

    public static void main(String[] args) {

        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);

        // Declare and ask the user to enter the input data.
        int numberOfAdsAndSlots = 0;
        long totalPayment = 0;

        numberOfAdsAndSlots = input.nextInt();

        Integer[] adsPayments = new Integer[numberOfAdsAndSlots];
        Integer[] slotsClicks = new Integer[numberOfAdsAndSlots];

        for(int i=0; i<numberOfAdsAndSlots; i++) {
            adsPayments[i] = input.nextInt();
        }

        for(int i=0; i< numberOfAdsAndSlots; i++) {
            slotsClicks[i] = input.nextInt();
        }

        // Order the arrays in descending order to make easier the process of 
        // forming pairs with the highest possible revenue.
        Arrays.sort(adsPayments, Collections.reverseOrder());
        Arrays.sort(slotsClicks, Collections.reverseOrder());

        // Multiply the ads with highest revenue by the slot with the highest number 
        // of possible clicks and add the result to the total. Then discard these values 
        // and proceed with the next 2.
        for(int i=0; i<numberOfAdsAndSlots; i++) {
            totalPayment += adsPayments[i].longValue() * slotsClicks[i].longValue();
        }

        System.out.println(totalPayment);

    }



}