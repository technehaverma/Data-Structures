package com.practice.problems.arrays;

public class UnsortedArraySort {
	public static void main(String[] args) {
		int []array = {4,1,7,2,8,3,9,5,6}; 
		int count = findLargestElement(array);
		System.out.println(count);
	}

	private static int findLargestElement(int[] array) {
		int len = array.length;
		int i = 0; 
		int j = i;
		int count = 0;
		if(len<2) {
			return array[0];
		}
		for(i = 0; i<len-1;i++) {
			if(array[i]>array[i+1]) {
				count = array[i];
			}
		}
		return count;
	}
}
