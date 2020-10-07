package com.courses.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Vector;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaximumPairwiseProductTest {

    public long maximumPairwiseProduct(Vector<Long> numbers){
        long maxValue = 0;
        for(int i = 0; i < numbers.size(); i++) {
            for(int j = i + 1; j < numbers.size(); j++) {
                if(numbers.get(i) * numbers.get(j) > maxValue) {
                    maxValue = numbers.get(i) * numbers.get(j);
                }
            }
        }
        return maxValue;
    }

    @Test
    public void testMaximumPairwiseProduct() {

        // Initialize the object of the class to be tested.
        MaximumPairwiseProduct maximumPP = new MaximumPairwiseProduct();

        // Initialize the variables to be used for testing.
        Random rand = new Random();
        int numberOfTests;
        long totalNumbers, number;
        Vector<Long> numbers = new Vector<Long>();

        numberOfTests = rand.nextInt(20) + 5;
        totalNumbers = rand.nextLong() % 200000;

        for(int i = 0; i < numberOfTests; i++) {
            numbers.clear();
            for(int j = 0; j < totalNumbers; j++) {
                number = rand.nextLong() % 200000;
                numbers.add(number);
            }
            assertEquals(maximumPP.run(numbers), maximumPairwiseProduct(numbers));
        }
    }
}
