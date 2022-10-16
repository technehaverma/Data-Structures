package com.ds.practice;

public class KthSmallestMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int length = matrix.length;
		int low = matrix[0][0];
		int high = matrix[length - 1][length - 1];

		while (low < high) {
			int mid = low + (high - low) / 2;
			int count = countLessThanTarget(matrix, mid);
			if (count < k) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	public int countLessThanTarget(int[][] matrix, int k) {
		int count = 0;

		int len = matrix[0].length;
		int i = len - 1;
		int j = 0;
		while (i >= 0 && j < len) {
			if (matrix[i][j] > k) {
				i--;
			} else {
				count = count + i + 1;
				j++;
			}
		}
		return count;
	}
}
