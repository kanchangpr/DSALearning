package com.learning.recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class CountingPath2dMatrixAllWays {
	public static void main(String[] args) {
		boolean[][] board = { 
	            { true, true, false }, 
	            { true, true, true }, 
	            { false, true, true } 
	        };
		int[][] path = new int[board.length][board[0].length];
		//System.out.println(countingPath2dMatrixAllWays("", board, 0, 0));
		//path2dMatrixAllWays("", board, 0, 0);
		allPathPrint("", board, 0, 0, path, 1);
	}
	
	public static void path2dMatrixAllWays(String p, boolean[][] maze, int r, int c) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			System.out.println(p);
			return;
		}
		if (!maze[r][c]) {
			return;
		}
		maze[r][c] = false;
		if (r < maze.length - 1 && c < maze.length - 1) {
			path2dMatrixAllWays(p + "V", maze, r + 1, c + 1);
			
		}
		if (r < maze.length - 1) {
			path2dMatrixAllWays(p + "D", maze, r + 1, c);
		}
		if (c < maze.length - 1) {
			path2dMatrixAllWays(p + "R", maze, r, c + 1);
		}
		if (r > 0) {
			path2dMatrixAllWays(p + "U", maze, r - 1, c);
		}
		if (c > 0) {
			path2dMatrixAllWays(p + "L", maze, r, c - 1);
		}
		maze[r][c] = true;
	}
	
	
	public static ArrayList<String> countingPath2dMatrixAllWays(String p, boolean[][] maze, int r, int c) {
		ArrayList<String> res = new ArrayList<String>();
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			res.add(p);
			return res;
		}
		ArrayList<String> list = new ArrayList<String>();
		if (!maze[r][c]) {
			return res;
		}
		maze[r][c]=false;
		if (r < maze.length - 1 && c < maze.length - 1) {
			list.addAll(countingPath2dMatrixAllWays(p + "V", maze, r + 1, c + 1));
			
		}
		if (r < maze.length - 1) {
			list.addAll(countingPath2dMatrixAllWays(p + "D", maze, r + 1, c));
		}
		if (c < maze.length - 1) {
			list.addAll(countingPath2dMatrixAllWays(p + "R", maze, r, c + 1));
		}
		if (r > 0) {
			list.addAll(countingPath2dMatrixAllWays(p + "U", maze, r - 1, c));
		}
		if (c > 0) {
			list.addAll(countingPath2dMatrixAllWays(p + "L", maze, r, c - 1));
		}
		maze[r][c]=true;
		return list;
	}
	
	public static void allPathPrint(String p, boolean[][] maze, int r, int c, int[][] path ,int step) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			path[r][c] = step;
			for (int[] arr : path) {
				System.out.println(Arrays.toString(arr));
			}
			System.out.println(p);
			System.out.println();
			return;
		}
		if (!maze[r][c]) {
			return;
		}
		maze[r][c] = false;
		path[r][c] = step;
		if (r < maze.length - 1 && c < maze.length - 1) {
			allPathPrint(p + "V", maze, r + 1, c + 1, path, step+1);
			
		}
		if (r < maze.length - 1) {
			allPathPrint(p + "D", maze, r + 1, c, path, step+1);
		}
		if (c < maze.length - 1) {
			allPathPrint(p + "R", maze, r, c + 1, path, step+1);
		}
		if (r > 0) {
			allPathPrint(p + "U", maze, r - 1, c, path, step+1);
		}
		if (c > 0) {
			allPathPrint(p + "L", maze, r, c - 1, path, step+1);
		}
		path[r][c] = 0;
		maze[r][c] = true;
	}
}
