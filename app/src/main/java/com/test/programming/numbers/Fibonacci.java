package com.test.programming.numbers;

public class Fibonacci {

	public Fibonacci() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		int N = 121;
		
		int[] fib = new int[N+2];
		fib[0] = 0;
		fib[1] = 1;
		for(int i=2; i<=N; i++) {
			fib[i] = fib[i-2] + fib[i-1];
		}
		
		for(int i=0; i < N; i++) {
			System.out.print(fib[i] + " ");
		}
		
		
		
		// with dynamic programming
		
		int[] f = new int [N + 2];
		f[0] = 0;
		f[1] = 1;
		
		for(int i=2; i<=N; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		
	}

}
