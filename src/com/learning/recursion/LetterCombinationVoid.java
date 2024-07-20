package com.learning.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationVoid {

	public static void main(String[] args) {
		String str = "23";
		System.out.println(letterCombinationsVoid(str));
	}

	public static HashMap<Character, String> numberMap = new HashMap<>();
	public static List<String> res = new ArrayList<>();

	public static List<String> letterCombinationsVoid(String digits) {
		numberMap.put('2', "abc");
		numberMap.put('3', "def");
		numberMap.put('4', "ghi");
		numberMap.put('5', "jkl");
		numberMap.put('6', "mno");
		numberMap.put('7', "pqrs");
		numberMap.put('8', "tuv");
		numberMap.put('9', "wxyz");
		letterCombinationsVoid("", digits);
		return res;
	}

	private static void letterCombinationsVoid(String p, String un) {
		if (un.isBlank()) {
			res.add(p);
			return;
		}
		String chars = numberMap.get(un.charAt(0));
		for (Character c : chars.toCharArray()) {
			letterCombinationsVoid(p + c.toString(), un.substring(1));
		}
	}
}
