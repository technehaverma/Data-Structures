package com.practice.problems.trees;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FindRightTreeNode {
	static TreeNode root;
	static TreeNode temp = root;

	public static TreeNode findRightTreeNode(TreeNode root, TreeNode TreeNode) {
		if (root == null || root.data == -1 || root.data == TreeNode.data) {
			return null;
		}
		Queue<TreeNode> queue = new ArrayDeque<>();

		queue.add(root);

		TreeNode front;
		while (!queue.isEmpty()) {

			int size = queue.size();
			while (size-- > 0) {
				front = queue.poll();
				if (front == null || front.data == -1) {
					continue;
				}
				if (front.data == TreeNode.data) {
					if (size == 0) {
						return null;
					}

					return queue.peek();
				}

				if (front.left != null && front.left.data != -1) {
					queue.add(front.left);

				}

				if (front.right != null && front.right.data != 1) {
					queue.add(front.right);

				}
			}
		}

		return null;
	}

	public static TreeNode levelOrder(TreeNode root, TreeNode TreeNode) {
		Queue<TreeNode> q = new LinkedList<>();
		if (root == null || root.data == -1 || root.data == TreeNode.data)
			return null;
		q.offer(root);
		q.offer(null);
		while (!q.isEmpty()) {

			TreeNode temp = q.poll();

			if (temp != null && temp.data == TreeNode.data) {
				if (q.isEmpty()) {
					return null;
				}

				return q.peek();
			}

			if (temp != null) {
				if (temp.left != null && temp.left.data != -1)
					q.offer(temp.left);

				if (temp.right != null && temp.right.data != -1)
					q.offer(temp.right);

			} else {
				if (!q.isEmpty())
					q.offer(null);

			}

		}
		return null;
	}

	public static void insert(TreeNode temp, int key) {

		if (temp == null) {
			root = new TreeNode(key);
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.add(temp);

		// Do level order traversal until we find
		// an empty place.
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

		while (t-- > 0) {
			int data = scan.nextInt();
			insert(root, data);
		}

		scan.close();

		TreeNode res = new TreeNode(k);
		TreeNode res1 = levelOrder(root, res);
		if (res1 == null) {
			System.out.println(-1);
		} else {
			System.out.println(res1.data);
		}

	}
}