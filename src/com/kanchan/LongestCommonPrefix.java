package com.kanchan;

public class LongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		// If the input array is empty, return an empty string
		if (strs == null || strs.length == 0) {
			return "";
		}

		// Start with the first string in the array as the prefix
		String prefix = strs[0];

		// Iterate over the rest of the strings
		for (int i = 1; i < strs.length; i++) {
			// Compare the current prefix with each string
			while (strs[i].indexOf(prefix) != 0) {
				System.out.println(strs[i].indexOf(prefix));
				// Reduce the prefix length by one character from the end
				prefix = prefix.substring(0, prefix.length() - 1);

				// If the prefix becomes empty, there is no common prefix
				if (prefix.isEmpty()) {
					return "";
				}
			}
		}

		return prefix;
	}

	public static void main(String[] args) {
		LongestCommonPrefix solution = new LongestCommonPrefix();

		// Example inputs
		String[] input1 = { "flower", "qwe", "rew" };
		String[] input2 = { "dog", "racecar", "car" };
		String[] input3 = { "interview", "interval", "integrate", "intelligence" };

		// Output results
		System.out.println("Longest Common Prefix: " + solution.longestCommonPrefix(input1)); // Expected: "fl"
		System.out.println("Longest Common Prefix: " + solution.longestCommonPrefix(input2)); // Expected: ""
		System.out.println("Longest Common Prefix: " + solution.longestCommonPrefix(input3)); // Expected: "inte"
	}
}
