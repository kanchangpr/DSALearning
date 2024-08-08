package com.kanchan.stack;

import java.util.Stack;

public class ReverseString {
	public static void main(String[] args) {
		String str = "Hello kanchan";
		System.out.println(reverse(str)); // Output: "olleH"
	}

	private static String reverse(String str) {
		Stack<Character> charStack = new Stack<>();
		for (char ch : str.toCharArray()) {
			charStack.push(ch);
		}
		StringBuilder res = new StringBuilder();
		while (!charStack.isEmpty()) {
			res.append(charStack.pop());
		}
		return res.toString();
	}

}
