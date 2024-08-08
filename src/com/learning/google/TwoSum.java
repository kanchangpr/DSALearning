package com.learning.google;

import java.util.HashMap;

/**
 * Solution for Two Sum problem.
 * 
 * Given an array of integers `nums` and an integer `target`, this program
 * returns indices of the two numbers such that they add up to `target`. Assumes
 * each input has exactly one solution and does not use the same element twice.
 * 
 * Example: Input: nums = [2, 7, 11, 15], target = 9 Output: [0, 1] Explanation:
 * Because nums[0] + nums[1] == 9, we return [0, 1].
 * 
 * Time Complexity: O(n) Space Complexity: O(n) Where n is the number of
 * elements in the array.
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement)) {
				return new int[] { map.get(complement), i };
			}
			map.put(nums[i], i);
		}

		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		TwoSum solution = new TwoSum();
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		int[] result = solution.twoSum(nums, target);
		System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
		// Output: Indices: [0, 1]
	}
}
