package com.kanchan;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
	public List<Integer> majorityElement2(int[] nums) {
		int count1 = 0, count2 = 0;
		Integer candidate1 = null, candidate2 = null;

		for (int num : nums) {
			if (candidate1 != null && num == candidate1.intValue()) {
				count1++;
			} else if (candidate2 != null && num == candidate2.intValue()) {
				count2++;
			} else if (count1 == 0) {
				candidate1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		// Verification
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == candidate1)
				count1++;
			else if (num == candidate2)
				count2++;
		}

		List<Integer> result = new ArrayList<>();
		if (count1 > nums.length / 3)
			result.add(candidate1);
		if (count2 > nums.length / 3)
			result.add(candidate2);

		return result;
	}

	public static void main(String[] args) {

		int[] nums = { 3, 3, 3, 4, 4, 3, 2, 2, 2 };
		MajorityElement2 solution = new MajorityElement2();
		List<Integer> majorityElement = solution.majorityElement2(nums);
		System.out.println("The majority element is: " + majorityElement);

	}
}
