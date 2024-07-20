package com.learning.recursion;

public class SumOfDigit {
	public static void main(String[] args) {
		System.out.println(sumOfDigit(543));
	}

	public static int sumOfDigit(int n) {
		if (n / 10 == 0) {
			return n;
		}
		int q = n / 10;
		int r = n % 10;
		return r + sumOfDigit(q);
	}
}
