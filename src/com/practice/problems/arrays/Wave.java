package com.practice.problems.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Wave {
	public static ArrayList<Integer> wave(ArrayList<Integer> A) {
		Collections.sort(A);
		int i = 0;
		int j = i + 1;
		while (j < A.size()) {
			int temp = A.get(i);
			A.set(i, A.get(j));
			A.set(j, temp);
			i += 2;
			j += 2;
		}
		return A;
	}

	public static void main(String[] args) {
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
		wave(A );
		for (Integer integer : A) {
			System.out.println(integer);
		}
	}
}
