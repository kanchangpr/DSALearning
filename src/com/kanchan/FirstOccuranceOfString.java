package com.kanchan;

public class FirstOccuranceOfString {
	public int firstOccuranceOfString1(String haystack, String needle) {
		// Return 0 if needle is an empty string
		if (needle.isEmpty()) {
			return 0;
		}
		// Use indexOf to find the first occurrence of needle in haystack
		return haystack.indexOf(needle);
	}

	public int firstOccuranceOfString(String haystack, String needle) {
		if (haystack.length() < needle.length()) {
			return -1;
		}
		for (int i = 0; i <= haystack.length() - needle.length(); i++) {
			if (haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		FirstOccuranceOfString solution = new FirstOccuranceOfString();
		String haystack1 = "hsadbutsad";
		String needle1 = "sad";
		System.out.println(solution.firstOccuranceOfString(haystack1, needle1)); // Output: 0

		String haystack2 = "leetcode";
		String needle2 = "lrr";
		System.out.println(solution.firstOccuranceOfString(haystack2, needle2)); // Output: -1
	}
}
