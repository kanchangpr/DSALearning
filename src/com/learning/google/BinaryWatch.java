package com.learning.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for Binary Watch problem.
 * 
 * A binary watch has 4 LEDs on the top to represent the hours (0-11), and the 6
 * LEDs on the bottom to represent the minutes (0-59). Each LED represents a
 * binary digit. Given a non-negative integer n which represents the number of
 * LEDs that are currently on, return all possible times the watch could
 * represent.
 * 
 * Time Complexity: O(1) - The number of possible times is fixed, 2^10 = 1024.
 * Space Complexity: O(1) - The number of possible times is fixed, 2^10 = 1024.
 */
public class BinaryWatch {
	public List<String> readBinaryWatch(int turnedOn) {
		List<String> times = new ArrayList<>();
		System.out.println(Integer.bitCount(13));
		for (int h = 0; h < 12; h++) {
			for (int m = 0; m < 60; m++) {
				if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
					times.add(String.format("%d:%02d", h, m));
				}
			}
		}

		return times;
	}

	public static void main(String[] args) {
		BinaryWatch solution = new BinaryWatch();
		System.out.println(solution.readBinaryWatch(1));
		// Output:
		// ["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
	}
}
