package com.learning.recursion;

public class CountingPath2dMatrix {
	public static void main(String[] args) {
		System.out.println(countingPath2DMatrix(4,4));
	}
	public static int countingPath2DMatrix(int r, int c) {
		if(r==1 || c==1) {
			return 1;
		}
		int left= countingPath2DMatrix(r-1, c);
		int right= countingPath2DMatrix(r, c-1);
		
		return left+right;
	}
}
