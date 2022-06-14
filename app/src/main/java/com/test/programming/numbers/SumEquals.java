package com.test.programming.numbers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SumEquals {

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub
		int[] numbers = { 2, 4, 3, 5, 7, -2, 8, 9 , 2};
//		int[] numbersWithDuplicates = { 2, 4, 3, 5, 6, -2, 4, 7, 8, 9 };
		System.out.println("prettyPrint");
		prettyPrint(numbers, 7);
		System.out.println("prettyPrintHash");
//		prettyPrint(numbersWithDuplicates, 7);
		

		prettyPrintHash(numbers, 7);
		

		System.out.println("prettyPrintPointers");
		prettyPrintPointers(numbers, 7);
	}

	private static void prettyPrint(int[] numbers, int sum) {
		for(int i=0; i<numbers.length; i++) {
			int first = numbers[i];
			for(int j=i+1; j<numbers.length; j++) {
				int second = numbers[j];
				if((first+second) == sum) {
					System.out.printf("(%d, %d) %n", first, second);
				}
			}
		}
	}

	private static void prettyPrintHash(int[] numbers, int sum) {
		if(numbers.length < 2) {
			return;
		}
		Set<Integer> set = new HashSet<Integer>(numbers.length);
		for(int value : numbers) {
			int target = sum - value;
			if(!set.contains(target))
				set.add(value);
			else
				System.out.printf("(%d, %d) %n", value, target);
		}
	}

	private static void prettyPrintPointers(int[] numbers, int k) {
		if(numbers.length < 2) {
			return;
		}
		Arrays.sort(numbers);
		int left = 0, right = numbers.length-1;
		while(left < right) {
			int sum = numbers[left] + numbers[right];
			if(sum == k) {
				System.out.printf("(%d, %d) %n", numbers[left], numbers[right]);
				left++;
				right--;
			} else if (sum < k) {
				left = left + 1;
			} else if (sum > k) {
				right = right -1;
			}
		}
	}

}
