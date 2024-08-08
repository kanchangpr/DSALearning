package com.kanchan.linkedlist;

public class LinkedListSort {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		ListNode mid = getMid(head);
		ListNode left = head;
		ListNode right = mid.next;
		mid.next = null;

		return merge(sortList(left), sortList(right));
	}

	private static ListNode getMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = null;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		return prev;
	}

	private static ListNode merge(ListNode left, ListNode right) {
		ListNode dummy = new ListNode(0);
		ListNode curr = dummy;

		while (left != null && right != null) {
			if (left.val < right.val) {
				curr.next = left;
				left = left.next;
			} else {
				curr.next = right;
				right = right.next;
			}
			curr = curr.next;
		}

		curr.next = (left != null) ? left : right;

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
		ListNode head = new ListNode(4);
		head.next = new ListNode(2);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(3);

		System.out.println("Original List:");
		printList(head);

		head = sortList(head);

		System.out.println("Sorted List:");
		printList(head);
	}
}
