package com.kanchan.stack;

import java.util.Stack;

public class BalancedParentheses {
	public static void main(String[] args) {
		String expression = "())(";
		System.out.println(isBalanced(expression)); // Output: true
	}

	private static boolean isBalanced(String expression) {
		Stack<Character> stack = new Stack<>();
		for (char ch : expression.toCharArray()) {
			if (ch == '(') {
				stack.push(ch);
			} else if (ch == ')') {
				if (stack.isEmpty()) {
					return false;
				}
				stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
