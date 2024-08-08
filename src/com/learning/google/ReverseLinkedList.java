package com.learning.google;

class ListNode {
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
	}
}

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode temp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = temp;
		}
		return prev;
	}

	public class ReverseLinkedListRecursive {
		public ListNode reverseList(ListNode node) {
			if (node == null || node.next == null) {
				return node;
			}
			ListNode prev = reverseList(node.next);
			node.next.next = node;
			node.next = null;
			return prev;
		}
	}

	public static void main(String[] args) {
		// Example usage:
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		ReverseLinkedList solution = new ReverseLinkedList();
		ListNode reversedHead = solution.reverseList(head);

		// Print reversed list
		while (reversedHead != null) {
			System.out.print(reversedHead.val + " ");
			reversedHead = reversedHead.next;
		}
	}
}
