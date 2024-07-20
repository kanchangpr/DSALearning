package com.kanchan;

import java.util.HashMap;

public class CanConstruct {
	// Main method to test the function
    public static void main(String[] args) {
    	CanConstruct solution = new CanConstruct();
        
        // Example inputs
        String ransomNote1 = "a";
        String magazine1 = "b";
        
        String ransomNote2 = "aa";
        String magazine2 = "ab";
        
        String ransomNote3 = "aa";
        String magazine3 = "aab";
        
        // Output results
        System.out.println("Result: " + solution.canConstruct(ransomNote1, magazine1)); // Expected: false
        System.out.println("Result: " + solution.canConstruct(ransomNote2, magazine2)); // Expected: false
        System.out.println("Result: " + solution.canConstruct(ransomNote3, magazine3)); // Expected: true
    }
    
    // Function to check if ransomNote can be constructed from magazine
    public boolean canConstruct1(String ransomNote, String magazine) {
        // Convert magazine string to character array for easier manipulation
    	if (ransomNote.length() > magazine.length()) {
            return false;
        }
    	HashMap<Character, Integer> mMap = new HashMap<>();
        // Loop through ransomNote characters
        for (char m : magazine.toCharArray()) {
          mMap.put(m, mMap.getOrDefault(m,0)+1);
        }
        // Check if ransomNote can be constructed
        for (char c : ransomNote.toCharArray()) {
            if (mMap.containsKey(c)) {
                int count = mMap.get(c);
                if (count > 0) {
                    mMap.put(c, count - 1); // Decrement count
                } else {
                    return false; // Not enough characters available
                }
            } else {
                return false; // Character not found in magazine
            }
        }
        return true;
    }
    
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char c : ransomNote.toCharArray()) {
            int i = magazine.indexOf(c, alphabet[c % 26]);
            if (i == -1) return false;
            alphabet[c % 26] = i + 1;
        }
        return true;
    }
}
