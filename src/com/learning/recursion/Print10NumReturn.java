package com.learning.recursion;

public class Print10NumReturn {
	public static void main(String[] args) {
		System.out.println(print10(10));
	}

	public static int print10(int n) {
		if (n == 1) {
			return n;
		}
		System.out.println(n);
		return print10(n - 1);
	}
}
