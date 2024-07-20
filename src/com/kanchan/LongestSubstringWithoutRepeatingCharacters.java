package com.kanchan;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
	public static int lengthOfLongestSubstring(String s) {
		int n = s.length();
		int maxLength = 0;
		int left = 0;
		Map<Character, Integer> map = new HashMap<>();

		for (int right = 0; right < n; right++) {
			char currentChar = s.charAt(right);

			if (map.containsKey(currentChar)) {
				left = Math.max(map.get(currentChar) + 1, left);
			}

			map.put(currentChar, right);
			maxLength = Math.max(maxLength, right - left + 1);
		}

		return maxLength;
	}

	public static void main(String[] args) {
		String s1 = "abcabcbb";
		System.out.println(lengthOfLongestSubstring(s1)); // Output: 3

		String s2 = "bbbbb";
		System.out.println(lengthOfLongestSubstring(s2)); // Output: 1

		String s3 = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s3)); // Output: 3

		String s4 = "";
		System.out.println(lengthOfLongestSubstring(s4)); // Output: 0
	}
}
