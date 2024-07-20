package com.kanchan;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
		int left = 0;
		int right = height.length - 1;
		int maxArea = 0;

		while (left < right) {
			// Calculate the area with the current left and right pointers
			int width = right - left;
			int minHeight = Math.min(height[left], height[right]);
			int currentArea = width * minHeight;

			// Update maxArea if the current area is larger
			maxArea = Math.max(maxArea, currentArea);

			// Move the pointer pointing to the shorter line inward
			if (height[left] < height[right]) {
				left++;
			} else {
				right--;
			}
		}

		return maxArea;
	}

	public static void main(String[] args) {
		int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(height1)); // Output: 49

		int[] height2 = { 1, 1 };
		System.out.println(maxArea(height2)); // Output: 1
	}
}
