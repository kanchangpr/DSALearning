package com.kanchan;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
			return false;
		}

		// Create a map to count occurrences of characters
		Map<Character, Integer> charCount = new HashMap<>();

		// Fill the map with counts from both strings and check simultaneously
		for (int i = 0; i < s.length(); i++) {
			char charS = s.charAt(i);
			char charT = t.charAt(i);

			// Increment count for charS
			charCount.put(charS, charCount.getOrDefault(charS, 0) + 1);

			// Decrement count for charT
			charCount.put(charT, charCount.getOrDefault(charT, 0) - 1);

			// Early termination if counts are not balanced
			if (charCount.get(charS) < 0 || charCount.get(charT) > 0) {
				return false;
			}
		}

		return true;
	}


	static int ball(String buckets) {
		int n = buckets.length();

		// Patterns
		char[] pattern1 = new char[n];
		char[] pattern2 = new char[n];
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				pattern1[i] = 'B';
				pattern2[i] = '.';
			} else {
				pattern1[i] = '.';
				pattern2[i] = 'B';
			}
		}
		int movesForPattern1 = 0;
		int movesForPattern2 = 0;

		for (int i = 0; i < n; i++) {
			if (buckets.charAt(i) != pattern1[i]) {
				movesForPattern1++;
			}
			if (buckets.charAt(i) != pattern2[i]) {
				movesForPattern2++;
			}
		}
		return Math.min(movesForPattern1, movesForPattern2);
	}


    public static int minMoves(String buckets) {
        int bCount = 0;
        int n = buckets.length();

        // Step 1: Count the number of balls ('B')
        for (int i = 0; i < n; i++) {
            if (buckets.charAt(i) == 'B') {
            	bCount++;
            }
        }

        // Step 2: Determine if it is impossible to achieve the alternating pattern
        int invalidBound = (n % 2 == 1) ? n / 2 + 1 : n / 2;
        if (bCount > invalidBound) {
            return -1;
        }

        int startIndex = 0;
        int endIndex = 2 * bCount - 2;
        int minShiftsVal = bCount; // Initialize with maximum possible shifts

        // Step 3: Sliding window to find the minimum shifts
        while (endIndex < n) {
            int ballCorrectPos = 0;

            // Count the number of balls in the correct positions within the current window
            for (int i = startIndex; i <= endIndex; i += 2) {
                if (buckets.charAt(i) == 'B') {
                    ballCorrectPos++;
                }
            }

            // Calculate the number of shifts needed and update the minimum shifts
            int shiftsNeeded = bCount - ballCorrectPos;
            minShiftsVal = Math.min(minShiftsVal, shiftsNeeded);

            // Move the window to the right
            startIndex++;
            endIndex++;
        }

        return minShiftsVal;

    	
    }

	
	
	public static void main(String[] args) {
		 // Test cases
        System.out.println(minMoves("BB.B.BBB...")); // Output: 4
        System.out.println(minMoves("..B....B.BB")); // Output: 2
        System.out.println(minMoves("B.B.B.B.B."));  // Output: 0
        System.out.println(minMoves("BBB"));         // Output: 2
        System.out.println(minMoves("B.B.BB"));      // Output: 1

			}
}
