package com.learning.recursion;

public class RotatedBinarySearch {

	public static void main(String[] args) {
		int arr[] = { 1, 3, 4, 6, 88, 99, 200 };
		int target = 3;
		System.out.println(search(arr, target, 0, arr.length - 1));
	}

	public static int search(int arr[], int target, int s, int e) {
		if (s > e) {
			return -1;
		}
		int mid = s + (e - s) / 2;

		if (arr[mid] == target) {
			return mid;
		}
		if (target < arr[mid]) {
			return search(arr, target, s, mid - 1);
		}
		return search(arr, target, mid + 1, e);

	}

}
