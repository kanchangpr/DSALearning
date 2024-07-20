package com.learning.recursion;

public class ProductOfNNum {
	public static void main(String[] args) {
		System.out.println(product(1, 4));
	}

	public static int product(int start, int end) {
		if (start > end) {
			return 1; // base case: if start exceeds end, return 1 (multiplicative identity)
		}
		return start * product(start + 1, end); // recursive call
	}
}
