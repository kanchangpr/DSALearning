package com.kanchan;

public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int target, int[] nums) {
		int n = nums.length;
		int minLength = Integer.MAX_VALUE;
		int left = 0;
		int currentSum = 0;

		for (int right = 0; right < n; right++) {
			currentSum += nums[right];

			while (currentSum >= target) {
				minLength = Math.min(minLength, right - left + 1);
				currentSum -= nums[left];
				left++;
			}
		}

		return minLength == Integer.MAX_VALUE ? 0 : minLength;
	}

	public static void main(String[] args) {
		int target1 = 7;
		int[] nums1 = { 2, 3, 1, 2, 4, 3 };
		System.out.println(minSubArrayLen(target1, nums1)); // Output: 2

		int target2 = 4;
		int[] nums2 = { 1, 4, 4 };
		System.out.println(minSubArrayLen(target2, nums2)); // Output: 1

		int target3 = 11;
		int[] nums3 = { 1, 1, 1, 1, 1, 1, 1, 1 };
		System.out.println(minSubArrayLen(target3, nums3)); // Output: 0
	}
}
