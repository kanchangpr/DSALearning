package com.learning.recursion;

public class Permutation {

	public static void main(String[] args) {
		String str = "abc";
		System.out.println(str.substring(0));
		permutation("", str);
	}

	static void permutation(String p, String un) {
		if (un.length() == 0) {
			System.out.println(p);
			return;
		}
		char ch = un.charAt(0);
		for (int i = 0; i <= p.length(); i++) {
			String f = p.substring(0, i);
			String s = p.substring(i);
			permutation(f + ch + s, un.substring(1));
		}

	}
}
