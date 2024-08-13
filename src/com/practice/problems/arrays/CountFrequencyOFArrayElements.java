package com.practice.problems.arrays;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencyOFArrayElements {
	
	public static int[] countFrequencyOfArrayElementsUsingHashMap(int[] A, int n) {
		int[] result = {0,0,0,0,0};
		Map<Integer, Integer> hMap = new HashMap<>();
		for(int i = 0; i<n;i++) {
			if(hMap.isEmpty() || !hMap.containsKey(A[i])) {
				hMap.put(A[i], 1);
			}else {
				hMap.put(A[i], hMap.get(A[i])+1);
			}
		}
		for(int i = 0; i<n;i++) {
			if( hMap.containsKey(i+1)) {
				result[i] = hMap.get(i+1);
			}else {
				result[i] = 0;
			}
		}
		return result;
	}
	public static int[] countFrequencyOfArrayElementsOptimized(int[] A, int n) {
		
		for(int i = 0; i<n;i++) {
			A[i] = A[i]-1;		//{5, 2, 7, 7, 5, 5, 2};
		}
			for(int i = 0; i<n;i++) {
			
			A[A[i%n]%n] = A[A[i%n]%n]+n;
		}
		for(int i = 0; i<n;i++) {
			A[i] = A[i]/n;
		}
		return A;
	}
	
	public int maxFrequencyElements(int[] A) {
	       int n = A.length;
	        int ans = 0;
	        int currentFreq = 0;
	        int maxFreq = 0;
	        Map<Integer,Integer> hMap = new HashMap<>();
	        for(int i = 0; i<n;i++) {
	            int val = A[i];
	            if(!hMap.containsKey(val)){
	                hMap.put(val,1);
	               
	            }else{
	                hMap.put(val, hMap.get(val)+1);
	            }   
	               currentFreq = hMap.get(val); 
	               
	               if(currentFreq==maxFreq){
	                 maxFreq = Math.max(currentFreq,maxFreq);
	                ans+=maxFreq;
	               }else if(currentFreq>maxFreq){
	                maxFreq = Math.max(currentFreq,maxFreq);
	                ans = maxFreq;
	               }
	        }
			return ans;
	    }
	
	public static void main(String[] args) {
		int[] A = {5, 2, 7, 7, 5, 5, 2};
		
		int[] f = countFrequencyOfArrayElementsOptimized(A, A.length);
		
		  for (int i=0;i<f.length;i++) { System.out.println(f[i]); }
		 
		// output{0,2,1,1,1}
	}

}
