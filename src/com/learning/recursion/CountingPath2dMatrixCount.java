package com.learning.recursion;

import java.util.ArrayList;

public class CountingPath2dMatrixCount {
	public static void main(String[] args) {
		int r = 3;
		int c = 3;
		countingPath2DMatrix("", r, c);
		System.out.println(pathReturn("", r, c));
		System.out.println(pathReturnDiog("", r, c));
		boolean[][] board = { 
	            { true, true, false }, 
	            { true, true, true }, 
	            { true, true, true } 
	        };
		pathDiogRes("", board, 0, 0);
		System.out.println(pathReturnDiogRes("", board, 0, 0));

	}

	public static void countingPath2DMatrix(String p, int r, int c) {
		if (r == 1 && c == 1) {
			System.out.println(p);
			return;
		}
		if (r > 1) {
			countingPath2DMatrix(p + "D", r - 1, c);
		}
		if (c > 1) {
			countingPath2DMatrix(p + "R", r, c - 1);
		}

	}

	public static ArrayList<String> pathReturn(String p, int r, int c) {
		if (r == 1 && c == 1) {
			ArrayList<String> res = new ArrayList<String>();
			res.add(p);
			return res;
		}
		ArrayList<String> res = new ArrayList<String>();
		if (r > 1) {
			res.addAll(pathReturn(p + "D", r - 1, c));
		}
		if (c > 1) {
			res.addAll(pathReturn(p + "R", r, c - 1));
		}
		return res;
	}

	public static ArrayList<String> pathReturnDiog(String p, int r, int c) {
		if (r == 1 && c == 1) {
			ArrayList<String> res = new ArrayList<String>();
			res.add(p);
			return res;
		}
		ArrayList<String> res = new ArrayList<String>();
		if (r > 1 && c > 1) {
			res.addAll(pathReturn(p + "Dd", r - 1, c - 1));
		}
		if (r > 1) {
			res.addAll(pathReturn(p + "D", r - 1, c));
		}
		if (c > 1) {
			res.addAll(pathReturn(p + "R", r, c - 1));
		}
		return res;
	}

	public static void pathDiogRes(String p, boolean[][] maze, int r, int c) {
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			System.out.println(p);
			return;
		}
		if (!maze[r][c]) {
			return;
		}
		if (r < maze.length - 1 && c < maze.length - 1) {
			pathDiogRes(p + "Dd", maze, r + 1, c + 1);
		}
		if (r < maze.length - 1) {
			pathDiogRes(p + "D", maze, r + 1, c);
		}
		if (c < maze.length - 1) {
			pathDiogRes(p + "R", maze, r, c + 1);
		}
	}

	public static ArrayList<String> pathReturnDiogRes(String p, boolean[][] maze, int r, int c) {
		ArrayList<String> res = new ArrayList<String>();
		if (r == maze.length - 1 && c == maze[0].length - 1) {
			res.add(p);
			return res;
		}
		ArrayList<String> list = new ArrayList<String>();
		if (!maze[r][c]) {
			return res;
		}
		if (r < maze.length - 1 && c < maze.length - 1) {
			list.addAll(pathReturnDiogRes(p + "Dd", maze, r + 1, c + 1));
		}
		if (r < maze.length - 1) {
			list.addAll(pathReturnDiogRes(p + "D", maze, r + 1, c));
		}
		if (c < maze.length - 1) {
			list.addAll(pathReturnDiogRes(p + "R", maze, r, c + 1));
		}
		return list;
	}
}
