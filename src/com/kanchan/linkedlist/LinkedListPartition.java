package com.kanchan.linkedlist;

public class LinkedListPartition {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode partition(ListNode head, int x) {
		ListNode beforeHead = new ListNode(0);
		ListNode before = beforeHead;
		ListNode afterHead = new ListNode(0);
		ListNode after = afterHead;

		while (head != null) {
			if (head.val < x) {
				before.next = head;
				before = before.next;
			} else {
				after.next = head;
				after = after.next;
			}
			head = head.next;
		}
		after.next = null;
		before.next = afterHead.next;

		return beforeHead.next;
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
		head.next = new ListNode(4);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(2);

		System.out.println("Original List:");
		printList(head);

		head = partition(head, 3);

		System.out.println("Partitioned List:");
		printList(head);
	}
}
