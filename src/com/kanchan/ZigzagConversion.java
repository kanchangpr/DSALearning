package com.kanchan;

public class ZigzagConversion {
	public static String convert(String s, int numRows) {
		// Base case: If numRows is 1, return the string as is
		if (numRows == 1) {
			return s;
		}

		// Create an array of StringBuilder objects for each row
		StringBuilder[] rows = new StringBuilder[numRows];
		for (int i = 0; i < numRows; i++) {
			rows[i] = new StringBuilder();
		}

		// Variables to track the current row and the direction of movement
		int currentRow = 0;
		boolean goingDown = false;

		// Traverse the input string
		for (char c : s.toCharArray()) {
			// Append the current character to the appropriate row
			rows[currentRow].append(c);

			// Change direction when we reach the top or bottom row
			if (currentRow == 0 || currentRow == numRows - 1) {
				goingDown = !goingDown;
			}

			// Move to the next row
			currentRow += goingDown ? 1 : -1;
		}

		// Concatenate all rows to form the final string
		StringBuilder result = new StringBuilder();
		for (StringBuilder row : rows) {
			result.append(row);
		}

		return result.toString();
	}

	public static void main(String[] args) {
		String s1 = "PAYPALISHIRING";
		int numRows1 = 3;
		System.out.println(convert(s1, numRows1)); // Output: "PAHNAPLSIIGYIR"

		String s2 = "PAYPALISHIRING";
		int numRows2 = 4;
		System.out.println(convert(s2, numRows2)); // Output: "PINALSIGYAHRPI"

		String s3 = "A";
		int numRows3 = 1;
		System.out.println(convert(s3, numRows3)); // Output: "A"
	}
}
