package com.learning.google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class WordCountEngine {
	public static void main(String[] args) {
		String str = "Practice makes perfect. you'll only get Perfect by practice. just practice!";
		String[][] res = wordCountEngine(str);
		for (String[] pair : res) {
			System.out.println(pair[0] + ": " + pair[1]);
		}
	}

	static String[][] wordCountEngine(String document) {
		// Step 1: Normalize the document by converting to lowercase and removing
		// punctuation
		String normalizedDoc = document.toLowerCase().replaceAll("[^a-z ]", "");

		// Step 2: Tokenize the document into words
		String[] words = normalizedDoc.split("\\s+");

		// Step 3: Count word frequencies and maintain order of first appearances
		Map<String, Integer> wordCount = new HashMap<>();
		Map<String, Integer> orderOfAppearance = new LinkedHashMap<>();
		int order = 0;

		for (String word : words) {
			if (word.length() > 0) {
				wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
				if (!orderOfAppearance.containsKey(word)) {
					orderOfAppearance.put(word, order++);
				}
			}
		}

		// Step 4: Create a list of word entries and sort by frequency and order of
		// appearance
		List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordCount.entrySet());
		wordList.sort((a, b) -> {
			int freqCompare = b.getValue().compareTo(a.getValue());
			if (freqCompare == 0) {
				return orderOfAppearance.get(a.getKey()) - orderOfAppearance.get(b.getKey());
			}
			return freqCompare;
		});

		// Step 5: Convert the sorted list to the required output format
		String[][] result = new String[wordList.size()][2];
		for (int i = 0; i < wordList.size(); i++) {
			result[i][0] = wordList.get(i).getKey();
			result[i][1] = Integer.toString(wordList.get(i).getValue());
		}

		return result;
	}
}
