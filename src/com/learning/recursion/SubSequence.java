package com.learning.recursion;

import java.util.ArrayList;

public class SubSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abc";
		subSequence("", str);
		System.out.println(subSequenceReturn("", str));
	}

	private static void subSequence(String p, String up) {
		if (up.length() == 0) {
			System.out.println(p);
			return;
		}
		subSequence(p + up.charAt(0), up.substring(1));
		subSequence(p, up.substring(1));
	}

	private static ArrayList<String> subSequenceReturn(String p, String up) {
		if (up.length() == 0) {
			ArrayList<String> res = new ArrayList<>();
			res.add(p);
			return res;
		}
		ArrayList<String> left = subSequenceReturn(p + up.charAt(0), up.substring(1));
		ArrayList<String> right = subSequenceReturn(p, up.substring(1));

		left.addAll(right);

		return left;
	}

}
