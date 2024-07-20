package com.kanchan;

public class ProductExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
		int n = nums.length;
		int[] answer = new int[n];

		// Initialize the answer array with 1s
		for (int i = 0; i < n; i++) {
			answer[i] = 1;
		}

		// Calculate prefix products
		int prefix = 1;
		for (int i = 0; i < n; i++) {
			answer[i] = prefix;
			prefix *= nums[i];
		}

		// Calculate suffix products
		int suffix = 1;
		for (int i = n - 1; i >= 0; i--) {
			answer[i] *= suffix;
			suffix *= nums[i];
		}

		return answer;
	}

	public static void main(String[] args) {
		int[] nums1 = { 1, 2, 3, 4 };
		int[] result1 = productExceptSelf(nums1);
		for (int num : result1) {
			System.out.print(num + " "); // Output: 24 12 8 6
		}
		System.out.println();

		int[] nums2 = { -1, 1, 0, -3, 3 };
		int[] result2 = productExceptSelf(nums2);
		for (int num : result2) {
			System.out.print(num + " "); // Output: 0 0 9 0 0
		}
	}
}
