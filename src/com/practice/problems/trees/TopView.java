package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class TopView {
	public static void topViewPrint(TreeNode root, Map<Integer, Integer> hm, int dist, int min) {
		if (root == null) {
			return;
		}
		hm.putIfAbsent(dist, root.data);
		if (min >= dist) {
			min = dist;
		}
		if (root.left != null) {
			System.out.println(dist);
			topViewPrint(root.left, hm, dist - 1, min);
			System.out.println(dist);
		}
		if (root.right != null) {
			System.out.println(dist);
			topViewPrint(root.right, hm, dist + 1, min);
			System.out.println(dist);
		}

	}
	
	public static void postOrder(TreeNode root, int k, ArrayList<Integer> res){
	       if(root!=null){
	           
	            res.add(root.data);
	            postOrder(root.left,k,res);
	            postOrder(root.right, k, res);
	            
	        }
	    }
	    public static int KLargestElement(TreeNode b_tree, int k) {
	        ArrayList<Integer> res = new ArrayList<>();
	        
	        postOrder(b_tree,k,res);
	        for (Integer integer : res) {
				System.out.println(integer);
			}
	        while(k>res.size()-1){
	            k = k%res.size();
	        }
	        if(res.size()-1<k || res.size()==0){
	            return -1;
	        }
	        System.out.println( res.get(res.size()-1-k));
	        return res.get(res.size()-1-k);
	    }

	public static void topView(TreeNode root) {
		Map<Integer, Integer> hm = new TreeMap<>();
		int dist = 0;
		TreeNode temp = root;
		topViewPrint(temp, hm, 0, dist);

		 for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
		        System.out.print(entry.getValue()+" ");
		      }

	}
	public static void main(String[] args) {
	}
}