package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinChocolate {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[] takeInput() throws IOException {
		int size = Integer.parseInt(br.readLine().trim());
		int[] input = new int[size];

		if (size == 0) {
			return input;
		}

		String[] strNums;
		strNums = br.readLine().split("\\s");

		for (int i = 0; i < size; ++i) {
			input[i] = Integer.parseInt(strNums[i]);
		}

		return input;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {


		int[] arr = takeInput();
		System.out.print(MinChocolateSol.getMin(arr,arr.length));


	}
}

class MinChocolateSol {

	public static int getMin(int arr[], int N){
		int dp[] = new int[arr.length];
		
		dp[0] = 1;
		int sum = 0;
		for (int i = 1; i < dp.length; i++) {
			if(arr[i]>arr[i-1]) {
				dp[i] = dp[i-1] + 1;
			}
			else {
				dp[i] = 1;
			}
		}
		
		for (int i = arr.length-2; i >=0; i--) {
			if(arr[i]>arr[i+1] && dp[i]<=dp[i+1]){
	            dp[i]=dp[i+1]+1;
	        }
		}

		for (int i = 0; i < dp.length; i++) {
			sum = sum+dp[i];
		}
		return sum;
	}
}