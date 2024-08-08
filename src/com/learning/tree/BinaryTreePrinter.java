package com.learning.tree;

import java.util.*;

public class BinaryTreePrinter {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(4);
		root.left.right.left = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);
		root.right.right.left = new TreeNode(8);
		root.right.right.right = new TreeNode(10);
		root.right.right.right.left = new TreeNode(9);
		root.right.right.right.right = new TreeNode(12);

		printTree(root);
	}

	static class NodePosition {
		TreeNode node;
		int pos;
		int depth;

		NodePosition(TreeNode node, int pos, int depth) {
			this.node = node;
			this.pos = pos;
			this.depth = depth;
		}
	}

	public static void printTree(TreeNode root) {
		if (root == null) {
			return;
		}

		Queue<NodePosition> queue = new LinkedList<>();
		Map<Integer, List<NodePosition>> levels = new HashMap<>();

		queue.add(new NodePosition(root, 0, 0));

		int minPos = 0;
		int maxPos = 0;

		while (!queue.isEmpty()) {
			NodePosition current = queue.poll();
			minPos = Math.min(minPos, current.pos);
			maxPos = Math.max(maxPos, current.pos);

			levels.putIfAbsent(current.depth, new ArrayList<>());
			levels.get(current.depth).add(current);

			if (current.node.left != null) {
				queue.add(new NodePosition(current.node.left, current.pos - 1, current.depth + 1));
			}
			if (current.node.right != null) {
				queue.add(new NodePosition(current.node.right, current.pos + 1, current.depth + 1));
			}
		}

		for (int depth = 0; levels.containsKey(depth); depth++) {
			List<NodePosition> level = levels.get(depth);
			Collections.sort(level, Comparator.comparingInt(np -> np.pos));

			int curPos = minPos;
			StringBuilder nodeLine = new StringBuilder();
			StringBuilder connectLine = new StringBuilder();

			for (NodePosition np : level) {
				while (curPos < np.pos) {
					nodeLine.append("    ");
					curPos++;
				}

				nodeLine.append(String.format("%2d  ", np.node.val));

				curPos++;
			}

			System.out.println(nodeLine.toString());
			if (levels.containsKey(depth + 1)) {
				System.out.println(connectLine.toString());
			}
		}
	}
}
