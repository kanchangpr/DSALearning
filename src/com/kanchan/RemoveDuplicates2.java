package com.kanchan;

public class RemoveDuplicates2 {
	public static int removeDuplicates(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int k = 1; // Initialize the length of the unique array
		int count = 1; // Initialize the count of the current element

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				count++;
			}

			// If count is less than or equal to 2, we can include this element
			if (count <= 2) {
				nums[k] = nums[i];
				k++;
			}
		}
		return k;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 1, 2, 2, 3 };
		int k = removeDuplicates(nums);

		// Print the modified array and k
		System.out.println("k = " + k);
		for (int i = 0; i < k; i++) {
			System.out.print(nums[i] + " ");
		}
		// Expected output: k = 2, nums = [2, 2]
	}
}
