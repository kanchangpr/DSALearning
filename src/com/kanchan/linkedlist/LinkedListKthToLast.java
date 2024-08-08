package com.kanchan.linkedlist;

public class LinkedListKthToLast {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode findKthToLast(ListNode head, int k) {
		ListNode first = head;
		ListNode second = head;

		for (int i = 0; i < k; i++) {
			if (first == null)
				return null;
			first = first.next;
		}

		while (first != null) {
			first = first.next;
			second = second.next;
		}

		return second;
	}

	public static void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);

		System.out.println("Original List:");
		printList(head);

		ListNode kthToLast = findKthToLast(head, 2);

		System.out.println("2nd to Last Element: " + (kthToLast != null ? kthToLast.val : "None"));
	}
}
