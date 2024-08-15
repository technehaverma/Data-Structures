package com.practice.problems.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    
    public List<String> letterCombinations(String digits) {
        
        Map<Character, String> hMap = new HashMap<>();
        hMap.put('2',"abc");
        hMap.put('3',"def");
        hMap.put('4',"ghi");
        hMap.put('5',"jkl");
        hMap.put('6',"mno");
        hMap.put('7',"pqrs");
        hMap.put('8',"tuv");
        hMap.put('9',"wxyz");
        
        char[] charArr = digits.toCharArray();
        List<String> res = new ArrayList<>();
        for(char c:charArr){
            res.add(hMap.get(c));
        }
        
        if(res.size()==0){
            return res;
        }
        List<String> letter = new ArrayList<>();
        letter = letterCombinationsRes(res, 0, res.size(), letter, new StringBuilder());
        return letter;
    }
    
    public List<String> letterCombinationsRes(List<String> digits, int index, int size, List<String> letter, StringBuilder val) {
    
        if(index>=size){
            letter.add(val.toString());
            return letter;
        }
        String str = digits.get(index);

		
        for(int i = 0; i<str.length();i++){
            val.append(str.charAt(i));
            letterCombinationsRes(digits, index+1, size,letter,val);
            val.deleteCharAt(val.length()-1);
        }
        return letter;
    }
}