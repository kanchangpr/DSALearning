package com.learning.recursion;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] arr = { 3, 2, 4, 6, 1, 3, 7, 8 };
		int[] res = mergeSort(arr);
		for (int i : res) {
			System.out.println(i);
		}

		/*
		 * int[] res1 = mergeSortInPlace(arr, 0, arr.length - 1); for (int i : res1) {
		 * System.out.println(i); }
		 */
	}

	static int[] mergeSort(int[] arr) {
		if (arr.length == 1) {
			return arr;
		}
		int mid = arr.length / 2;
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right = mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

		return merge(left, right);
	}

	static void mergeSortInPlace(int[] arr, int start, int end) {
		if (end - start == 1) {
			return;
		}
		int mid = start + (end - start) / 2;
		mergeSortInPlace(arr, start, mid);
		mergeSortInPlace(arr, mid, end);

		//return merge(left, right);
	}

	private static int[] merge(int[] left, int[] right) {
		int[] mix = new int[left.length + right.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				mix[k] = left[i];
				i++;
				k++;
			} else {
				mix[k] = right[j];
				k++;
				j++;
			}
		}

		while (i < left.length) {
			mix[k] = left[i];
			i++;
			k++;
		}
		while (j < right.length) {
			mix[k] = right[j];
			k++;
			j++;
		}
		return mix;
	}

}
