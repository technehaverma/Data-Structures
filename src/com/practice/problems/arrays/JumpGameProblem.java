package com.practice.problems.arrays;

/*
 * You have an array of non-negative integers,you are initially positioned at the 
 * first index of the array.Each element in the array represents your maximum jump length at that position.
 */
public class JumpGameProblem {
	private static int Jump(int[] num) {
		int jump = 0;
		int arrayTrav = num[0];
		int maxTrav = num[0];
		int i = 0;
		while(i<num.length) {
			
			if(i>=num.length-1){
				return jump;
			}
			--arrayTrav;
			--maxTrav;
			if(maxTrav<num[i]) {
				maxTrav=num[i];
			}
			if(arrayTrav==0 && maxTrav==0) {
				return -1;
			}
			if(arrayTrav==0) {
				jump++;
				arrayTrav=maxTrav;
			}
			i++;
		}
		return jump;
	}

	public static void main(String[] args) {
		int num[] = {3,2,1,0,4};

		System.out.println("Minimum number of jumps to reach end is : " + Jump(num));
	}
}

/*
 * Try more Inputs case 1: actual = Jump([1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9])
 * expected = 3
 * 
 * case2: actual = Jump([1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1]) expected = 10
 * 
 * case3: actual = Jump([3,2,1,0,4]) expected = -1 Jump not possible
 */