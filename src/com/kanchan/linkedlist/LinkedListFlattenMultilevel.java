package com.kanchan.linkedlist;

public class LinkedListFlattenMultilevel {

	static class Node {
		int val;
		Node next, prev, child;

		Node(int x) {
			val = x;
		}
	}

	public static Node flatten(Node head) {
		if (head == null)
			return null;

		Node dummy = new Node(0);
		Node prev = dummy;
		java.util.Stack<Node> stack = new java.util.Stack<>();
		stack.push(head);

		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			prev.next = curr;
			curr.prev = prev;
			prev = curr;

			if (curr.next != null) {
				stack.push(curr.next);
			}
			if (curr.child != null) {
				stack.push(curr.child);
				curr.child = null;
			}
		}

		dummy.next.prev = null;
		return dummy.next;
	}

	public static void printList(Node head) {
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.val + " ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);

		head.child = new Node(7);
		head.child.next = new Node(8);
		head.child.next.next = new Node(9);
		head.child.next.next.child = new Node(10);
		head.child.next.next.child.next = new Node(11);
		head.child.next.next.child.next.next = new Node(12);

		System.out.println("Original List:");
		printList(head);

		Node flattened = flatten(head);

		System.out.println("Flattened List:");
		printList(flattened);
	}
}
