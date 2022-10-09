package com.practice.problems.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TreeDLLExample {
	static TreeNode root;
	static TreeNode temp = root;
	static TreeNode head, tail = null;

	public static void treeDllExample(TreeNode root2) {
		if (root2 == null || root2.data == -1) {
			return;
		}
		treeDllExample(root2.left);
		if (head == null) {
			head = tail = root2;
		}else {
			tail.right = root2;
			root2.left = tail;
			tail = root2;
		}
		treeDllExample(root2.right);
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

		while (t-- > 0) {
			int data = scan.nextInt();
			insert(root, data);
		}

		scan.close();

		treeDllExample(root);
		TreeNode temp = head;
		printList(temp);
		printList1(tail);
	}

	static void printList(TreeNode node) {
		while (node != null) {
			System.out.print(node.data + " ");
			node = node.right;
		}
	}
	static void printList1(TreeNode node) {
		while (node != null ) {
			System.out.print(node.data + " ");
			node = node.left;
		}
	}
}
