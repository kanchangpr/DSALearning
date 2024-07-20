package com.kanchan;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

	public boolean isAnagram(String s, String t) {
		if (s.length() != t.length()) {
            return false;
        }
        
        // Create a map to count occurrences of characters
        Map<Character, Integer> charCount = new HashMap<>();
        
        // Fill the map with counts from both strings and check simultaneously
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            
            // Increment count for charS
            charCount.put(charS, charCount.getOrDefault(charS, 0) + 1);
            
            // Decrement count for charT
            charCount.put(charT, charCount.getOrDefault(charT, 0) - 1);
            
            // Early termination if counts are not balanced
            if (charCount.get(charS) < 0 || charCount.get(charT) > 0) {
                return false;
            }
        }
        
        return true;
	}

	public static void main(String[] args) {
		IsAnagram solution = new IsAnagram();
		System.out.println(solution.isAnagram("anagram", "nagaram")); // Output: true
		System.out.println(solution.isAnagram("rat", "car")); // Output: false
	}
}
