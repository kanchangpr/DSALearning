package com.learning.recursion;

public class LinearSearch {
	public static void main(String[] args) {
		int[] arr = { 1 };
		int target = 8;
		System.out.println(linearSearch(arr, 0, target));
	}

	private static boolean linearSearch(int[] arr, int ind, int target) {
		if (arr.length==0 || ind > arr.length-1) {
			return false;
		}	
		if (arr[ind] == target) {
			return true;
		}else {
			return linearSearch(arr, ind + 1, target);
		}
	}
}
