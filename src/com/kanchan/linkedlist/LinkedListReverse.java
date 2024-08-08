package com.kanchan.linkedlist;

public class LinkedListReverse {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;
		while (curr != null) {
			ListNode next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
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
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);

		System.out.println("Original List:");
		printList(head);

		head = reverseList2(head, 2, 4);

		System.out.println("Reversed List:");
		printList(head);
	}

	public static ListNode reverseList2(ListNode head, int m, int n) {
		if (head == null || head.next == null ||  m >= n) {
			return head;
		}
		ListNode dummy = head; // Dummy node to handle edge cases
//		dummy.next = head;
		ListNode pre = dummy;

		for (int i = 0; i < m; i++) {
			pre = pre.next;
		}

		ListNode start = pre.next;
		ListNode end = start.next;
		for (int i = 0; i < n - m; i++) {
			start.next = end.next;
			end.next = pre.next;
            pre.next = end;
            end = start.next;
		}
		return dummy;
	}
}
