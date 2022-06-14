package com.test.programming.numbers;

public class LargestNumber {

	static String swap(String str, int i, int j) {
		char ch[] = str.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;
		String c = String.valueOf(ch);
		return c;
	}

	// function to find the largest number
	// with given conditions.
	static int largestNum(int num) {
		// converting the number to the string
		String num_in_str = "" + num;
		String temp = num_in_str;

		// swapping each digit
		for (int i = 0; i < num_in_str.length(); i++) {
			for (int j = i + 1; j < num_in_str.length(); j++) {

				// Swapping and checking for the larger
				num_in_str = swap(num_in_str, i, j);
				if (temp.compareTo(num_in_str) < 0)
					temp = num_in_str;

				// Reverting the changes
				num_in_str = swap(num_in_str, i, j);
			}
		}

		return Integer.parseInt(temp);
	}

	// Driver code
	public static void main(String[] s) {
		int num = 423;
		System.out.println(largestNum(num));
		num = 2736;
		System.out.println(largestNum(num));
		num = 4596;
		System.out.println(largestNum(num));
	}
}