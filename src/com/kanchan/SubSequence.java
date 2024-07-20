package com.kanchan;

public class SubSequence {
	public boolean subSequence(String s, String t) {
		int index =0, start=0, count =0;
		while(index <s.length()) {
			while(start<t.length()) {
				if(s.charAt(index) == t.charAt(start)) {
					start++;
					index++;
					count++;
					break;
				}else {
					start++;
				}
			}
			index++;
		}
		if(count==s.length()) {
			return true;
		}else 
			return false;
	}

	

	public static void main(String[] args) {
		SubSequence solution = new SubSequence();
		String s = "abc";
		String t = "ahigdc";
		System.out.println(solution.subSequence(s, t)); // Output: 0

	}
}
