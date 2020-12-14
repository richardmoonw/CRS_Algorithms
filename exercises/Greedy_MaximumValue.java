// The goal of this code problem is to implement an algorithm for the fractional knapsack problem
// (in its greedy approach).

import java.util.Scanner;

public class Greedy_MaximumValue {
    public static void main(String[] args) {

        // Create the scanner for user input.
        Scanner input = new Scanner(System.in);

        // Ask the user to enter the number of items and the capacity of the knapsack.
        int items, capacity;
        items = input.nextInt();
        capacity = input.nextInt();

        // Declare the arrays to store the value and weight of each item.
        int[] values = new int[items];
        int[] weights = new int[items];

        // Ask the user to enter the weight and value of each item.
        for(int i=0; i<items; i++) {
            values[i] = input.nextInt();
            weights[i] = input.nextInt();
        }

        input.close();

        // Define an array to store the value per unit of weight of each given item.
        float[] value_per_unit = new float[items];
        for(int i=0; i<items; i++) {
            value_per_unit[i] = (float)values[i]/(float)weights[i];
            System.out.println(value_per_unit[i]);
        }
    }    
}
