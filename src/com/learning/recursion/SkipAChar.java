package com.learning.recursion;

public class SkipAChar {
	public static void main(String[] args) {
		String str = "baccad";
		char c = 'a';
		skipAChar(str, c);
		System.out.println(str);

	}

	private static void skipAChar(String str, char c) {
		StringBuilder res = new StringBuilder();
		skipACharHelper(str, c, 0, res);
		System.out.println(res);

	}

	public static void skipACharHelper(String str, char c, int ind, StringBuilder res) {
		if (str.length() == ind) {
			return;
		}
		if (str.charAt(ind) != c) {
			res.append(str.charAt(ind));
		}
		skipACharHelper(str, c, ind + 1, res);
	}
}
