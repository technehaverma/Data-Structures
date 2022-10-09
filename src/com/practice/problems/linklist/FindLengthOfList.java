package com.practice.problems.linklist;

import java.util.Stack;

public class FindLengthOfList {
	private static ListNode node1;
	private static ListNode node2;
	private static ListNode node3;
	private static ListNode node4;
	private static ListNode node5;
	private static ListNode node6;
	private static ListNode node7;

	public void populateList() {
		node1 = new ListNode();
		node2 = new ListNode();
		node3 = new ListNode();
		node4 = new ListNode();
		node5 = new ListNode();
		node6 = new ListNode();
		node7 = new ListNode();

		node1.setData(1);
		node2.setData(2);
		node3.setData(3);
		node4.setData(4);
		node5.setData(5);
		node6.setData(6);
		node7.setData(7);

		node1.setNext(node2);
		node2.setNext(node3);
		node3.setNext(node4);
		node4.setNext(node5);
		node5.setNext(node6);
		node6.setNext(node7);

	}

	public static void main(String[] args) {
		FindLengthOfList findLengthOfList = new FindLengthOfList();

		findLengthOfList.populateList();
		findLengthOfList.findLength(node1);
		// SegregateLLEvenOdd(node1);
		/*
		 * 
		 * findLengthOfList.insertNodeBeforeFirstNode(new ListNode(0));
		 * findLengthOfList.findLength(findLengthOfList.getHeadNode());
		 * findLengthOfList.insertNodeAfterLastElement(new ListNode(5));
		 * findLengthOfList.findLength(findLengthOfList.getHeadNode());
		 * findLengthOfList.insertNodeInMiddle(new ListNode(6), 0);
		 * findLengthOfList.findLength(findLengthOfList.getHeadNode());
		 */
		// reverseList(node1);
		// RemoveNNodeBack(node1, 2);
		// isPalindrome(node1);
		RearrangeLL(node1);
	}

	// find length of a list
	public static int findLength(ListNode headNode) {
		int count = 0;
		ListNode curr = headNode;
		while (curr != null) {
			++count;
			System.out.print(curr.getData());
			curr = curr.getNext();

		}
		System.out.println();
		return count;
	}

	public ListNode getHeadNode() {
		return node1;
	}

	public void setHeadNode(ListNode head) {
		node1 = head;
	}

	// insert a node before the first node
	public ListNode insertNodeBeforeFirstNode(ListNode newHeadNode) {
		if (getHeadNode() == null) {
			setHeadNode(newHeadNode);
			return newHeadNode;
		}
		newHeadNode.setNext(node1);
		setHeadNode(newHeadNode);
		return newHeadNode;
	}

	// insert a node after last element
	public ListNode insertNodeAfterLastElement(ListNode tailNode) {
		if (getHeadNode() == null) {
			setHeadNode(tailNode);
			return tailNode;
		}
		ListNode curr = getHeadNode();
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}
		curr.setNext(tailNode);
		tailNode.setNext(null);
		return getHeadNode();
	}

	// insert a node in middle of a list
	public ListNode insertNodeInMiddle(ListNode middleList, int position) {
		int count = findLength(getHeadNode());
		if (position > count) {
			position = count;
		}
		if (position < 0) {
			position = 0;
		}
		if (count == 0) {
			setHeadNode(middleList);
			return middleList;
		}
		ListNode curr = getHeadNode();
		ListNode next = null;
		int currPosition = 0;
		if (position == 0) {
			middleList.setNext(getHeadNode());
			setHeadNode(middleList);
			return getHeadNode();
		}
		while (curr != null && currPosition < position - 1) {
			currPosition++;
			curr = curr.getNext();
		}
		next = curr.getNext();
		curr.setNext(middleList);
		middleList.setNext(next);
		return getHeadNode();
	}

	public static ListNode reverseList(ListNode start) {

		ListNode curr = start;
		ListNode prev = null;
		ListNode next = start.getNext();

		while (next != null) {
			curr.setNext(prev);
			curr = next;
			next = curr.getNext();
		}
		return curr;
	}

	public static ListNode RemoveNNodeBack(ListNode start, int k) {

		ListNode curr = start;
		ListNode end = null;
		ListNode prev = null;
		int temp = k;
		for (int i = 1; i <= k; i++) {

			if (curr != null) {
				curr = curr.getNext();
			}

		}

		while (curr != null) {
			if (end == null) {
				end = start;
			} else {
				end = end.getNext();
				if (prev == null) {
					prev = start;
				} else
					prev = prev.getNext();
			}

			curr = curr.getNext();
		}
		if (end != null) {
			prev.setNext(end.getNext());
			end.setNext(null);
			return start;
		}
		return null;

	}

	public static ListNode SegregateLLEvenOdd(ListNode start) {
		ListNode curr = start;
		ListNode prev = null;
		ListNode newList = null;
		ListNode odd = start;
		int count = 0;
		while (curr != null) {
			ListNode temp = curr;

			if (curr.getData() % 2 == 0) {
				if (count == 0) {
					newList = temp;
					newList.setData(temp.getData());
					newList.setNext(null);
					start = curr;
					odd = newList;
				}
				if (newList == null) {
					newList = new ListNode(temp.getData());

					odd = newList;
				} else {
					ListNode no = new ListNode(temp.getData());
					no.setNext(null);
					newList.setNext(no);

					newList = newList.getNext();
				}
				curr = curr.getNext();
				prev.setNext(curr);

			} else {
				prev = curr;
				curr = curr.getNext();
			}
			count++;

			findLength(start);
			findLength(odd);
		}
		if (start != null) {
			newList.setNext(start);

		}

		findLength(odd);
		return odd;
	}

	public static boolean isPalindrome(ListNode start) {
		ListNode slowPtr = start;
		ListNode fastPtr = start;

		while (fastPtr.getNext() != null && fastPtr.getNext().getNext() != null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
		}

		ListNode prev = null, post = null;
		ListNode ptr = slowPtr.getNext();
		while (ptr != null) {
			post = ptr.getNext();
			ptr.setNext(prev);
			prev = ptr;
			ptr = post;
		}

		while (start != null && prev != null) {
			if (start.getData() != prev.getData()) {
				return false;
			}
			if (start.getData() != prev.getData()) {
				return false;
			} else {
				start = start.getNext();
				prev = prev.getNext();

			}
		}
		return true;
	}

	public static ListNode RearrangeLL(ListNode start) {
		ListNode slowPtr = start;
		ListNode fastPtr = start;

		while (fastPtr.next != null && fastPtr.next.next != null) {
			slowPtr = slowPtr.next;
			fastPtr = fastPtr.next.next;
		}
		fastPtr = start;
		ListNode second = slowPtr.next;
		slowPtr.next = null;

		ListNode reverseList = second;
		ListNode curr = reverseList;
		ListNode prev = null;

		while (reverseList != null) {
			curr = reverseList.next;
			reverseList.next = prev;
			prev = reverseList;
			reverseList = curr;

		}

		ListNode third = start;

		while (start != null && prev != null) {

			ListNode next = third.next;
			ListNode temp = new ListNode(prev.data);

			third.next = temp;
			temp.next = next;
			third = third.next;
			prev = prev.next;
			start = start.next;
			third = third.next;

		}
		return fastPtr;
	}

}
//1 2 3 4 3 2 1
//1 1 2 2 3 3 4
