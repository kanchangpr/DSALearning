package com.learning.google;

/**
 * Solution for Valid Palindrome problem.
 * 
 * Given a string `s`, this program determines if it is a palindrome,
 * considering only alphanumeric characters and ignoring cases.
 * 
 * Example: Input: s = "A man, a plan, a canal: Panama" Output: true
 * Explanation: "amanaplanacanalpanama" is a palindrome.
 * 
 * Difficulty: Easy Tags: String, Two Pointers
 * 
 * Time Complexity: O(n) Space Complexity: O(1) Where n is the length of the
 * input string.
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;

		while (left < right) {
			while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
				left++;
			}
			while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
				right--;
			}

			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
				return false;
			}

			left++;
			right--;
		}

		return true;
	}

	public static void main(String[] args) {
		ValidPalindrome solution = new ValidPalindrome();
		String s = "A man, a plan, a canal: Panama";
		System.out.println(solution.isPalindrome(s)); // Output: true
	}
}
