package com.kanchan.linkedlist;

public class LinkedListRotate {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode rotateRight(ListNode head, int k) {
		if (head == null || k == 0)
			return head;

		ListNode oldTail = head;
		int length = 1;
		while (oldTail.next != null) {
			oldTail = oldTail.next;
			length++;
		}

		oldTail.next = head;
		k = k % length;
		int stepsToNewHead = length - k;
		ListNode newTail = oldTail;

		while (stepsToNewHead > 0) {
			newTail = newTail.next;
			stepsToNewHead--;
		}

		ListNode newHead = newTail.next;
		newTail.next = null;

		return newHead;
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

		head = rotateRight(head, 2);

		System.out.println("Rotated List:");
		printList(head);
	}
}
