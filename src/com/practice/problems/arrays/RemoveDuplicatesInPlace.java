package com.practice.problems.arrays;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesInPlace {
	static int removeDuplicates(int array[], int n) 
    { 
		if(n==1) {
			return 1;
		}
        int i = 0;
        int j = 1;
        int count = 1;
        while(j<n) {
        	if(array[i]==array[j]) {
        		j++;
        	}else {
        		array[++i]=array[j];
        		j++;
        		count+=1;
        	}
        }
        
        return count; 
    } 
	static int removeDuplicatesWithHashSet(int array[], int n) 
    { 
		Set<Integer>res= new HashSet<>();
        for(int i = 0; i<array.length;i++) {
        	res.add(array[i]);
        }
        
        return res.size(); 
    } 
      
    public static void main (String[] args)  
    { 
        int array[] = {1, 2, 2, 3, 4, 4, 4, 5, 5}; 
        int n = array.length; 
          
        n = removeDuplicates(array, n);
        
        for (int i=0; i<n; i++) 
           System.out.print(array[i]+" "); 
    } 
} 

/* Try more Inputs

case1:
actual = removeDuplicates([1,1,2],3)
expected = 2

case2:
actual = removeDuplicates([2, 2, 2, 2, 2],5)
expected = 1

case3:
actual = removeDuplicates([1, 2, 2, 3, 4, 4, 4, 5, 5],9)
expected = 5

case4:
actual = removeDuplicates([1,2,3,4,5],5)
expected = 5

*/