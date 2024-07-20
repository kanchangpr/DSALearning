package com.kanchan;

public class ReverseWords {
	public static String reverseWords(String s) {
		// Trim the input string to remove leading and trailing spaces
		s = s.trim();

		// Split the string by one or more spaces
		String[] words = s.split("\\s+");

		// Use a StringBuilder to efficiently construct the result
		StringBuilder reversed = new StringBuilder();

		// Loop through the words array from end to start
		for (int i = words.length - 1; i >= 0; i--) {
			reversed.append(words[i]);
			if (i != 0) {
				reversed.append(" ");
			}
		}

		return reversed.toString();
	}

	public static void main(String[] args) {
		String s1 = "the sky is blue";
		System.out.println(reverseWords(s1)); // Output: "blue is sky the"

		String s2 = "  hello world  ";
		System.out.println(reverseWords(s2)); // Output: "world hello"

		String s3 = "a good   example";
		System.out.println(reverseWords(s3)); // Output: "example good a"
	}
}
