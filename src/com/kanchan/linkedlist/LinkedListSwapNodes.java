package com.kanchan.linkedlist;

public class LinkedListSwapNodes {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode prev = dummy;

		while (head != null && head.next != null) {
			ListNode first = head;
			ListNode second = head.next;

			prev.next = second;
			first.next = second.next;
			second.next = first;

			prev = first;
			head = first.next;
		}

		return dummy.next;
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

		System.out.println("Original List:");
		printList(head);

		head = swapPairs(head);

		System.out.println("List After Swapping Pairs:");
		printList(head);
	}
}
