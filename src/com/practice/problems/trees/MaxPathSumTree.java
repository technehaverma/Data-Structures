package com.practice.problems.trees;
import java.util.*;
import java.io.*;

class MaxPathSum {


    public static int maxPathSum(TreeNode root, int[] min) {
        if(root==null || root.data ==-1){
            
            return -1;
        }
        int left =maxPathSum(root.left, min);
        int right = maxPathSum(root.right, min);
        int maxSum = Math.max(left,right);
         
        int maxData = Math.max(root.data,(root.data+maxSum));
       
        int topData = Math.max(maxData, left + right + root.data);
       min[0] = Math.max(min[0], topData);
        return maxData;
       
    }
    
     public static int maxSumHelper(TreeNode root, int[] min) {
        
       
        if(root==null || root.data ==-1){
            
            return 0;
        }
        
       
        int leftMax = maxSumHelper(root.left,min);
        int rightMax = maxSumHelper(root.right,min);

      
        int maxRightLeft = Math.max(leftMax, rightMax);
        int maxOneTreeNodeRoot = Math.max(root.data, (root.data + maxRightLeft));
        int maxAll = Math.max(maxOneTreeNodeRoot, leftMax + rightMax + root.data);
        
     
        min[0] = Math.max(min[0], maxAll);
        
      
        return maxOneTreeNodeRoot;

    }
}

public class MaxPathSumTree {
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
        int min1[] = new int[1];
         min1[0] = Integer.MIN_VALUE;
         MaxPathSum.maxPathSum(root,min1);
        System.out.println(min1[0]);
    }
 

}
