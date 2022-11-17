package com.ninja.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StariCase {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(StariCaseSol.staircase(n));
    }
}

class StariCaseSol {
	
	public static long staircase(int n) {
		//Your code goes here
		long[] dp = new long[n];
        if(n>1){
            dp[0] = dp[1] = 1L;
			return helper(n, dp);
        }
		return n;
	}
	
	public static long helper(int n, long[] dp) {
		//Your code goes here
		if(n<0) {
			return 0L;
		}	
	    long ans1=0L,ans2=0L,ans3=0L;
	    if(n-1 >=0 && dp[n-1]==0L){
	        ans1 = helper(n-1, dp);
	        dp[n-1] = ans1;
	    }
	    else if(n-1 >=0){
	        ans1 = dp[n-1];
	    }
	    
	    if(n-2 >=0 && dp[n-2]==0L){
	        ans2 = helper(n-2, dp);
	        dp[n-2] = ans2;
	    }
	    else if(n-2 >=0){
	        ans2 = dp[n-2];
	    }
	    
	    if(n-3 >=0 && dp[n-3]==0L){
	        ans3 = helper(n-3, dp);
	        dp[n-3] = ans3;
	    }
	    else if(n-3 >=0){
	        ans3 = dp[n-3];
	    }
	    
	    return ans1 + ans2 + ans3;
	    
	    
	    
	    
	    
	    
	    
	    
	}
	
}