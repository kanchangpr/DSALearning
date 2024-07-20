package com.kanchan;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
	public static int longestConsecutive(int[] nums) {
		Set<Integer> numSet = new HashSet<>();
		for (int num : nums) {
			numSet.add(num);
		}

		int maxLength = 0;

		for (int num : numSet) {
			// Check if num-1 is not in the set, meaning num is the start of a sequence
			if (!numSet.contains(num - 1)) {
				int currentNum = num;
				int currentLength = 1;

				// Expand the sequence
				while (numSet.contains(currentNum + 1)) {
					currentNum++;
					currentLength++;
				}

				// Update maxLength if currentLength is greater
				maxLength = Math.max(maxLength, currentLength);
			}
		}

		return maxLength;
	}

	public static void main(String[] args) {
		int[] nums1 = { 100, 4, 200, 1, 3, 2 };
		System.out.println(longestConsecutive(nums1)); // Output: 4

		int[] nums2 = { 0, 3, 7, 2, 5, 8, 4, 6, 0, 1 };
		System.out.println(longestConsecutive(nums2)); // Output: 9
	}
}
