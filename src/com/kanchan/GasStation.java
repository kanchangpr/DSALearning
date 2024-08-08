package com.kanchan;

import java.util.Arrays;

public class GasStation {
	public static int canCompleteCircuit(int[] gas, int[] cost) {
		int total_tank = 0;
		int current_tank = 0;
		int starting_station = 0;

		for (int i = 0; i < gas.length; i++) {
			total_tank += gas[i] - cost[i];
			current_tank += gas[i] - cost[i];

			// If we cannot reach the next station
			if (current_tank < 0) {
				// Start from the next station
				starting_station = i + 1;
				// Reset current tank
				current_tank = 0;
			}
		}

		// If the total amount of gas is greater than or equal to the total cost, return
		// starting_station
		// Otherwise, return -1
		return total_tank >= 0 ? starting_station : -1;
	}

	public String solution() {
		StringBuilder sb = new StringBuilder();

		// Add all two-digit numbers (from 00 to 99) to the string
		for (int i = 0; i < 99; i++) {
			if (sb.length() < 100) {
				// Add the two-digit number in string form
				sb.append(String.format("%02d", i));
			} else {
				break;
			}
		}

		// Return the first 100 characters (if needed)
		return sb.substring(0, Math.min(100, sb.length()));
	}

	private int calculate(String S) {
		int length = S.length();
		if (length > 100) {
			return 0;
		}
		int[] count = new int[100];
		for (int i = 0; i < length - 1; i++) {
			int num = Integer.parseInt(S.substring(i, i + 2));
			count[num] = 1;
		}
		return Arrays.stream(count).sum();
	}
	
	public static void main(String[] args) {
//		int[] gas1 = { 1, 2, 3, 4, 5 };
//		int[] cost1 = { 3, 4, 5, 1, 2 };
//		System.out.println(canCompleteCircuit(gas1, cost1)); // Output: 3
//
//		int[] gas2 = { 2, 3, 4 };
//		int[] cost2 = { 3, 4, 3 };
//		System.out.println(canCompleteCircuit(gas2, cost2)); // Output: -1
		GasStation sol = new GasStation();
		 String generatedString = sol.solution();
	        System.out.println("Generated String: " + generatedString);
	        
	        // Calculate the score using the calculate method
	        int score = sol.calculate(generatedString);
	        System.out.println("Score: " +score);
	}
}
