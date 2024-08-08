package com.learning.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {
	public static void bfs(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			TreeNode currentNode = queue.poll();
			System.out.print(currentNode.val + " ");

			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}

			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
	}

	public static void bfs1(TreeNode root) {
		if (root == null) {
			return;
		}
		

		List<TreeNode> currentLevel = new ArrayList<>();
		currentLevel.add(root);
		bfsRecursive(currentLevel);
	}

	// Helper method to perform BFS recursively
	private static void bfsRecursive(List<TreeNode> currentLevel) {
		if (currentLevel.isEmpty()) {
			return;
		}

		List<TreeNode> nextLevel = new ArrayList<>();
		for (TreeNode node : currentLevel) {
			System.out.print(node.val + " ");

			if (node.left != null) {
				nextLevel.add(node.left);
			}

			if (node.right != null) {
				nextLevel.add(node.right);
			}
		}

		// Recursive call with the next level
		bfsRecursive(nextLevel);
	}

	public static void main(String[] args) {
		// Create a sample tree:
		// 1
		// / \
		// 2 3
		// / \ \
		// 4 5 6
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.right = new TreeNode(6);
		root.right.right.right = new TreeNode(2);

		System.out.println("BFS traversal of the tree:");
		bfs(root); // Output: 1 2 3 4 5 6
		bfs1(root);
	}
}
