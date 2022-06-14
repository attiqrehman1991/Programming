package com.test.programming.numbers;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( generate(5) );
	}
	
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(numRows == 0) {
            return output;
        }
        
        List<Integer> tempRow = new ArrayList<Integer>();
        tempRow.add(1);
        output.add(tempRow);
                
        for(int i=1; i<numRows; i++) {
        	tempRow = new ArrayList<Integer>();
            tempRow.add(1);
            
            for(int j = 1; j <i; j++) {
               tempRow.add( output.get(i-1).get(j-1) + output.get(i-1).get(j) );
            }
            
            tempRow.add(1);
            output.add(tempRow);
        }
        
        return output;
    }

}
