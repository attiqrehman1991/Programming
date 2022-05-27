package com.test.programming.faang;

public class Test {

    public static void main(String[] args) {
        System.out.println("DDG");
    }

    public boolean canJum(int[] nums) {
        int lastGoodIndex = nums.length - 1;

        for(int i = nums.length-1; i>=0; i--) {
            if(i + nums[i] >= lastGoodIndex)
                lastGoodIndex = i;
        }

        return lastGoodIndex == 0;
    }
}
