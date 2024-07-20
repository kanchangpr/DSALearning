package com.kanchan;

public class LengthOfLastWord {
	// Method to determine the length of the last word
	public int lengthOfLastWord(String s) {
		// Logic to be implemented
		int length = 0;
        int n = s.length();
        boolean isWord = false;
		for (int i = n - 1; i >= 0; i--) {
			char ch = s.charAt(i);
            if (ch == ' ') {
                // If we encounter a space after finding a word, break
                if (isWord) {
                    break;
                }
            } else {
                // If we encounter a non-space character, increment length
                length++;
                isWord = true;
            }
		}
		return length;
	}

	public static void main(String[] args) {
		// Create an instance of the Solution class
		LengthOfLastWord solution = new LengthOfLastWord();

		// Example inputs
		String input1 = "Hello World";
		String input2 = "   fly me   to   the moon  ";
		String input3 = "luffy is still joyboy";
		String input4 = " ";

		// Output results
		System.out.println("Input: \"" + input1 + "\" | Length of last word: " + solution.lengthOfLastWord(input1)); // Expected:
																														// 5
		System.out.println("Input: \"" + input2 + "\" | Length of last word: " + solution.lengthOfLastWord(input2)); // Expected:
																														// 4
		System.out.println("Input: \"" + input3 + "\" | Length of last word: " + solution.lengthOfLastWord(input3)); // Expected:
																														// 6
		System.out.println("Input: \"" + input4 + "\" | Length of last word: " + solution.lengthOfLastWord(input4)); // Expected:
																														// 0
	}
}
