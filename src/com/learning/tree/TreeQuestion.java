package com.learning.tree;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode() {
	}

	TreeNode(int val) {
		this.val = val;
	}

	TreeNode(int val, TreeNode left, TreeNode right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
}

public class TreeQuestion {

	public static void main(String[] args) {
		TreeQuestion treeQuestion = new TreeQuestion();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(2);
//		root.left.left.right = new TreeNode(1);
		root.left.right = new TreeNode(5);
//		root.left.right.left = new TreeNode(2);
//		root.left.right.right = new TreeNode(1);
		root.right.left = new TreeNode(6);
//		root.right.left.left = new TreeNode(6);
//		root.right.left.right = new TreeNode(6);
		root.right.right = new TreeNode(7);
//		root.right.right.left = new TreeNode(7);

		TreeNode subRoot = new TreeNode(2);
		subRoot.left = new TreeNode(4);
		subRoot.right = new TreeNode(5);

		// System.out.println(treeQuestion.countNodes(root));
		System.out.println(treeQuestion.isSubtree(root, subRoot));
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		return preorderTraversal(root, res);
	}

	private List<Integer> preorderTraversal(TreeNode root, List<Integer> res) {
		if (root == null) {
			return new ArrayList<Integer>();
		}
		res.add(root.val);
		preorderTraversal(root.left, res);
		preorderTraversal(root.right, res);

		return res;
	}

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isMirror(root.left, root.right);
	}

	public boolean isMirror(TreeNode left, TreeNode right) {
		if (left == null && right == null) {
			return true;
		}
		if (left == null || right == null) {
			return false;
		}
		if (left.val != right.val) {
			return false;
		}
		return isMirror(left.left, right.right) && isMirror(left.right, right.left);
	}

	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		}
		if (p.val != q.val) {
			return false;
		}

		return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int sum = 0;

		// Check if the left child is a leaf
		if (root.left != null && root.left.left == null && root.left.right == null) {
			sum += root.left.val;
		}

		// Recur for left and right subtrees
		sum += sumOfLeftLeaves(root.left);
		sum += sumOfLeftLeaves(root.right);

		return sum;
	}

	public boolean hasPathSum(TreeNode root, int targetSum) {
		if (root == null) {
			return false;
		}

		if (root.left == null && root.right == null) {
			return root.val == targetSum;
		}

		int newTargetSum = targetSum - root.val;

		return hasPathSum(root.left, newTargetSum) || hasPathSum(root.right, newTargetSum);
	}

	public int countNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int leftDepth = getDepth(root.left);
		int rightDepth = getDepth(root.right);

		if (leftDepth == rightDepth) {
			// return (1 << leftDepth) + countNodes(node.right);
			return (int) Math.pow(2, leftDepth) + countNodes(root.right);
		} else {
			// return (1 << rightDepth) + countNodes(node.left);
			return (int) Math.pow(2, rightDepth) + countNodes(root.left);
		}

	}

	public int getDepth(TreeNode node) {
		int depth = 0;
		while (node != null) {
			node = node.left;
			depth++;
		}
		return depth;
	}

	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
		if (root == null) {
			return false;
		}
		if (isSameTree(root, subRoot)) {
			return true;
		}
		return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

	}
}
