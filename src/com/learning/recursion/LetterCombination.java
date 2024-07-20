package com.learning.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombination {

	public static void main(String[] args) {
		String str = "23";
		System.out.println(letterCombinations(str));
	}

	public static HashMap<Character, String> numberMap = new HashMap<>();

	public static List<String> letterCombinations(String digits) {
		numberMap.put('2', "abc");
		numberMap.put('3', "def");
		numberMap.put('4', "ghi");
		numberMap.put('5', "jkl");
		numberMap.put('6', "mno");
		numberMap.put('7', "pqrs");
		numberMap.put('8', "tuv");
		numberMap.put('9', "wxyz");
		if(digits.isBlank()) {
			return new ArrayList<>();
		}
		return letterCombinations("", digits);
	}

	private static List<String> letterCombinations(String p, String un) {
		if (un.length() == 0) {
			ArrayList<String> res = new ArrayList<>();
			res.add(p);
			return res;
		}
		List<String> innerRes = new ArrayList<>();
		String chars = numberMap.get(un.charAt(0));
		for (Character c : chars.toCharArray()) {
			innerRes.addAll(letterCombinations(p + c.toString(), un.substring(1)));
		}
		return innerRes;
	}
}
