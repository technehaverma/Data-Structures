package com.practice.problems.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> brackets = new ArrayList<>();
        brackets = generateParenthesis(n,0, 0,0, new StringBuilder(), brackets);
        return brackets;
    }
    
     public List<String> generateParenthesis(int n, int openCount,int closeCount, int index, StringBuilder val, List<String> brackets) {
     
         if(val.length() == n*2){
             brackets.add(val.toString());
             return brackets;
         }
         if(openCount<n){
             val.append('(');
             brackets = generateParenthesis(n, openCount+1, closeCount, index+1,val,brackets);
             val.deleteCharAt(val.length()-1);
         }
         
         if(closeCount<openCount){
             val.append(')');
             brackets = generateParenthesis(n, openCount, closeCount+1, index+1,val,brackets);
             val.deleteCharAt(val.length()-1);
         }
         return brackets;
         
     }
}