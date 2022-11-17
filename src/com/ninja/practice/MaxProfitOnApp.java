package com.ninja.practice;

import java.util.Arrays;
import java.util.Scanner;

public class MaxProfitOnApp {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i=0;i<n;i++)
			input[i] = s.nextInt();
		
		System.out.println(MaxProfitOnAppSol.maximumProfit(input));
	}
}

class MaxProfitOnAppSol {

	public static int maximumProfit(int budget[]) {
		// Write your code here
		Arrays.sort(budget);
		int max = 0;
		int n = budget.length;
		for(int i:budget){
            if(max<i*n)
            	max = i*n;
            n--;
        }
		return max;
	}

}