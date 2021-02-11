// As the last question of a successful interview. your boss gives you a few pieces of paper 
// with numbers on it and asks you to compose a largest number from these numbers. The resulting
// number is going to be your salary, so you are very much interested in maximizing this number.

import java.util.*;

public class Exercise07_MaximumSalary {
    
    // This function returns TRUE if the candidate has to be the new maximum value, or FALSE if
    // the maximum value does not have to change.
    public static boolean isGreaterThan(String candidate, String maxValue) {

        // Create two Strings to generate the 2 possible permutations for the candidate and the 
        // current max value. Theorically, we have to choose the candidate as the new max value 
        // if it produces a larger number when being concatenated before the current max value 
        // than if it is concatenated after it.
        String newCandidate = candidate + maxValue;
        String newMaxValue = maxValue + candidate;

        boolean isGreater = Integer.parseInt(newCandidate) > Integer.parseInt(newMaxValue) ? true : false;

        return isGreater;
    }

    public static void main(String[] args) {

        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);
            
        // Declare and ask the user to enter the input data.
        int quantityOfNumbers, newNumber;
        int maxValue = 0;
        int maxValueIndex = -1;
        String highestNumber = "";
        Vector<Integer> numbers = new Vector<>();

        quantityOfNumbers = input.nextInt();

        for(int i=0; i<quantityOfNumbers; i++) {
            newNumber = input.nextInt();
            numbers.add(newNumber);
        }

        input.close();

        // While the vector is not empty (there are still numbers to select).
        while(numbers.size() != 0) {

            for(int i=0; i<numbers.size(); i++) {

                // If the current value is equal to the max value.
                if(numbers.elementAt(i) == maxValue) {
                    continue;
                } else {
                    // If the candidate can produce a higher number than the current max value.
                    if(isGreaterThan(Integer.toString(numbers.elementAt(i)), Integer.toString(maxValue))) {
                        maxValue = numbers.elementAt(i);
                        maxValueIndex = i;
                    }
                }


            }

            // Remove the current max value from the vector, append it to the result string and restore
            // the values for the next iteration.
            numbers.remove(maxValueIndex);
            highestNumber = highestNumber + Integer.toString(maxValue);
            maxValue = 0;
            maxValueIndex = -1;
        }
        
        // Print the result.
        System.out.println(highestNumber);
        
    }
    
}
