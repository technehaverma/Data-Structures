package com.practice.problems.strings;

public class PrettyPrintString {
	public static String pretty(String A, int B) {

		if (B == 1)
			return A;

		int n = A.length() - 1;
		String[] str = new String[B];
		int dir = 0;
		int row = 0;
		for (int i = 0; i <= n; i++) {
			if (row == 0) {
				dir = 0;
			}
			if (row == B - 1) {
				dir = 1;
			}
			if (dir == 0) {
				str[row] = str[row] + A.charAt(i);
				row++;
			}
			if (dir == 1) {
				str[row] = str[row] + A.charAt(i);
				row--;
			}
		}

		String s = new String();
		for (int i = 0; i < B; i++)
			if (str[i] != null)
				s = s + str[i].substring(4).trim();

		return s.toString();
	}

	public static void main(String[] args) {
		String s = pretty("PAYPALISHIRING", 3);
		System.out.println(s);
	}
}
