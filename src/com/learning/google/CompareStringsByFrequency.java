package com.learning.google;

import java.util.Arrays;

public class CompareStringsByFrequency {
	// Helper function to find the frequency of the smallest character
	public static int frequencyOfSmallestChar(String s) {
		char smallestChar = 'z';
		int frequency = 0;

		for (char c : s.toCharArray()) {
			if (c < smallestChar) {
				smallestChar = c;
				frequency = 1;
			} else if (c == smallestChar) {
				frequency++;
			}
		}

		return frequency;
	}

	// Function to compare queries with words based on the frequency of the smallest
	// character
	public static int[] numSmallerByFrequency(String[] queries, String[] words) {
		int[] wordFrequencies = new int[words.length];

		// Calculate frequency of smallest character for each word
		for (int i = 0; i < words.length; i++) {
			wordFrequencies[i] = frequencyOfSmallestChar(words[i]);
		}

		// Sort the frequencies array for easier comparison
		Arrays.sort(wordFrequencies);

		int[] result = new int[queries.length];

		// Calculate the result for each query
		for (int i = 0; i < queries.length; i++) {
			int queryFrequency = frequencyOfSmallestChar(queries[i]);
			result[i] = countGreaterFrequencies(wordFrequencies, queryFrequency);
		}

		return result;
	}

	// Helper function to count how many elements in the sorted array are greater
	// than the target frequency
	public static int countGreaterFrequencies(int[] frequencies, int targetFrequency) {
		int count = 0;
		for (int frequency : frequencies) {
			if (frequency > targetFrequency) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		String[] queries = { "aabb", "abcd" };
		String[] words = { "a", "aa", "aaa", "aaaa" };

		int[] result = numSmallerByFrequency(queries, words);

		System.out.println(Arrays.toString(result)); // Output: [1]
	}
}
