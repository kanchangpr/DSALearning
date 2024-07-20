package com.learning.recursion;

public class ProductOfDigit {
	public static void main(String[] args) {
		System.out.println(sumOfDigit(12345));
	}

	public static int sumOfDigit(int n) {
		if (n / 10 == 0) {
			return n;
		}
		return n % 10 * sumOfDigit(n / 10);
	}
}
