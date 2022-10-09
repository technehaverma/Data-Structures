package com.practice.problems.trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class MaxSumLeafRootPath {


    public static int maxSumLeafRootPath(TreeNode root, int pathSum, int maxSum) {
       
       if (root == null || root.data == -1){
            maxSum = Math.max(maxSum,pathSum);
            return maxSum;
       }
        pathSum+=root.data;
        
       maxSum =  maxSumLeafRootPath(root.left,pathSum,maxSum);
       maxSum =  maxSumLeafRootPath(root.right,pathSum,maxSum);
        return maxSum;
       
    }
    public static void inOrder(TreeNode root){
        if(root==null || root.data == -1){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    
}

public class MaxSumLeafRootPathTree {
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
        ArrayList<Integer> output = new ArrayList<>();
        TreeNode temp = root;
        int res = MaxSumLeafRootPath.maxSumLeafRootPath(temp,0,0);
        System.out.println(res);
    }
 

}
