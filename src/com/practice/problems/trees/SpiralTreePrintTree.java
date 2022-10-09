package com.practice.problems.trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;



class SpiralTreePrint {


    public static void traverseSpiralOrder(TreeNode root,Stack<TreeNode> s1,Stack<TreeNode> s2,List<Integer> output) {
        s1.push(root);
        if( root==null||root.data == -1 ){
            return;
        }
        while(!s1.isEmpty() || ! s2.isEmpty()){
            
            while(!s1.isEmpty()){
                TreeNode temp = s1.peek();
                if(temp.data!=-1){
                output.add(s1.pop().data);
                if(temp.left!=null){
                    s2.push(temp.left);
                }if(temp.right!=null){
                    s2.push(temp.right);
                }
                }else{
                    s1.pop();
                }
            }
            while(!s2.isEmpty()){
                TreeNode temp = s2.peek();
                if(temp.data!=-1){
                output.add(s2.pop().data);
                if(temp.right!=null){
                    s1.push(temp.right);
                }if(temp.left!=null){
                    s1.push(temp.left); 
                }
                }else{
                    s2.pop();
                }
            }
        }
    }
}

public class SpiralTreePrintTree {
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
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> output = new ArrayList<>();
        SpiralTreePrint.traverseSpiralOrder(root,s1,s2,output);
        for(Integer res:output){
            System.out.println(res);
        }
    }
 

}
