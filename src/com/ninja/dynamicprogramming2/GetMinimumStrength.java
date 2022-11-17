package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GetMinimumStrength {
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

		int t = Integer.parseInt(br.readLine().trim());
		while (t!=0){
			int[][] grid = takeInput();
			System.out.println(GetMinimumStrengthSol.getMinimumStrength(grid));
			t--;
		}

	}
}

class GetMinimumStrengthSol{


	public static int getMinimumStrength(int[][] grid) {

        int row=grid.length;
		if (row==0)
            return row;
        
        int col=grid[0].length;
        if (col==0)
            return col;
        
        int[][] dp=new int[row][col];
        dp[row-1][col-1]=1;
        
        for (int i=col-2;i>=0;i--)
        {
        	dp[row-1][i]=dp[row-1][i+1]-grid[row-1][i];
            
        }
        for (int i=row-2;i>=0;i--)
        {
            dp[i][col-1]=dp[i+1][col-1]-grid[i][col-1];
        }
        
        for (int i = row-2; i >=0 ; i--) {
			for (int j = col-2; j >=0; j--) {
				int ans1=dp[i+1][j];
                int ans2=dp[i][j+1];
                
                dp[i][j]=Math.max(1,Math.min(ans1,ans2)-grid[i][j]);
			}
		}
        
        for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + " ");
			}
			System.out.println();
		}
		return 2;
	}
}
