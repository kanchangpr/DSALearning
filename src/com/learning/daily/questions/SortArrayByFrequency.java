package com.learning.daily.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortArrayByFrequency {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2, 2, 2, 3 };
		int[] res = sortArrayByFrequency(arr);
		for (int i : res) {
			System.out.println(i);
		}
	}

	private static int[] sortArrayByFrequency(int[] nums) {
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : nums) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}

		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(freqMap.entrySet());
		Collections.sort(entryList, (a, b) -> {
			if (a.getValue() != b.getValue()) {
				return a.getValue() - b.getValue(); // Sort by frequency ascending
			} else {
				return b.getKey() - a.getKey(); // Sort by value descending if frequencies are same
			}
		});

		int[] result = new int[nums.length];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : entryList) {
			int key = entry.getKey();
			int freq = entry.getValue();
			for (int i = 0; i < freq; i++) {
				result[index++] = key;
			}
		}

		return result;
	}

}
