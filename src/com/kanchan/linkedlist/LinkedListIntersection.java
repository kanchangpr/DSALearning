package com.kanchan.linkedlist;

public class LinkedListIntersection {

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null)
			return null;

		ListNode a = headA;
		ListNode b = headB;

		while (a != b) {
			a = (a == null) ? headB : a.next;
			b = (b == null) ? headA : b.next;
		}

		return a;
	}

	public static void main(String[] args) {
		ListNode common = new ListNode(8);
		common.next = new ListNode(10);

		ListNode headA = new ListNode(1);
		headA.next = new ListNode(3);
		headA.next.next = common;

		ListNode headB = new ListNode(2);
		headB.next = common;

		ListNode intersection = getIntersectionNode(headA, headB);

		System.out.println("Intersection Node: " + (intersection != null ? intersection.val : "None"));
	}
}
