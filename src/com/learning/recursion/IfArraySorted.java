package com.learning.recursion;

public class IfArraySorted {
	public static void main(String[] args) {
		int[] arr = { 1 };
		System.out.println(ifArraySorted(arr, 0));
	}

	private static boolean ifArraySorted(int[] arr, int start) {
		if (arr.length==0) {
			return true;
		}
		if (start == arr.length-1) {
			return true;
		}
		if (arr[start] <= arr[start + 1]) {
			return ifArraySorted(arr, start + 1);
		}else {
			return false;
		}
	}
}
