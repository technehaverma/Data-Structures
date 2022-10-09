package com.practice.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sort0s1s2s {

	public static void main(String[] args) {
		List<Integer> array = new ArrayList<>(Arrays.asList(2, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1));

		sort012(array, array.size() - 1);
		System.out.println(array);
	}

	private static void sort012(List<Integer> array, int n) {
		int start = 0;
		int mid = 0;
		int end = n;

		while (mid <= end) {
			if (array.get(mid) == 2) {
				swap(array, end, mid);
				end--;
			}
			if (array.get(mid) == 1) {

				mid++;
			} else {
				swap(array, start++, mid);
				mid++;
			}
		}

	}

	private static void swap(List<Integer> array, int end, int start) {
		int temp = array.get(start);
		array.set(start, array.get(end));
		array.set(end, temp);

	}
}
