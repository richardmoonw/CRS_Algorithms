// As the last question of a successful interview. your boss gives you a few pieces of paper 
// with numbers on it and asks you to compose a largest number from these numbers. The resulting
// number is going to be your salary, so you are very much interested in maximizing this number.

import java.util.*;

public class Exercise07_MaximumSalary {
    
    public static boolean isGreaterThan(String candidate, String maxValue) {

        boolean isGreater = false;
        int candidateNumeric = Integer.parseInt(candidate);
        int maxValueNumeric = Integer.parseInt(maxValue);

        // If both numbers have the same length, just return true if the candidate is greater than
        // the current max value.
        if(candidate.length() == maxValue.length()) {
            isGreater = candidateNumeric > maxValueNumeric ? true : false;
        } else {

            int minimumSize = candidate.length() < maxValue.length() ? candidate.length() : maxValue.length();  
            for(int i=0; i<minimumSize; i++) {
                if((int) candidate.charAt(i) < (int) maxValue.charAt(i)) {
                    return isGreater;
                }
            }

            if(candidate.length() == minimumSize) {
                isGreater = (int) maxValue.charAt(minimumSize) >= (int) candidate.charAt(0) ? false : true;
            } else {
                isGreater = (int) candidate.charAt(minimumSize) >= (int) maxValue.charAt(0) ? true : false;
            }
            
        }

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
                    if(isGreaterThan(Integer.toString(numbers.elementAt(i)), Integer.toString(maxValue))) {
                        maxValue = numbers.elementAt(i);
                        maxValueIndex = i;
                    }
                }


            }

            numbers.remove(maxValueIndex);
            highestNumber = highestNumber + Integer.toString(maxValue);
            maxValue = 0;
            maxValueIndex = -1;
        }
        
        System.out.println(highestNumber);
        
    }
    
}
