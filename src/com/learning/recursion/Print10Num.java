package com.learning.recursion;

public class Print10Num {
	public static void main(String[] args) {
		print10(10);
	}
	
	
	public static void print10(int n) {
		if (n==0) {
			return;
		}
		System.out.println(n);
		print10(n-1);
	}
}
