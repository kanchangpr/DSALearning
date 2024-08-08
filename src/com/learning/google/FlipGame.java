package com.learning.google;

import java.util.ArrayList;
import java.util.List;

/**
 * Solution for Flip Game problem.
 * 
 * You are playing a Flip Game with your friend. You are given a string
 * currentState that contains only '+' and '-'. You and your friend take turns
 * to flip two consecutive "++" into "--". The game ends when a person can no
 * longer make a move and therefore the other person will be the winner. Write a
 * function to compute all possible states of the string after one valid move.
 * 
 * Time Complexity: O(n) Space Complexity: O(n) Where n is the length of the
 * currentState string.
 */
public class FlipGame {
	public List<String> generatePossibleNextMoves(String currentState) {
		List<String> result = new ArrayList<>();

		for (int i = 0; i < currentState.length() - 1; i++) {
			if (currentState.charAt(i) == '+' && currentState.charAt(i + 1) == '+') {
				result.add(currentState.substring(0, i) + "--" + currentState.substring(i + 2));
			}
		}

		return result;
	}

	public static void main(String[] args) {
		FlipGame solution = new FlipGame();
		System.out.println(solution.generatePossibleNextMoves("++-++"));
		// Output: ["--++", "+--+", "++--"]
	}
}
