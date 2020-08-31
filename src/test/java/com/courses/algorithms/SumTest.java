package com.courses.algorithms;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;
import java.util.Random;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

class SumTest {

	// Create an new OutputStream.
	static ByteArrayOutputStream os = new ByteArrayOutputStream();

	@BeforeAll
	public static void changeSystemOutput(){
		System.setOut(new PrintStream(os));
	}

	@AfterAll
	public static void restoreSystemOutput(){
		System.setOut(null);
	}

	@Test
	public void testSum() {
		
		// Initilize the object of the class to be tested.
		Sum sum = new Sum();

		// Initialize the variables to be used for the test.
		Random rand = new Random();
		int number1, number2;
		String inputData, expectedResult;

		// Create a loop to test the method for multiple values.
		for(int x=0; x<10; x++) {

			try {
				os.reset();
			} catch(Exception ex) {
				ex.printStackTrace();
			}

			// Generate random numbers for the test. 
			number1 = rand.nextInt(100);
			number2 = rand.nextInt(100);
			inputData = String.format("%1$s %2$s", Integer.toString(number1), Integer.toString(number2));
			System.setIn(new ByteArrayInputStream(inputData.getBytes()));

			sum.sum();

			expectedResult = Integer.toString(number1 + number2);
			assertEquals(expectedResult, os.toString());
		}
		
	}
}

