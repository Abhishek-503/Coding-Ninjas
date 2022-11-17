/*Min Cost Path Problem
Send Feedback
An integer matrix of size (M x N) has been given. Find out the minimum cost to reach from the cell (0, 0) to (M - 1, N - 1).
From a cell (i, j), you can move in three directions:
1. ((i + 1),  j) which is, "down"
2. (i, (j + 1)) which is, "to the right"
3. ((i+1), (j+1)) which is, "to the diagonal"
The cost of a path is defined as the sum of each cell's values through which the route passes.
 Input format :
The first line of the test case contains two integer values, 'M' and 'N', separated by a single space. They represent the 'rows' and 'columns' respectively, for the two-dimensional array/list.

The second line onwards, the next 'M' lines or rows represent the ith row values.

Each of the ith row constitutes 'N' column values separated by a single space.
Output format :
Print the minimum cost to reach the destination.
Constraints :
1 <= M <= 10 ^ 2
1 <= N <=  10 ^ 2

Time Limit: 1 sec
Sample Input 1 :
3 4
3 4 1 2
2 1 8 9
4 7 8 1
Sample Output 1 :
13
Sample Input 2 :
3 4
10 6 9 0
-23 8 9 90
-200 0 89 200
Sample Output 2 :
76
Sample Input 3 :
5 6
9 6 0 12 90 1
2 7 8 5 78 6
1 6 0 5 10 -4 
9 6 2 -10 7 4
10 -2 0 5 5 7
Sample Output 3 :
18*/
package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinCostPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[][] take2DInput() throws IOException {
		String[] strRowsCols = br.readLine().trim().split("\\s");
		int mRows = Integer.parseInt(strRowsCols[0]);
		int nCols = Integer.parseInt(strRowsCols[1]);

		if (mRows == 0) {
			return new int[0][0];
		}


		int[][] mat = new int[mRows][nCols];

		for (int row = 0; row < mRows; row++) {
			String[] strNums; 
			strNums = br.readLine().trim().split("\\s");

			for (int col = 0; col < nCols; col++) {
				mat[row][col] = Integer.parseInt(strNums[col]);
			}
		}

		return mat;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		int[][] mat = take2DInput();
		System.out.println(MinCostPathSol.minCostPath(mat));
	}
}

class MinCostPathSol {

	public static int minCostPath(int[][] input) {
		//Your code goes here
		int[][] dp = new int[input.length+1][input[0].length+1];
		for (int i=0;i<dp.length;i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MIN_VALUE;
			}
		}
//		return helperRec(input, 0, 0);
//		return helperMemo(input, 0, 0, dp);
//		return helperIter(input);
		return helperTopDown(input);
		
	}

	private static int helperTopDown(int[][] input) {
		int[][] dp = new int[input.length+1][input[0].length+1];
		for (int i=0;i<dp.length;i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		int m = input.length;
		int n = input[0].length;
		for(int i = 1;i<=m;i++) {
			for(int j = 1;j<=n;j++) {
				if(i==1 && j==1) {
					dp[i][j] = input[0][0];
					continue;
				}
				int ans1 = dp[i-1][j];
				int ans2 = dp[i-1][j-1];
				int ans3 = dp[i][j-1];
				dp[i][j] = input[i-1][j-1] + Math.min(ans1, Math.min(ans2, ans3));
			}
		}
		return dp[m][n];
	}

	private static int helperIter(int[][] input) {
		// TODO Auto-generated method stub

		int[][] dp = new int[input.length+1][input[0].length+1];
		for (int i=0;i<dp.length;i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		int m = input.length;
		int n = input[0].length;
		for(int i = m-1;i>=0;i--) {
			for(int j = n-1;j>=0;j--) {
				if(i==m-1 && j==n-1) {
					dp[i][j] = input[i][j];
					continue;
				}
				int ans1 = dp[i][j+1];
				int ans2 = dp[i+1][j];
				int ans3 = dp[i+1][j+1];
				dp[i][j] = input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
			}
		}
		return dp[0][0];
	}

	private static int helperRec(int[][] input, int i, int j){
		int m = input.length;
		int n = input[0].length;
		if(i==m-1 && j==n-1){
			return input[i][j];
		}

		if(i>=m || j>=n){
			return Integer.MAX_VALUE;
		}

		int ans1 = helperRec(input, i, j+1);
		int ans2 = helperRec(input, i+1, j+1);
		int ans3 = helperRec(input, i+1, j);

		int myAns = input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
		return myAns;
	}
	
	private static int helperMemo(int[][] input, int i, int j, int[][] dp){
		int m = input.length;
		int n = input[0].length;
		if(i==m-1 && j==n-1){
			return input[i][j];
		}

		if(i>=m || j>=n){
			return Integer.MAX_VALUE;
		}

		int ans1,ans2,ans3;
		if(dp[i][j+1] == Integer.MIN_VALUE) {
			ans1 = helperMemo(input, i, j+1, dp);
			dp[i][j+1] = ans1;
		}
		else {
			ans1 = dp[i][j+1];
		}
		if(dp[i+1][j+1] == Integer.MIN_VALUE) {
			ans2 = helperMemo(input, i+1, j+1, dp);
			dp[i+1][j+1] = ans2;
		}
		else {
			ans2 = dp[i+1][j+1];
		}
		if(dp[i+1][j] == Integer.MIN_VALUE) {
			ans3 = helperMemo(input, i+1, j, dp);
			dp[i+1][j] = ans3;
		}
		else {
			ans3 = dp[i+1][j];
		}

		int myAns = input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
		return myAns;
	}
	
	
}