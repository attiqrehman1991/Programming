package com.test.programming.numbers;

public class isPalindromeNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n = 15951;
		
		if(n <= 0 || n % 10 ==0) {
			System.out.println("No palindrom");
		} else {
			int reversed_int = 0;
			
			while ( n  > reversed_int) {
				int pop = n %10;
				n = n/10;
				reversed_int = (reversed_int * 10) + pop;
			}
			
			if(n == reversed_int || n == reversed_int/10) {
				System.out.println("Palindrom");
			} else 
				System.out.println("Not Palindrom");
			
		}
		
		
		
		int rv2 = 0;
		int n2 = 15551;
		while(rv2 < n2) {
			int pop = n2%10;
			n2 = n2/10;
			rv2 = (rv2 * 10) + pop;
		}
		
		if(n2 == rv2 || n2 == rv2/10) {
			System.out.println("Pali");
		} else
			System.out.println("No Pali");
	}

}
