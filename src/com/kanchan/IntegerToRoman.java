package com.kanchan;

public class IntegerToRoman {
	public static String intToRoman(int num) {
		// Define the basic Roman numeral symbols and their values
		int[] values = { 1000, 500, 100, 50, 10, 5, 1 };
		String[] symbols = { "M", "D", "C", "L", "X", "V", "I" };

		StringBuilder roman = new StringBuilder();

		// Iterate over the values and symbols
		for (int i = 0; i < values.length; i++) {
			// Determine how many times the current value fits into num
			int count = num / values[i];
			// Append the symbol count times to the result
			for (int j = 0; j < count; j++) {
				roman.append(symbols[i]);
			}
			// Subtract the corresponding amount from num
			num -= count * values[i];

			// Handle subtractive forms for 4 and 9
			if (i % 2 == 0 && i < values.length - 2) {
				// Check for the subtractive form of the next value
				if (num >= values[i] - values[i + 2]) {
					roman.append(symbols[i + 2]).append(symbols[i]);
					num -= values[i] - values[i + 2];
				}
			} else if (i % 2 == 1 && i < values.length - 1) {
				// Check for the subtractive form of the next value
				if (num >= values[i] - values[i + 1]) {
					roman.append(symbols[i + 1]).append(symbols[i]);
					num -= values[i] - values[i + 1];
				}
			}
		}

		return roman.toString();
	}

	public static void main(String[] args) {
		// Test cases
		System.out.println(intToRoman(3749)); // Output: "MMMDCCXLIX"
		System.out.println(intToRoman(58)); // Output: "LVIII"
		System.out.println(intToRoman(1994)); // Output: "MCMXCIV"
	}
}
