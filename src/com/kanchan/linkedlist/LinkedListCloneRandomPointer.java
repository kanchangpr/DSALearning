package com.kanchan.linkedlist;

import java.util.HashMap;

public class LinkedListCloneRandomPointer {

	static class ListNode {
		int val;
		ListNode next, random;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode copyRandomList(ListNode head) {
		if (head == null)
			return null;

		HashMap<ListNode, ListNode> map = new HashMap<>();
		ListNode curr = head;

		while (curr != null) {
			map.put(curr, new ListNode(curr.val));
			curr = curr.next;
		}

		curr = head;
		while (curr != null) {
			map.get(curr).next = map.get(curr.next);
			map.get(curr).random = map.get(curr.random);
			curr = curr.next;
		}

		return map.get(head);
	}

	public static void printList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			System.out.print("Value: " + temp.val);
			if (temp.random != null) {
				System.out.print(", Random Value: " + temp.random.val);
			}
			System.out.println();
			temp = temp.next;
		}
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.random = head.next.next; // 1 -> 3
		head.next.random = head; // 2 -> 1
		head.next.next.random = head.next.next.next; // 3 -> 4
		head.next.next.next.random = head.next; // 4 -> 2

		System.out.println("Original List:");
		printList(head);

		ListNode clonedHead = copyRandomList(head);

		System.out.println("Cloned List:");
		printList(clonedHead);
	}
}
