package com.test.programming.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SolutionNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(celingYear(1900));
		System.out.println(isStringPalindrom("aabaa"));
		int[] array6 = { 3, 6, -2, -5, 7, 3 };
		System.out.println("maxProductofTwo" + maxProductofTwo(array6));

		int[] array = { 1, 2, 1, 2 };
		System.out.println(solution3(array));
//
		int[] array5 = { 1, 3, 2 };
		System.out.println("solution5" + solution5(array5));

		String s1 = "aabcc", s2 = "adcaa";
		System.out.println("changeRequired " + changeRequired(s1, s2));

		System.out.println(solution(1230));
//		System.out.println(solution(239017));

		int[] array1 = { 3, 4, 6 };
		int[] array2 = { 4, 6, 3 };
		System.out.println(solution(array1, array2));
	}

	static int celingYear(int year) {
		double tt = year / 100;
		tt = Math.ceil(tt);
		return (int) Math.ceil(year / 100);
	}

	static boolean isStringPalindrom(String inputString) {
		int length = inputString.length();
		for (int i = 0; i < length / 2; i++) {
			if (inputString.charAt(i) != inputString.charAt(length - 1 - i))
				return false;
		}
		return true;
	}

	static int maxProductofTwo(int[] inputArray) {
		int sum = inputArray[0] * inputArray[1];
		for (int i = 1; i < inputArray.length - 1; i++) {
			int temp = inputArray[i] * inputArray[i + 1];
			if (temp > sum) {
				sum = temp;
			}
		}
		return sum;
	}

	static int solution3(int[] statues) {
		int count = 0;
		Arrays.sort(statues);
		for (int i = 1; i < statues.length; i++) {
			count += statues[i] - statues[i - 1] - 1;
		}
		return count;
	}

	static boolean solution5(int[] sequence) {
		int count = 0;

		for (int i = 1; i < sequence.length; i++) {
			if (sequence[i] <= sequence[i - 1]) {
				count++;

				if (i > 1 && i < sequence.length - 1 && sequence[i] <= sequence[i - 2]
						&& sequence[i + 1] <= sequence[i - 1]) {
					count++;
				}
			}
		}

		return count <= 1;
	}

	static int changeRequired(String s1, String s2) {
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];
		Arrays.fill(freq1, 0);
		Arrays.fill(freq2, 0);

		int count = 0;
		for (int i = 0; i < s1.length(); i++) {
			freq1[s1.charAt(i) - 'a']++;
		}

		for (int i = 0; i < s2.length(); i++) {
			freq2[s2.charAt(i) - 'a']++;
		}

		for (int i = 0; i < 26; i++) {
			count += (Math.min(freq1[i], freq2[i]));
		}

		return count;
	}

	static boolean solution(int n) {
		String number = String.valueOf(n);
		int sum = 0;

		int length = number.length();
		for (int i = 0; i < length / 2; i++) {
			sum += Integer.parseInt(number.charAt(i) + "") - Integer.parseInt((number.charAt(length - 1 - i)) + "");
		}

		return sum == 0;
	}

	int[] solution(int[] a) {
		int[] output = new int[a.length];
		Arrays.fill(output, 0);
		List<Integer> people = new ArrayList<>();
		for (int i = 0; i < a.length; i++) {
			if (a[i] == -1) {
				output[i] = a[i];
			} else {
				people.add(a[i]);
			}
		}
		Collections.sort(people);
		int index = 0;
		for (int i = 0; i < a.length; i++) {
			if (output[i] != -1) {
				output[i] = people.get(index++);
			}
		}

		return output;
	}

	static boolean solution(int[] a, int[] b) {
		Arrays.sort(a);
		Arrays.sort(b);

		for (int i = 0; i < a.length; i++) {
			if (a[i] != b[i]) {
				return false;
			}
		}

		return true;
	}

}
