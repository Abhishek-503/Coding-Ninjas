package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindMaxSquareWithAllZeros {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static int[][] takeInput() throws IOException {

		String[] nm;
		nm = br.readLine().split("\\s");
		int n = Integer.parseInt(nm[0]);
		int m = Integer.parseInt(nm[1]);
		int arr[][]=new int[n][m];

		if (n == 0) {
			return arr;
		}


		String[] strNums;
		for (int i = 0; i < n; ++i) {            
			strNums = br.readLine().split("\\s");
			for (int j = 0; j < m; ++j){
				arr[i][j] = Integer.parseInt(strNums[j]);
			}

		}

		return arr;
	}

	public static void main(String[] args) throws IOException {

		int[][] arr = takeInput();
		System.out.println(FindMaxSquareWithAllZerosSol.findMaxSquareWithAllZeros(arr));
	}
}

class FindMaxSquareWithAllZerosSol {


	public static int findMaxSquareWithAllZeros(int[][] input){

		int row = input.length;
		int col = input[0].length;
		for (int i=0;i<row;i++)
		{ 
			for (int j=0;j<col;j++) {
				if (input[i][j]==1)
					input[i][j]=0; 
				else 
					input[i][j]=1;
			}		
		}
		int max=0;
		for (int i=1;i<row;i++)
		{  
			for (int j=1;j<col;j++)
			{    
				if (input[i][j]==0) 
					continue;
				input[i][j]=Math.min(input[i-1][j],Math.min(input[i-1][j-1],input[i][j-1]))+1;
				if (max<input[i][j]) 
					max=input[i][j];
			}
		}

		return max; 
	}


}
