package com.kanchan.linkedlist;

public class LinkedListDeleteNode {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static void deleteNode(ListNode node) {
		if (node == null || node.next == null)
			return;

		ListNode next = node.next;
		node.val = next.val;
		node.next = next.next;
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
		ListNode head = new ListNode(4);
		head.next = new ListNode(5);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(9);

		System.out.println("Original List:");
		printList(head);

		deleteNode(head.next); // Delete node with value 5

		System.out.println("List After Deleting Node 5:");
		printList(head);
	}
}
