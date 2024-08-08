package com.learning.questions;

public class ShiftString {

	
	public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
        	return false;
        }
        String str=s+s;
        
        return str.contains(goal);
    }
}
