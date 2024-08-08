package com.kanchan.linkedlist;

import java.util.HashSet;

public class HappyNumber {

	// Function to calculate the sum of squares of digits of a number
	public static int sumOfSquares(int n) {
		int sum = 0;
		while (n > 0) {
			int digit = n % 10;
			sum += digit * digit;
			n /= 10;
		}
		return sum;
	}

	// Function to determine if a number is a happy number
	public static boolean isHappy(int n) {
		HashSet<Integer> seenNumbers = new HashSet<>();

		while (n != 1 && !seenNumbers.contains(n)) {
			seenNumbers.add(n);
			n = sumOfSquares(n);
		}

		return n == 1;
	}

	public static void main(String[] args) {
		int number = 2; // Example number to test

		if (isHappy(number)) {
			System.out.println(number + " is a happy number.");
		} else {
			System.out.println(number + " is not a happy number.");
		}
	}
}
