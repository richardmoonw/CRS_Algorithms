package com.courses.algorithms;

import java.util.Scanner;

class Sum {

	public void sum() {
		Scanner input = new Scanner(System.in);

		int number1, number2, result;
		number1 = input.nextInt();
		number2 = input.nextInt();
		result = number1 + number2;

		System.out.print(Integer.toString(result));
		input.close();
	}
}