package com.kanchan.linkedlist;

import java.util.HashSet;
import java.util.Set;

class Node {
	int value;
	Node next;

	Node(int value) {
		this.value = value;
	}

	Node() {
	}
}

public class LL {

	public static void main(String[] args) {
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = new Node(2);
		head.next.next.next.next.next = new Node(1);

//		Node res = removeDuplicateUnsorted(head);
//		Node res = inserLast(head, 0);
//		Node newHead = null;
//		Node res = inserFirst(newHead,9);
		/*
		 * Node res = deleteNodeAllOccurance(head, 1); while (res != null) {
		 * System.out.print(res.value + " "); res = res.next; }
		 */

		// Create nodes
		Node node1 = new Node(11);
		Node node2 = new Node(12);
		Node node3 = new Node(12);
		Node node4 = new Node(14);

		// Link nodes to form a cyclic linked list
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node2; // Cycle created here

		// Set head of the list
		Node chead = node1;

		// Print the list (will run infinitely due to cycle)
		// printCyclicList(head);

		// System.out.println(iscyclice(head));
		System.out.println(search(head, 5));
		System.out.println(searchCyclic(chead, 10));
		System.out.println(findMiddle(head).value);
	}

	public static void printCyclicList(Node head) {
		Node curr = head;
		int count = 0; // To prevent infinite loop in demonstration
		while (curr != null && count < 10) { // Limit the number of iterations
			System.out.println(curr.value);
			curr = curr.next;
			count++;
		}
	}

	public static Node removeDuplicate(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		Node curr = head;
		while (curr != null && curr.next != null) {
			if (curr.value == curr.next.value) {
				curr.next = curr.next.next;
			} else {
				curr = curr.next;
			}
		}
		return head;
	}

	public static Node removeDuplicateUnsorted(Node head) {
		if (head == null || head.next == null) {
			return head;
		}
		HashSet<Integer> seen = new HashSet<Integer>();
		Node curr = head;
		Node prev = head;
		while (curr != null) {
			if (seen.contains(curr.value)) {
				prev.next = curr.next;
			} else {
				seen.add(curr.value);
				prev = curr;
			}
			curr = curr.next;
		}
		return head;
	}

	public static Node inserLast2(Node head, int val) {
		if (head == null) {
			return new Node(val);
		}
		Node curr = head;
		while (curr != null) {
			if (curr.next == null) {
				curr.next = new Node(val);
				return head;
			}
			curr = curr.next;
		}
		return head;
	}

	public static Node inserLast(Node head, int val) {
		if (head == null) {
			return new Node(val);
		}
		Node curr = head;
		while (curr.next != null) {
			curr = curr.next;
		}
		curr.next = new Node(val);
		return head;
	}

	public static Node inserFirst(Node head, int val) {
		Node prev = new Node(val);
		prev.next = head;
		return prev;
	}

	public static Node deleteNodeFirstOccurance(Node head, int val) {
		if (head == null) {
			return head;
		}
		if (head.value == val) {
			return head.next; // New head of the list
		}
		Node curr = head;
		Node prev = null;
		while (curr != null && curr.value != val) {
			prev = curr;
			curr = curr.next;
		}
		if (curr != null) {
			prev.next = curr.next; // Skip the node to delete it
		}
		return head;
	}

	public static Node deleteNodeAllOccurance(Node head, int val) {
		Node dummy = new Node(-1); // Value of dummy node is arbitrary
		dummy.next = head;

		Node prev = dummy; // Previous node starts as the dummy node
		Node curr = head;
		while (curr != null) {
			if (curr.value == val) {
				prev.next = curr.next;
			} else {
				prev = curr;
			}
			curr = curr.next;
		}

		return dummy.next;
	}

	public static boolean iscyclice(Node head) {
		if (head == null) {
			return false;
		}
		Node slow = head;
		Node fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next; // Move slow pointer by 1 step
			fast = fast.next.next; // Move fast pointer by 2 steps

			if (slow == fast) {
				return true; // Cycle detected
			}
		}
		return false;
	}

	public static boolean search(Node head, int val) {
		if (head == null) {
			return false;
		}
		Node curr = head;

		while (curr != null) {
			if (curr.value == val) {
				return true;
			}
			curr = curr.next;
		}
		return false;
	}

	public static boolean searchCyclic(Node head, int val) {
		if (head == null) {
			return false;
		}

		Node slow = head;
		Node fast = head;

		// Detect if the list has a cycle using Floyd's Tortoise and Hare algorithm
		boolean hasCycle = false;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			if (slow == fast) {
				hasCycle = true;
				break;
			}
		}

		// If a cycle is detected, find the start of the cycle
		Node cycleStart = null;
		if (hasCycle) {
			cycleStart = findCycleStart(head, slow);
		}

		// Perform search
		Node curr = head;
		Set<Node> visited = new HashSet<>();

		while (curr != null && (!hasCycle || !visited.contains(curr))) {
			if (curr.value == val) {
				return true;
			}
			visited.add(curr);
			curr = curr.next;
		}

		return false;
	}

	private static Node findCycleStart(Node head, Node meetingPoint) {
		Node start = head;
		while (start != meetingPoint) {
			start = start.next;
			meetingPoint = meetingPoint.next;
		}
		return start;
	}

	public static int countNodes(Node head) {
		int count = 0;
		Node curr = head;
		while (curr != null) {
			count++;
			curr = curr.next;
		}
		return count;
	}

	private static Node reverseList(Node head) {
		Node prev = null;
		Node curr = head;
		Node next = null;

		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}

		return prev;
	}
	
	public static Node findMiddle(Node head) {
        if (head == null) {
            return null;
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // slow is now at the middle of the list
    }
}
