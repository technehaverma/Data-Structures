package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
int data;
Node left;
Node right;
}
public class LevelOrder {
	/* 
	
	class Node 
		int data;
		Node left;
		Node right;
	*/
	public static void levelOrder(Node root) {
	  Queue<Node> q = new LinkedList<>();
	    ArrayList<Integer> curr = new ArrayList<>();
	    if(root==null) return;
	    q.offer(root);
	    q.offer(null);
	    while(!q.isEmpty()){
	        Node temp = q.poll();
	        if(temp!=null){
	            curr.add(temp.data);
	            if(temp.left!=null)
	                q.offer(temp.left);
	            if(temp.right!=null)
	                q.offer(temp.right);
	        }else{
	            if(!q.isEmpty())
	                q.offer(null);
	        }
	    }
	    for(int i = 0; i<curr.size();i++){
	        System.out.print(curr.get(i)+" ");
	    }
	
	}
}

