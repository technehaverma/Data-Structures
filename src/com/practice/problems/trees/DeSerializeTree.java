package com.practice.problems.trees;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class DeSerialize {
     public static TreeNode deserialize(ArrayList<Integer> arr, ArrayList<Integer> index) {
         index.set(0,index.get(0)+1);
         if(arr.get(index.get(0))==-1){
             return null;
         }
         TreeNode TreeNode = new TreeNode(arr.get( index.get(0)));
         System.out.println(TreeNode.data);
         TreeNode.left = deserialize(arr,index);
         TreeNode.right = deserialize(arr,index);
         return TreeNode;
     }

    public static void serialize(TreeNode root, ArrayList<Integer> arr) {
       
        if(root==null || root.data ==-1){
            arr.add(-1);
            return;
        }
        
        arr.add(root.data);
        serialize(root.left,arr);
        serialize(root.right,arr);

    }
    public static void printPreOrder(TreeNode root){
        if(root == null || root.data ==-1){
            return;
        }
       // System.out.println(root.data);
        printPreOrder(root.left);
        printPreOrder(root.right);
    }
}

public class DeSerializeTree {
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
        ArrayList<Integer> arr = new ArrayList<>();
        DeSerialize.serialize(root,arr);
        TreeNode ser = DeSerialize.deserialize(arr,new ArrayList<>(Arrays.asList(-1)));
        
        DeSerialize.printPreOrder(ser);
    }
 

}
