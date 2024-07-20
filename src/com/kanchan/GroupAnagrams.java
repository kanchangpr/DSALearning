package com.kanchan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> map = new HashMap<>();

		for (String str : strs) {
			// Sort the string to use as a key in the map
			char[] charArray = str.toCharArray();
			Arrays.sort(charArray);
			String sortedStr = new String(charArray);

			// Add to the corresponding list in the map
			if (!map.containsKey(sortedStr)) {
				map.put(sortedStr, new ArrayList<>());
			}
			map.get(sortedStr).add(str);
		}

		// Convert map values to list of lists
		List<List<String>> result = new ArrayList<>();
		for (List<String> list : map.values()) {
			result.add(list);
		}

		return result;
	}

	public static void main(String[] args) {
		String[] strs1 = { "eat", "tea", "tan", "ate", "nat", "bat" };
		System.out.println(groupAnagrams(strs1));
		// Output: [["eat","tea","ate"],["tan","nat"],["bat"]]

		String[] strs2 = { "" };
		System.out.println(groupAnagrams(strs2));
		// Output: [[""]]

		String[] strs3 = { "a" };
		System.out.println(groupAnagrams(strs3));
		// Output: [["a"]]
	}
}
