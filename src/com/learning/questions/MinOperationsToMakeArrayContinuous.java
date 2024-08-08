package com.learning.questions;

import java.util.HashSet;
import java.util.Set;

public class MinOperationsToMakeArrayContinuous {

	public int minOperations(int[] nums) {
		Set<Integer> uniqueNumsSet = new HashSet<>();
		for (int num : nums) {
			uniqueNumsSet.add(num);
		}

		// Convert the set to an array
		int[] uniqueNums = uniqueNumsSet.stream().mapToInt(Integer::intValue).toArray();
		int n = nums.length;

		// Find the longest contiguous subarray where max - min == length - 1
		int maxLength = 0;
		int j = 0;

		// Sort the unique numbers to facilitate the sliding window
		java.util.Arrays.sort(uniqueNums);

		for (int i = 0; i < uniqueNums.length; i++) {
			while (j < uniqueNums.length && uniqueNums[j] <= uniqueNums[i] + n - 1) {
				j++;
			}
			maxLength = Math.max(maxLength, j - i);
		}

		return n - maxLength;
	}

	public static void main(String[] args) {
		MinOperationsToMakeArrayContinuous solution = new MinOperationsToMakeArrayContinuous();

		// Test cases
		int[] nums1 = { 4, 2, 5, 3 };
		System.out.println(solution.minOperations(nums1)); // Output: 0

		int[] nums2 = { 1, 2, 3, 5, 6,  };
		System.out.println(solution.minOperations(nums2)); // Output: 1

		int[] nums3 = { 1, 10, 100, 1000 };
		System.out.println(solution.minOperations(nums3)); // Output: 3
	}
}
