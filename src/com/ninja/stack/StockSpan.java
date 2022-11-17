/*For example, if the price of a stock over a period of 7 days are [100, 80, 60, 70, 60, 75, 85], 
then the stock spans will be [1, 1, 1, 2, 1, 4, 6].*/
package com.ninja.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class StockSpan {
	 static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    public static int[] takeInput() throws NumberFormatException, IOException {
	    	int size = Integer.parseInt(br.readLine().trim());
	    	int[] input = new int[size];

	    	if (size == 0) {
	    		return input;
	    	}

	    	String[] values = br.readLine().trim().split(" ");

	    	for(int i = 0; i < size; i++) {
	    		input[i] = Integer.parseInt(values[i]);
	    	}

	    	return input;
	    }

	    public static void printArray(int[] arr) {
	    	for (int i = 0 ; i < arr.length; i++) {
	    		System.out.print(arr[i] + " ");
	    	}

	    	System.out.println();
	    }

	    public static void main(String[] args) throws NumberFormatException, IOException {
	    	int[] input = takeInput();

	    	int[] output = StockSpanSol.stockSpan(input);

	    	printArray(output);

	    }
}

class StockSpanSol {

	public static int[] stockSpan(int[] price) {
		//Your code goes here
		int[] S = new int[price.length];
		S[0] = 1;
		for (int i = 1; i < price.length; i++) {
            S[i] = 1; // Initialize span value
 
            // Traverse left while the next element on left is smaller
            // than price[i]
            for (int j = i - 1; (j >= 0) && (price[i] >= price[j]); j--)
                S[i]++;
        }
		return S;
	}

}