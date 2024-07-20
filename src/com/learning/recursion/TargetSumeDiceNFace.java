package com.learning.recursion;

public class TargetSumeDiceNFace {

	public static void main(String[] args) {
		// int[] dice = { 1, 2, 3, 4, 5, 6 };
		int target = 7;
		int n= 2;
		int k=6;
		System.out.println(numRollsToTarget(n, k, target));
	}

	public static int numRollsToTarget(int n, int k, int target) {
		return targetSumeDice(n, k, "", target);
	}

	private static int targetSumeDice(int n, int k, String p, int target) {
		// TODO Auto-generated method stub
		if (target == 0) {
			int count = 0;
			return count + 1;
		}
		int rescount =0;
		for (int i = 1; i <= k && i <= target; i++) {
			rescount+= targetSumeDice(n, k, p + i, target - i);
		}
		return rescount;
	}

}
