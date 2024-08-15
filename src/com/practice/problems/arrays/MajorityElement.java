package com.practice.problems.arrays;

import java.util.Arrays;

public class MajorityElement {

	public static int majorityElement(int[] arr) {
		Arrays.sort(arr);
		return arr[arr.length] / 2;
	}

	public static int majorityElementOptimized(int[] arr) {
		int count = 1;
		int majority = arr[0];
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] == majority) {
				count++;

			} else {
				count--;
			}
			if (count == 0) {
				count = 1;
				majority = arr[i];
			}

		}
		return majority;
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 1, 2, 2, 3, 3, 3, 1, 2, 1,2,2 };
		//majorityElement(arr);
		System.out.println(majorityElementOptimized(arr));
	}

}
