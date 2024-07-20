package com.learning.recursion;

import java.util.ArrayList;
import java.util.List;

public class TargetSumeDice {

	public static void main(String[] args) {
		//int[] dice = { 1, 2, 3, 4, 5, 6 };
		int target = 4;
		System.out.println(targetSumeDice("", target));
	}

	private static List<List<String>> targetSumeDice(String p, int target) {
		// TODO Auto-generated method stub
		if (target == 0) {
			List<List<String>> res = new ArrayList<List<String>>();
			List<String> inner = new ArrayList<String>();
			inner.add(p);
			res.add(inner);
			return res;
		}
		List<List<String>> res = new ArrayList<List<String>>();
		for (int i = 1; i <= 6 && i <= target; i++) {

			res.addAll(targetSumeDice(p + i, target - i));
		}
		return res;
	}

}
