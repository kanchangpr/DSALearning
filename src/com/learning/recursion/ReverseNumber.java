package com.learning.recursion;

public class ReverseNumber {
	public static void main(String[] args) {
		int rev = 0;
		System.out.println(reverseNumber(12345, rev));
	}

	public static int reverseNumber(int n, int rev) {
		if (n == 0) {
			return rev;
		}
		int r = n % 10;
		int q = n / 10;
		rev = rev * 10 + r;
		return reverseNumber(q, rev);
	}
}
