package com.kanchan;

public class ValidPalindrome {
	public boolean isPalindrome(String s) {
        // Use StringBuilder to build the cleaned string
        StringBuilder cleaned = new StringBuilder();
        
        // Convert the string to lowercase and remove non-alphanumeric characters
        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                cleaned.append(Character.toLowerCase(c));
            }
        }
        
        // Convert StringBuilder to String
        String cleanedStr = cleaned.toString();
        
        // Check if the cleaned string is a palindrome
        int left = 0, right = cleanedStr.length() - 1;
        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }

    public static void main(String[] args) {
    	ValidPalindrome solution = new ValidPalindrome();
        
        String s1 = "A man, a plan, a canal: Panama";
        System.out.println(solution.isPalindrome(s1)); // Expected: true
        
        String s2 = "race a car";
        System.out.println(solution.isPalindrome(s2)); // Expected: false
        
        String s3 = " ";
        System.out.println(solution.isPalindrome(s3)); // Expected: true
    }
}
