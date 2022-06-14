package com.test.programming.numbers;
class GFG {
 
    // Function to find the maximum value
    // of N after inserting the digit K
public static void maximizeNumber(int N, int K)
{
    // Convert it into N to string
    String s = Integer.toString(N);
    int L = s.length();
 
    // Stores the maximum value of N
    // after inserting K
    String result =  "";
    int i = 0;
 
    // Iterate till all digits that
    // are not less than K
    while ((i < L) && (K <= ((int)s.charAt(i) - (int)'0'))) {
 
        // Add the current digit to
        // the string result
        result += (s.charAt(i));
        ++i;
    }
 
    // Add digit 'K' to result
    result += ((char)(K + (int)'0'));
 
    // Iterate through all remaining
    // characters
    while (i < L) {
 
        // Add current digit to result
        result += (s.charAt(i));
        ++i;
    }
 
    // Print the maximum number formed
    System.out.println(result);
}
 
public static String maxValue(String n, int x) {
    StringBuffer res = new StringBuffer(n);
    int i;
    //For positive value
    if(n.charAt(0) != '-')
    {
        i = 0; 
        while(i < n.length() && x <= (n.charAt(i)-'0'))
            i++;           
    }
    else
    {
        //for negative value
        i = 1; //starting from 1 as first character is -
        while(i < n.length() && x >= (n.charAt(i)-'0'))
            i++;
    }
    res.insert(i, x);
    return res.toString();
}

    // Driver Code
    public static void main (String args[]) {
        int N = 926, K = 5;
        maximizeNumber(N, K);
        System.out.println( maxValue("999", 5));
    }
 
}