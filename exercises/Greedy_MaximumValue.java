// The goal of this code problem is to implement an algorithm for the fractional knapsack problem
// (in its greedy approach).

import java.util.*;

public class Greedy_MaximumValue {
    public static void main(String[] args) {

        // Create the scanner for user input.
        Scanner input = new Scanner(System.in);

        int number_of_items, capacity, value_column, weight_column, value_per_unit_column;
        float value;
        value = 0.0f;

        // The first array position of each item is the value.
        value_column = 0;

        // The second array position of each item is the weight.
        weight_column = 1;

        // The third array position of each item is the value per unit of weight.
        value_per_unit_column = 2;

        // Ask the user to enter the number of items and the capacity of the knapsack.
        number_of_items = input.nextInt();
        capacity = input.nextInt();

        // Declare the arrays to store the value and weight of each item.
        float[][] items = new float[number_of_items][3];

        // Ask the user to enter the weight and value of each item.
        for(int i=0; i<number_of_items; i++) {
            items[i][value_column] = input.nextFloat();
            items[i][weight_column] = input.nextFloat();
            items[i][value_per_unit_column] = (float)items[i][value_column]/(float)items[i][weight_column];
        }

        input.close();

        // Sort the items by their value per weight unit.
        sortByColumn(items, value_per_unit_column);

        int current_item = 0;

        // While the bag is not full and there are items remaining.
        while(capacity > 0 && current_item < number_of_items) {
            // If the item fits perfectly in the bag.
            if(items[current_item][weight_column] <= capacity) {
                value += items[current_item][value_column];
                capacity -= items[current_item][weight_column];
                current_item++;
            }
            // If only a part of the item can be added to the bag. 
            else {
                value += (float)capacity * items[current_item][value_per_unit_column];
                capacity = 0;
            }
        }
        
        System.out.println(value);  
    }    

    // Function to sort by column.
    public static void sortByColumn(float items[][], int column) {

        // Using built-in sort function Arrays.sort
        Arrays.sort(items, new Comparator<float[]>() {
            
            // Compare values according to column.
            @Override
            public int compare (final float[] element1, final float[] element2) {

                if(element1[column] < element2[column])
                    return 1;
                else
                    return -1;
            }
        });
    }
}
