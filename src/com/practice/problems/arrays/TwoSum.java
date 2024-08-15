package com.practice.problems.arrays;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

	public static int[] twoSum(int nums[], int len, int target) {
		int[] ret = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= target)
				return ret;
			int x = target - nums[i];
			
			int index = Arrays.binarySearch(nums,i+1,nums.length, x);
			if (index > -1) {
				ret[0] = i;
				ret[1] = index;
				return ret;
			} else {
				continue;
			}

		}
		return ret;
	}

	public static int[] twoSum2(int[] numbers, int target) {
		HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
		for (int i = 0; i < numbers.length; i++) {
			Integer requiredNum = (Integer) (target - numbers[i]);
			if (indexMap.containsKey(requiredNum)) {
				int toReturn[] = { indexMap.get(requiredNum), i };
				return toReturn;
			}

			indexMap.put(numbers[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		int arr[] = {0,4,3,0};
		int len = arr.length;
		int k = 0;
		int arr1[] = twoSum(arr, len, k);
		for (int x : arr1) {
			System.out.println(x);
		}
	}
}