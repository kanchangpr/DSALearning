package com.kanchan;

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

	public static void main(String[] args) {
		int[] gas1 = { 1, 2, 3, 4, 5 };
		int[] cost1 = { 3, 4, 5, 1, 2 };
		System.out.println(canCompleteCircuit(gas1, cost1)); // Output: 3

		int[] gas2 = { 2, 3, 4 };
		int[] cost2 = { 3, 4, 3 };
		System.out.println(canCompleteCircuit(gas2, cost2)); // Output: -1
	}
}
