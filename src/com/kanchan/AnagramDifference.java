package com.kanchan;

public class AnagramDifference {

	public char anagramDifference(String s, String t) {
		int[] charCount = new int[26]; // Assuming lowercase English letters

		// Count occurrences of each character in s
		for (char ch : s.toCharArray()) {
			charCount[ch - 'a']++;
		}

		// Adjust counts for t
		for (char ch : t.toCharArray()) {
			charCount[ch - 'a']--;
		}

		// Find the added character
		char addedChar = ' ';
		for (int i = 0; i < 26; i++) {
			if (charCount[i] == -1) {
				addedChar = (char) (i + 'a');
				break;
			}
		}

		return addedChar;
	}

	public static void main(String[] args) {
		AnagramDifference solution = new AnagramDifference();
		System.out.println(solution.anagramDifference("abcd", "abcde")); // Output: true
		System.out.println(solution.anagramDifference("", "y")); // Output: false
	}
}
