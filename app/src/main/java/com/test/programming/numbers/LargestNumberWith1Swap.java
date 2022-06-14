package com.test.programming.numbers;

public class LargestNumberWith1Swap {

	public static void main(String[] args) {

		String number = "2736";

		bruthForce(number);
		efficientWay(number);
	}
	
	private static void efficientWay(String number) {
		int max_digit = -1;
		int max_digit_index = -1;
		int l_index = -1;
		int r_index = 1;
		
		String num_in_str = number;
		
		for(int i= num_in_str.length() - 1; i>= 0; i--) {
			
			if(num_in_str.charAt(r_index) > max_digit) {
				max_digit = num_in_str.charAt(i);
				max_digit_index = i;
				continue;
			}
			
			if(num_in_str.charAt(i) < max_digit) {
				l_index = i;
				r_index= max_digit_index;
			}
		}
		
		if(l_index == -1)
			System.out.println(number);
		
		num_in_str = swap(num_in_str, l_index, r_index);
		System.out.println(num_in_str);
	}
	

	private static void bruthForce(String number) {
		// TODO Auto-generated method stub
		String temp = number;

		for (int i = 0; i < number.length(); i++) {
			for (int j = i + 1; j < number.length(); j++) {

				number = swap(number, i, j);
				if (temp.compareTo(number) < 0)
					temp = number;

			}
		}
		System.out.println(temp);
	}

	private static String swap(String number, int i, int j) {
		// TODO Auto-generated method stub
		char[] ch = number.toCharArray();
		char temp = ch[i];
		ch[i] = ch[j];
		ch[j] = temp;

		return String.valueOf(ch);
	}

}
