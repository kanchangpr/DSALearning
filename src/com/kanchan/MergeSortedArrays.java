package com.kanchan;

public class MergeSortedArrays {
	public static void merge(int[] nums1, int m, int[] nums2, int n) {
		int k = m + n - 1;
		int p1 = m - 1;
		int p2 = n - 1;
		while (p1 >= 0 || p2 >= 0) {
			if (p1>=0 && p2>=0 && nums1[p1] > nums2[p2]) {
				nums1[k] = nums1[p1];
				k--;
				p1--;
			} else {
				nums1[k] = nums2[p2];
				k--;
				p2--;
			}
		}
		/*
		 * while (p2 >= 0) { nums1[k] = nums2[p2]; k--; p2--; }
		 */

	}

	public static void main(String[] args) {
		int[] nums1 = { 0 };
		int m = 0;
		int[] nums2 = { 1 };
		int n = 1;

		merge(nums1, m, nums2, n);

		// Print the merged array
		for (int num : nums1) {
			System.out.print(num + " ");
		}
		// Output: 1 2 2 3 5 6
	}
}
