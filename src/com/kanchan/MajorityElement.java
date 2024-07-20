package com.kanchan;

public class MajorityElement {
	public int majorityElement(int[] nums) {
		int count = 0;
		Integer candidate = null;

		for (int num : nums) {
			if (count == 0) {
				candidate = num;
			}
			count += (num == candidate) ? 1 : -1;
			if (count > nums.length / 2) {
				return candidate;
			}
		}

		return candidate;
	}

	public static void main(String[] args) {

		int[] nums = { 3, 3, 3, 4, 3, 3, 2, 2, 2 };
		MajorityElement solution = new MajorityElement();
		int majorityElement = solution.majorityElement(nums);
		System.out.println("The majority element is: " + majorityElement);

	}
}
