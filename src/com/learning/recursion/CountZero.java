package com.learning.recursion;

public class CountZero {
	public static void main(String[] args) {
		System.out.println(countZero(000));
	}

	public static int countZero(int n) {
		if(n==0) {
			return 0;
		}
		if(n%10==0) {
			return 1 + countZero(n / 10);
		}
		return countZero(n/10);
	}
}
