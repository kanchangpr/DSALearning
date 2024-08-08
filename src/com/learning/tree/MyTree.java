package com.learning.tree;

public class MyTree {
	public class Node {
		private int value;
		private Node left;
		private Node right;
		private int height;

		@Override
		public String toString() {
			return "Node [value=" + value + ", left=" + left + ", right=" + right + "]";
		}

		public Node(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}

	private Node root;

	public static void main(String[] args) {
		MyTree tree = new MyTree();
		int[] nums = { 5, 2, 7, 1, 4, 6, 9, 8, 3, 10, 9, 12 };
		tree.populate(nums);
		tree.display();
		tree.printTree();
		// System.out.println(balanced());
	}

	private void printTree() {
		printTree(root, 0);
	}

	// Helper method to print spaces
	private static void printSpaces(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print(" ");
		}
	}

	// Method to print the tree
	public void printTree(Node node, int level) {
		if (node == null) {
			return;
		}

		printTree(node.right, level + 1);
		printSpaces(level * 4);
		System.out.println(node.value);
		printTree(node.left, level + 1);
	}

	private void display() {
		display("Root Node: --> ", root);
	}

	private void display(String details, Node node) {
		if (node == null) {
			return;
		}
		System.out.println(details + node.value);
		display(" Left Node:  -->", node.left);
		display(" Right Node:  -->", node.right);

	}

	private void populate(int[] nums) {
		for (int num : nums) {
			insert(num);
		}
	}

	private void insert(int num) {
		root = insert(root, num);
		// System.out.println(root);
	}

	private Node insert(Node node, int num) {
		if (node == null) {
			node = new Node(num);
			return node;
		}

		if (num < node.value) {
			node.left = insert(node.left, num);
		}
		if (num > node.value) {
			node.right = insert(node.right, num);
		}
		node.height = Math.max(height(node.left), height(node.right)) + 1;
		return node;
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		}
		return node.height;
	}

}
