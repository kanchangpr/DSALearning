package com.learning.recursion;

public class CountSteps {
	public static void main(String[] args) {
		System.out.println(countSteps(14));
	}

	public static int countSteps(int n) {
		if (n == 0) {
			return 0;
		}
		if (n % 2 == 0) {
			return 1 + countSteps(n / 2);
		}
		return 1 + countSteps(n - 1);
	}
}
