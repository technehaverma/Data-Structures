package com.practice.problems.trees;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class PrintBoundaryleft {


    public static void printBoundaryleft(TreeNode root, ArrayList<Integer>output) {
       
        if((root.left==null || root.left.data==-1) &&( root.right==null || root.right.data==-1 )){
            return;
        }
        //left
        
        output.add(root.data);
        if(root.left!=null || root.left.data!=-1){
           printBoundaryleft(root.left,output);
        }else if(root.right!=null || root.right.data!=-1){
            printBoundaryleft(root.right,output);
        }
       
    }
    public static void printBoundaryright(TreeNode root, ArrayList<Integer>output, int i) {
       
        if((root.left==null || root.left.data==-1) &&( root.right==null || root.right.data==-1 )){
            return;
        }
        //right
        
        if(root.right!=null|| root.left.data!=-1){
           printBoundaryright(root.right,output,i+1);
        }else{
            printBoundaryright(root.left,output,i+1);
        }
        if(i!=0){
        output.add(root.data);
        }
    }
    public static void printBoundaryleaf(TreeNode root, ArrayList<Integer>output) {
       
        if(root==null || root.data ==-1 ){
            return;
        }
          
        
            printBoundaryleaf(root.left,output);
        if((root.left == null||root.left.data ==-1) && (root.right == null||root.right.data == -1)){
              output.add(root.data);
        }
       printBoundaryleaf(root.right,output);
    }
              
      static ArrayList < Integer > printBoundary(TreeNode TreeNode) {
        ArrayList < Integer > ans = new ArrayList < Integer > ();
       
        printBoundaryleft(TreeNode, ans);
        
        printBoundaryleaf(TreeNode, ans);
          printBoundaryright(TreeNode, ans, 0);
        return ans;
    }
}

public class PrintBoundaryTree {
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
        ArrayList<Integer> res = PrintBoundaryleft.printBoundary(root);
        for(Integer m:res){
            System.out.println(m);
        }
    }
 

}
