import java.util.Scanner;
import java.util.Vector;

class MaximumPairwiseProduct {
	public static void main (String[] args){
		
		// Create the Scanner tp input all the values.
		Scanner input = new Scanner(System.in);
		
		// Ask to the user to input the number of elements of the sequence and initialize a vector of that specified size.
		int number_of_elements = input.nextInt();
		Vector<Long> numbers = new Vector<Long>(number_of_elements);
		long number = 0;

		// Ask to the user to input all the elements of the sequence and add them to the vector.
		for(int i=0; i<number_of_elements; i++) {
			number = input.nextLong();
			numbers.add(number);
		}

		// Iterate over the sequence to find the first maximum number in it.
		long first_maximum = 0;
		int first_maximum_index = -1; 
		for(int i=0; i<number_of_elements; i++) {
			if (numbers.get(i) > first_maximum) {
				first_maximum = numbers.get(i);
				first_maximum_index = i;
			}
		}

		// Iterate over the sequence to find the second maximum number in it.
		long second_maximum = 0;
		for(int i=0; i<number_of_elements; i++){
			if(numbers.get(i) > second_maximum && i != first_maximum_index){
				second_maximum = numbers.get(i);
			}
		}

		System.out.println(first_maximum*second_maximum);

		// Close the Scanner.
		input.close();
	}
}
	