package com.practice.problems.arrays;

public class Find2NonRepeatingNo {
	
	public static int[] fing2NonRepeatingNumber(int[] arr) {
		int[] res = {0,0};
		int val = arr[0];
		for(int i = 1; i<arr.length;i++) {
			val^=arr[i];
		}
		int rightSigBit = val&(~(val-1));
		int a = 0,b = 0;
		for(int i = 0; i<arr.length;i++) {
			int valre = arr[i]&rightSigBit;
			if(valre!=0) {
				a=arr[i]^a;
			}else {
				b=arr[i]^b;
			}
		}
		res[0] = a;
		res[1] = b;
		return res;
	}
	public static void main(String[] args) {
		int[] arr = {4,5,4,5,3,2,9,3,9,8};
		int[] res = fing2NonRepeatingNumber(arr );
		for (int i : res) {
			System.out.println(i);
		}
	}

}
