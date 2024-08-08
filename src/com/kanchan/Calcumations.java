package com.kanchan;

import java.util.Arrays;

public class Calcumations {
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

	public String solution() {
		StringBuilder sb = new StringBuilder();

		// Start by appending all 2-digit numbers sequentially to maximize coverage
		for (int i = 0; i < 100; i++) {
			String num = String.format("%02d", i);
			if (sb.length() + num.length() <= 100) {
				sb.append(num);
			} else {
				break;
			}
		}

		// If there's any remaining space, try adding more overlapping substrings
		if (sb.length() < 100) {
			for (int i = 0; i < 100 && sb.length() < 100; i++) {
				String num = String.format("%02d", i);
				sb.append(num.charAt(1)); // Only add the last digit to create overlap
			}
		}

		System.out.println(sb.substring(0, Math.min(100, sb.length())));
		return sb.substring(0, Math.min(100, sb.length()));
	}

	public static void main(String[] args) {
		Calcumations solution = new Calcumations();
		String generatedString = solution.solution(); // This string should contain as many combinations as possible

		int result = solution.calculate(generatedString); // This should return the count
		System.out.println("Result: " + result); // Expected output: Should be greater than 74
	}
}
