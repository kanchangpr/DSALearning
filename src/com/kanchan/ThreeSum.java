package com.kanchan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums == null || nums.length < 3)
			return result;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			// Avoid duplicate triplets
			if (i > 0 && nums[i] == nums[i - 1])
				continue;

			// Early termination if the current number is greater than zero
			if (nums[i] > 0)
				break;

			int left = i + 1;
			int right = nums.length - 1;

			while (left < right) {
				int sum = nums[i] + nums[left] + nums[right];

				if (sum == 0) {
					result.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;

					// Avoid duplicate results
					while (left < right && nums[left] == nums[left - 1])
						left++;
					while (left < right && nums[right] == nums[right + 1])
						right--;
				} else if (sum < 0) {
					left++;
				} else {
					right--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums1 = { -1, 0, 1, 2, -1, -4 };
		System.out.println(threeSum(nums1)); // Output: [[-1, -1, 2], [-1, 0, 1]]

		int[] nums2 = { 0, 1, 1 };
		System.out.println(threeSum(nums2)); // Output: []

		int[] nums3 = { 0, 0, 0 };
		System.out.println(threeSum(nums3)); // Output: [[0, 0, 0]]
	}
}
