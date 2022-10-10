package com.practice.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindNumberInRotatedSortedArray {
	public static void main(String args[]) {
		List<Integer> array = new ArrayList<>(Arrays.asList(3, 4, 5, 6, 7, 8, 9, 1, 2));
		int n = array.size();
		int value = 1;
		int i = findNumber(array, 0, n - 1, value);
		if (i != -1)
			System.out.println("Index: " + i);
		else
			System.out.println("Value not found");
	}

	private static int findNumber(List<Integer> array, int start, int end, int value) {

		if (start > end) {

			return -1;
		}
		int mid = start + (end - start);
		if (array.get(mid) == value) {
			return mid;
		}

		if (array.get(mid) >= array.get(start)) {
			if (array.get(mid) > value && array.get(start) <= value) {
				return findNumber(array, start, mid - 1, value);
			} else {
				return findNumber(array, mid + 1, end, value);
			}
		} else if (array.get(mid) <= value && array.get(end) >= value) {
			return findNumber(array, mid + 1, end, value);
		}
		return findNumber(array, start, mid - 1, value);

	}
}
