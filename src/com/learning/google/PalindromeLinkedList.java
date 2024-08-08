package com.learning.google;

import java.util.Stack;

/**
 * Solution for Palindrome Linked List problem.
 * 
 * Given the head of a singly linked list, this program determines if it is a
 * palindrome.
 * 
 * Example: Input: head = [1,2,2,1] Output: true
 * 
 * Difficulty: Easy Tags: Linked List, Two Pointers, Stack
 * 
 * Time Complexity: O(n) Space Complexity: O(n) Where n is the number of nodes
 * in the linked list.
 */
public class PalindromeLinkedList {
	static class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public boolean isPalindrome(ListNode head) {
		Stack<Integer> stack = new Stack<>();
		ListNode current = head;

		while (current != null) {
			stack.push(current.val);
			current = current.next;
		}

		current = head;
		while (current != null) {
			if (current.val != stack.pop()) {
				return false;
			}
			current = current.next;
		}

		return true;
	}

	public static void main(String[] args) {
		PalindromeLinkedList solution = new PalindromeLinkedList();
		ListNode node4 = new ListNode(1);
		ListNode node3 = new ListNode(3, node4);
		ListNode node2 = new ListNode(2, node3);
		ListNode node1 = new ListNode(1, node2);
		System.out.println(solution.isPalindrome(node1)); // Output: true
	}
}
