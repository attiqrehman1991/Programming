package com.test.programming.numbers;

public class NumberOf1s {
	
	public static void main(String[] args) {
		int sum = 0;
		int number = 8;
		
		while(number > 0) {
			sum += number%2;
			number >>= 1;
		}
		System.out.print(sum);
		
	}

}
