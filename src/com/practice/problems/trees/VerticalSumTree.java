package com.practice.problems.trees;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;

class VerticalSum {


    public static void verticalSum(TreeNode root, int distance, Map<Integer,Integer> sum) {
       
        if(root==null || root.data ==-1){
            return;
        }
        if(sum.containsKey(distance)){
            sum.put(distance, sum.get(distance)+root.data);
        }else{
            sum.put(distance,root.data);
        }
         
        verticalSum(root.left,distance-1,sum);
        verticalSum(root.right,distance+1,sum);

    }
}

public class VerticalSumTree {
    static TreeNode root; 
    static TreeNode temp = root; 
    
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
            }
            else
                q.add(temp.left);
 
            if (temp.right == null) {
                temp.right = new TreeNode(key);
                break;
            }
            else
                q.add(temp.right);
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
       
        while(t-- > 0) {
            int data = scan.nextInt();
            insert(root, data);
        }
       
        scan.close();
        
        int distance = 0;
        Map<Integer,Integer> sum = new TreeMap<>();
        VerticalSum.verticalSum(root, distance, sum);
         for (Map.Entry<Integer, Integer> entry : sum.entrySet()) {
                System.out.print(entry.getValue()+" ");
              }
    }
 

}
