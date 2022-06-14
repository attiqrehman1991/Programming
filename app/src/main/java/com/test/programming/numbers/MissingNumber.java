package com.test.programming.numbers;

import java.util.BitSet;
import java.util.HashSet;

public class MissingNumber {

	private static int printMissingNumber(int[] numbers, int count) {
		int missingCount = count - numbers.length;
		BitSet bitSet = new BitSet(count);

		for (int num : numbers)
			bitSet.set(num - 1);

//		Arrays.toString(numbers);
		int lastMissingIndex = 0;

		for (int i = 0; i < missingCount; i++) {
			lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
			System.out.print(++lastMissingIndex + " ,");
		}

		return lastMissingIndex;
	}

	static void getMissingNumber() {
		int[] nums = new int[] { 1, 2, 4, 6 };
		int n = nums.length;
//		int sum = (n + 1) * (n + 2) / 2;
//		for (int i = 0; i < n; i++) {
//			sum -= nums[i];
//		}
//		System.out.println(sum);
//
//		int total = 1;
//		for (int i = 2; i <= (n + 1); i++) {
//			total += i;
//			total -= nums[i - 2];
//		}
//
//		System.out.println(total);
//
//		int x1 = nums[0];
//		int x2 = 1;
//
//		for (int i = 1; i < n; i++) {
//			x1 = x1 ^ nums[i];
//		}
//
//		for (int i = 2; i <= n + 1; i++)
//			x2 = x2 ^ i;
//
//		System.out.println(x1 ^ x2);
//		

		int XOR = nums[0];
		for (int i = 1; i < n - 2; i++)
			XOR ^= nums[i];
		for (int i = 1; i <= n; i++)
			XOR ^= i;
		
		System.out.println(XOR);

//		int set_bit_no = XOR & ~(XOR - 1);

//	    int x = 0, y = 0; // Initialize missing numbers
//	    for (int i = 0; i < n-2; i++)
//	    {
//	        if (nums[i] & set_bit_no)
//	            x = x ^ nums[i]; /*XOR of first set in arr[] */
//	        else
//	            y = y ^ nums[i]; /*XOR of second set in arr[] */
//	    }
//	    for (int i = 1; i <= n; i++)
//	    {
//	        if (i & set_bit_no)
//	            x = x ^ i; /* XOR of first set in arr[] and
//	                         {1, 2, ...n }*/
//	        else
//	            y = y ^ i; /* XOR of second set in arr[] and
//	                         {1, 2, ...n } */
//	    }

//	    System.out.printf("Two Missing Numbers are\n %d %d", x, y);	    
	}

	public static void main(String args[]) { // one missing number
		printMissingNumber(new int[] { 1, 2, 4, 6 }, 6);
		missingNumber(new int[]{1, 2, 3, 5});
		System.out.print( "fdfd ");
		System.out.print( 4 >> 2);
		System.out.print( 1 << 2);
		System.out.print( "fdfd ");
		getMissingNumber();
	}

	public static int missingNumber(int[] nums) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i : nums) {
			set.add(i);
		}
		for (int i = 0; i <= nums.length; i++) {
			if (!set.contains(i)) {
				System.out.println(i);
//				return i;
			}
		}
//		System.out.println("-1");
		return -1;
	}
//	
//	n(n+1)/2
//	
//	
//	4(5)/2 = 10
//	1+2+4 - 7
//	3

}
