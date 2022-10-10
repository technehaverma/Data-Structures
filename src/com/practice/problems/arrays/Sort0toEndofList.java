package com.practice.problems.arrays;

public class Sort0toEndofList {
	static void MoveZeroToEnd(int array[], int n) {
		int i = 0;
		int k = n;
		while (i <= k) {
			if (array[i] == 0) {
				swap(array, i, k);
				k--;
			} else {
				i++;
			}
		}

	}

	static void MoveZeroToEndMaintainingSequence(int array[], int n) {
		int i = 0;
		int j = 0;
		while (j <= n) {
			if (array[j] != 0) {
				swap(array, i, j);
				j++;
				i++;
			} else {

				j++;
			}
		}

	}

	private static void swap(int[] array, int j, int k) {
		int temp = array[j];
		array[j] = array[k];
		array[k] = temp;
	}

	public static void main(String[] args) {
		int array[] = { 0, 1, 0, 3, 12 };
		int n = array.length;

		MoveZeroToEndMaintainingSequence(array, n - 1);

		System.out.println("result is: ");
		for (int i = 0; i < n; i++)
			System.out.print(array[i] + " ");
	}
}

/*
 * case1: actual = MoveZeroToEndMaintainingSequence([1,3,0,0,4,0,9],7) expected =
 * [1,3,4,9,0,0,0]
 * 
 * case2: actual = MoveZeroToEndMaintainingSequence([0,1,0,3,12],5) expected = [1,3,12,0,0]
 * 
 * case3: actual = MoveZeroToEndMaintainingSequence([0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9],13)
 * expected = [1,9,8,4,2,7,6,9,0,0,0,0,0]
 * 
 */