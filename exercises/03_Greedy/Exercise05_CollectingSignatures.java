// You are responsible for collecting signatures from all tenants of a certain building. For each
// tenant, you know a period of time when he or she is at home. You would like to collect all
// signatures by visiting the building as few times as possible. 
// You are given a set of segments on a line and your goal is to mark as few points on a line as
// possible so that each segment contains at least one marked point.

import java.util.*;

public class Exercise05_CollectingSignatures {

    // Declare static fields to represent important elements.
    private static final int RANGE_ELEMENTS = 2;
    private static final int LOWER_LIMIT = 0;
    private static final int UPPER_LIMIT = 1;

    public static void main(String[] args) {

        // Create the Scanner for user input.
        Scanner input = new Scanner(System.in);

        // Declare and ask the user to enter the input data.
        int numberOfSegments = 0;
        numberOfSegments = input.nextInt();

        Integer[][] segments = new Integer[numberOfSegments][RANGE_ELEMENTS];
        
        // Variables used to iterate over the array of segments. 
        int numberOfPoints = 0;
        Vector<Integer> points = new Vector<>();
        Integer[] currentRange = new Integer[RANGE_ELEMENTS];
        int currentElement = 0;
        boolean activeRange = false;

        // Capture all the segments
        for (int i = 0; i < numberOfSegments; i++) {
            segments[i][LOWER_LIMIT] = input.nextInt();
            segments[i][UPPER_LIMIT] = input.nextInt();
        }

        // Sort the array based on the values of the first column (lower limits of the ranges).
        Arrays.sort(segments, (element1, element2) -> Integer.compare(element1[LOWER_LIMIT], element2[LOWER_LIMIT]));

        while (currentElement < numberOfSegments) {

            // If there is not any active range.
            if (!activeRange) {
                currentRange[LOWER_LIMIT] = segments[currentElement][LOWER_LIMIT];
                currentRange[UPPER_LIMIT] = segments[currentElement][UPPER_LIMIT];

                activeRange = true;
            }

            // If the last segment is being evaluated.
            if (currentElement + 1 == numberOfSegments) {
                numberOfPoints++;
                points.add(currentRange[LOWER_LIMIT]);
                break;
            }

            // If the next segment does not have any point shared with the current one.
            if (segments[currentElement + 1][LOWER_LIMIT] < currentRange[LOWER_LIMIT] 
                    || segments[currentElement + 1][LOWER_LIMIT] > currentRange[UPPER_LIMIT]) {
                    
                numberOfPoints++;
                points.add(currentRange[LOWER_LIMIT]);
                activeRange = false;

                currentElement++;
            } else {
                currentRange[LOWER_LIMIT] = currentRange[UPPER_LIMIT] <= segments[currentElement+1][LOWER_LIMIT] 
                                            ? currentRange[UPPER_LIMIT] : segments[currentElement+1][LOWER_LIMIT];
                currentRange[UPPER_LIMIT] = currentRange[UPPER_LIMIT] <= segments[currentElement+1][UPPER_LIMIT] 
                                            ? currentRange[UPPER_LIMIT] : segments[currentElement+1][UPPER_LIMIT];

                currentElement++;
            }
            
        }

        // Print the results
        System.out.println(points.size());
        
        for (int i=0; i<numberOfPoints; i++) {
            if (i < numberOfPoints - 1) {
                System.out.print(points.elementAt(i) + " ");
            } else {
                System.out.print(points.elementAt(i));
            }
        }

    }
} 