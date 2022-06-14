package com.test.programming.numbers;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		int array[] = { 0, 1, 0, 3, 2, 3 };
//		int array[] = { 84, 80, 23 };
		System.out.println(lis2(array));
		System.out.println(lis(array));
	}

	public static int lis2(final int[] A) {
		int n = A.length;

		int[] ans = new int[n];
		Arrays.fill(ans, 1);
		int sol = 1;

		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (A[i] > A[j]) {
					ans[i] = Math.max(ans[i], 1 + ans[j]);
				}
				if (ans[i] > sol) {
					sol = ans[i];
				}
			}
		}
		return sol;
	}

	public static int lis(final int[] A) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		new ArrayList<Integer>();

		if (A.length == 0 || A.length == 1) {
			return A.length;
		}

		int currentMax = 0;
		int highestCount = 0;

		for (int i = 0; i < A.length; i++) {
			currentMax = Integer.MIN_VALUE;
			for (int j = i; j < A.length; j++) {
				if (A[j] > currentMax) {
					list.add(A[j]);
					currentMax = A[j];
				}
			}
			if (highestCount < list.size()) {
				highestCount = list.size();
				new ArrayList<Integer>(list);
			}
			list.clear();
		}
		return highestCount;
	}
}
