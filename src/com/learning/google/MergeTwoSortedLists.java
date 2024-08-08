package com.learning.google;

/**
 * Solution for Merge Two Sorted Lists problem.
 * 
 * Given the heads of two sorted linked lists `list1` and `list2`, this program
 * merges the two lists into a single sorted linked list and returns the head of
 * the merged list.
 * 
 * Example: Input: list1 = [1,2,4], list2 = [1,3,4] Output: [1,1,2,3,4,4]
 * 
 * Difficulty: Easy Tags: Linked List, Recursion
 * 
 * Time Complexity: O(n + m) Space Complexity: O(1) Where n is the number of
 * nodes in list1 and m is the number of nodes in list2.
 */
public class MergeTwoSortedLists {
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

	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (list1 != null && list2 != null) {
			if (list1.val <= list2.val) {
				current.next = list1;
				list1 = list1.next;
			} else {
				current.next = list2;
				list2 = list2.next;
			}
			current = current.next;
		}

		if (list1 != null) {
			current.next = list1;
		} else {
			current.next = list2;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		MergeTwoSortedLists solution = new MergeTwoSortedLists();
		ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
		ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
		ListNode result = solution.mergeTwoLists(list1, list2);

		while (result != null) {
			System.out.print(result.val + " ");
			result = result.next;
		}
		// Output: 1 1 2 3 4 4
	}
}
