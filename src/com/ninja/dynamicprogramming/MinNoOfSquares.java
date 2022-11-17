package com.ninja.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinNoOfSquares {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(MinNoOfSquaresSol.minCount2(n));
    }
}
class MinNoOfSquaresSol {

	public static int minCount(int n) {
        int[] dp = new int[n+1];
        for(int i = 0;i<n;i++)
            dp[i] = -1;
		return helper(n,dp);
	}
	
	public static int minCount2(int n) {
        int[] dp = new int[n+1];
		for(int i = 1;i<=n;i++) {
			int myAns = Integer.MAX_VALUE;
			for(int j = 1;j*j<=i;j++) {
				int currAns = dp[i-(j*j)];
				if(myAns > currAns) {
					myAns = currAns;
				}
			}
			dp[i] = 1 + myAns;
		}
		return dp[n];
	}

    private static int helper(int n, int[] dp){
        if(n==0){
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        for(int i = 1;i*i<=n;i++){
            int currAns = 0;
            if(dp[n-(i*i)]==-1){
                currAns = helper(n-(i*i), dp);
                dp[n-(i*i)] = currAns;
            }
            else{
                 currAns = dp[n-(i*i)];
            }
            if(minAns > currAns)
                minAns = currAns;
        }
    	int ans = 1 +  minAns;
        return ans;
        
    }
}