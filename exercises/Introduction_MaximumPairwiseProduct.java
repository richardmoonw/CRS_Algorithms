// In this programming challenge, your goal is to implement a program that finds 
// the maximum product of two distinct numbers in a sequence of non-negative integers. 
// It should work in less than one second even on huge datasets.
// @author: Ricardo Luna.

import java.util.Scanner;
import java.util.Vector;

class Introduction_MaximumPairwiseProduct {

	public static void main(String[] args) {

		// Create the input to enter data.
		Scanner input = new Scanner(System.in);

		// Declare and define the variables required.
		Vector<Long> numbers = new Vector<Long>();
		long maximumProduct;
		long number;
		int arraySize = input.nextInt();

		// Ask the user to enter all the numbers and add them into the vector.
		for(int i = 0; i < arraySize; i++) {
			number = input.nextLong();
			numbers.add(number);
		}

		// Iterate over the sequence to find the first maximum number in it.
		long first_maximum = 0;
		int first_maximum_index = -1; 
		for(int i=0; i<numbers.size(); i++) {
			if (numbers.get(i) > first_maximum) {
				first_maximum = numbers.get(i);
				first_maximum_index = i;
			}
		}

		// Iterate over the sequence to find the second maximum number in it.
		long second_maximum = 0;
		for(int i=0; i<numbers.size(); i++){
			if(numbers.get(i) > second_maximum && i != first_maximum_index){
				second_maximum = numbers.get(i);
			}
		}

		// Calculate the result, print it and close the input.
		maximumProduct = first_maximum * second_maximum;
		System.out.print(maximumProduct);
		input.close();
	}
}
	