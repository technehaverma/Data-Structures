package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindPeekElementIncreasingDecreasing {

	public static void main(String[] args) {

		int peak = FindPeekElementIncreasingDecreasing
				.findmax_value(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 3, 2, 1)));
		System.out.println("Peak: " + peak);

	}

	public static int findmax_value(List<Integer> arr) {
		int maxVal = findMaxValFromArr(arr, 0, arr.size() - 1);
		return maxVal;
	}

	private static int findMaxValFromArr(List<Integer> arr, int start, int end) {
		if (start >= end) {
			return arr.get(start);
		}
		if (start == end - 1) {
			return Math.max(arr.get(start), arr.get(end));
		}
		int mid = start + (end - start) / 2;

		if (arr.get(mid) > arr.get(mid - 1) && arr.get(mid) > arr.get(mid + 1)) {
			return arr.get(mid);
		}
		if (arr.get(mid) > arr.get(start) && arr.get(mid) < arr.get(mid + 1)) {
			return findMaxValFromArr(arr, mid + 1, end);
		}
		return findMaxValFromArr(arr, start, mid - 1);
	}

}
