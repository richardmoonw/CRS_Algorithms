package com.courses.algorithms;

import java.util.Scanner;
import java.util.Vector;

class MaximumPairwiseProduct {

	public long run (Vector<Long> numbers){

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

		return first_maximum*second_maximum;
	}
}
	