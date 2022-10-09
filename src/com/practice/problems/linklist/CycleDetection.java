package com.practice.problems.linklist;

public class CycleDetection {
	// Complete the hasCycle function below.
	
	/*
	 * For your reference:
	 *
	 * SinglyLinkedListNode {
	 *     int data;
	 *     SinglyLinkedListNode next;
	 * }
	 *
	 */
	static boolean hasCycle(SinglyLinkedListNode head) {
	    SinglyLinkedListNode slow = head;
	    SinglyLinkedListNode fast = head;
	    
	    boolean flag = false;
	    while(slow!=null && fast!=null && fast.next!=null){
	        slow = slow.next;
	        fast = fast.next.next;
	        if(slow == fast){
	            flag = true; 
	            break;
	        }
	    }
	return flag;
	}
}

