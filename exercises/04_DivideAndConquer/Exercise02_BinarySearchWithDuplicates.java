// In this problem, you will implement the binary search algorithm that allows searching
// elements very efficiently in (even huge) lists. Nevertheless, the task of the program
// is to find the first occurrence of an integer in the given sorted sequence of integers
// (possibly with duplicates).

import java.util.*;

public class Exercise02_BinarySearchWithDuplicates {
    
  public static void main (String[] args) {
    // Create the Scanner for user input.
    Scanner input = new Scanner(System.in);

    // Declare and ask the user to enter the input data.
    int sequenceNumbers = 0, searchedNumbers = 0;
    int[] sortedSequence, searchedElements, returnIndexes;

    // Number of elements in the list and elements themselves.
    sequenceNumbers = input.nextInt();
    sortedSequence = new int[sequenceNumbers];

    for(int i=0; i<sequenceNumbers; i++) {
      sortedSequence[i] = input.nextInt();
    }

    // Number of searched elements and elements themselves.
    searchedNumbers = input.nextInt();
    searchedElements = new int[searchedNumbers];
    returnIndexes = new int[searchedNumbers];

    for(int i=0; i<searchedNumbers; i++) {
      searchedElements[i] = input.nextInt();
    }

    input.close();

    // For each searched element, execute the binary search and store the return index.
    BinarySearch binarySearch = new BinarySearch();
    for(int i=0; i<searchedNumbers; i++) {
      returnIndexes[i] = binarySearch.search(sortedSequence, searchedElements[i], 0, sortedSequence.length - 1);
    }

    // Print the results.
    for(int i=0; i<searchedNumbers; i++) {
      System.out.print(returnIndexes[i] + " ");
    }
  }
}

// Declare a private class to handle the binary search.
class BinarySearch {

  // This method performs the binary search over the sorted array.
  // List of parameters and returned values:
  // int[] sequence:      Sorted array.
  // int searchedNumber:  The item we are currently looking for.
  // int lowerLimit:      From what element within the array we perform the searching.
  // int upperLimit:      To what element within the array we perform the searching.
  // return index:        Index within the array of the searched element (-1 if this was not found).
  public int search(int[] sequence, int searchedElement, int lowerLimit, int upperLimit) {

    // Base case
    if (upperLimit < lowerLimit) {
      return -1;
    }

    // Calculate the midpoint
    int m = (upperLimit + lowerLimit) / 2;

    // If the searched number is the correct one
    if(sequence[m] == searchedElement) {
      if (lowerLimit == upperLimit) {
        return m;
      }
      else {
        return search(sequence, searchedElement, lowerLimit, m);
      }
    }

    else if(sequence[m] > searchedElement) {
      return search(sequence, searchedElement, lowerLimit, m - 1);
    }
    else {
      return search(sequence, searchedElement, m + 1, upperLimit);
    }
  }
}
