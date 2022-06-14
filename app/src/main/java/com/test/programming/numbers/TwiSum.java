package com.test.programming.numbers;

import java.util.HashMap;

public class TwiSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

		for (int i : nums) {
			if (sumMap.containsKey(nums[i])) {
				return new int[] { i, sumMap.get(i) };
			}
			sumMap.put(target - nums[i], i);

		}

		return new int[0];
	}

}
