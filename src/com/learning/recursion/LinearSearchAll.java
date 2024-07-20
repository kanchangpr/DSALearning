package com.learning.recursion;

import java.util.ArrayList;

public class LinearSearchAll {
	public static void main(String[] args) {
		int[] arr = {8,8,8,3 };
		int target = 8;
		ArrayList<Integer> r = new  ArrayList<>();
		linearSearch(arr, 0, target);
		System.out.println(linearSearch2(arr, 0, target, r));
		System.out.println(res);
		System.out.println(r);
		System.out.println("################");
		System.out.println(linearSearch3(arr, 0, target));
	}
	static ArrayList<Integer> res = new  ArrayList<>();
	private static void linearSearch(int[] arr, int ind, int target) {
		if (arr.length==0 || ind > arr.length-1) {
			return;
		}	
		if (arr[ind] == target) {
			res.add(ind);
		}
		linearSearch(arr, ind + 1, target);
		
	}
	
	private static ArrayList<Integer> linearSearch2(int[] arr, int ind, int target, ArrayList<Integer> r) {
		if (arr.length==0 || ind > arr.length-1) {
			return r;
		}	
		if (arr[ind] == target) {
			r.add(ind);
		}
		return linearSearch2(arr, ind + 1, target, r);	
	}
	
	private static ArrayList<Integer> linearSearch3(int[] arr, int ind, int target) {
		ArrayList<Integer> r1 = new  ArrayList<>();
		if (arr.length==0 || ind > arr.length-1) {
			return r1;
		}	
		if (arr[ind] == target) {
			r1.add(ind);
		}
		ArrayList<Integer> finalAns = linearSearch3(arr, ind + 1, target);
		r1.addAll(finalAns);
		return 	r1;
		 
	}
}
