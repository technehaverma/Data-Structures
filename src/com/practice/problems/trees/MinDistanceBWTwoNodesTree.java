package com.practice.problems.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MinDistanceBWTwoNodes {

	public static TreeNode lca(TreeNode root, int v1, int v2) {
		if (root == null || root.data == -1 || root.data == v1 || root.data == v2) {
			return root;
		}
		TreeNode left = lca(root.left, v1, v2);
		TreeNode right = lca(root.right, v1, v2);
		if (left == null || left.data == -1) {
			return right;
		} else if (right == null || right.data == -1) {
			return left;
		} else {
			return root;
		}
	}

	public static int findLevel(TreeNode root, int a, int level) {
		if (root == null || root.data == -1)
			return -1;
		if (root.data == a)

			return level;

		int left = findLevel(root.left, a, level + 1);
		if (left == -1)
			return findLevel(root.right, a, level + 1);
		return left;
	}

	public static int findDistance(TreeNode root, int a, int b) {

		TreeNode lca1 = lca(root, a, b);
		int d1 = findLevel(lca1, a, 0);
		int d2 = findLevel(lca1, b, 0);

		return d1 + d2;
	}
}

public class MinDistanceBWTwoNodesTree {
	static TreeNode root;
	static TreeNode temp = root;

	public static void insert(TreeNode temp, int key) {

		if (temp == null) {
			root = new TreeNode(key);
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(temp);

		while (!q.isEmpty()) {
			temp = q.peek();
			q.remove();

			if (temp.left == null) {
				temp.left = new TreeNode(key);
				break;
			} else
				q.add(temp.left);

			if (temp.right == null) {
				temp.right = new TreeNode(key);
				break;
			} else
				q.add(temp.right);
		}
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		int k = scan.nextInt();
		int k1 = scan.nextInt();
		while (t-- > 0) {
			int data = scan.nextInt();
			insert(root, data);
		}

		scan.close();

		int res = MinDistanceBWTwoNodes.findDistance(root, k, k1);
		System.out.println(res);
	}

}
