package com.learning.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueExample {
	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		q.add(3);
		q.offer(4);
		
		System.out.println(q);
		
		q.poll();
		q.add(5);
		
		System.out.println(q);
		
		
		Stack<Integer> s = new Stack<>();
		s.add(4);
		s.push(5);
		s.add(7);
		s.push(8);
		
		System.out.println(s);
		
				
	}
}
