package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongCommonSub {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		String s = br.readLine().trim();
		String t = br.readLine().trim();


		System.out.println(LongCommonSubSol.lcs(s, t));
	}
}

class LongCommonSubSol {

	public static int lcs(String s, String t) {
		int dp[][] = new int[s.length()+1][t.length()+1];
		for(int i = 0;i<dp.length;i++) {
			for (int j = 0; j < dp[0].length; j++) {
				dp[i][j] = -1;
			}
		}
		return LcsIter(s, t);
//		return lcsMemo(s, t, 0, 0, dp);
		//		return lcsRecur(s, t, 0, 0);
	}
	private static int lcsMemo(String str1, String str2, int i, int j, int[][] dp) {
		// TODO Auto-generated method stub
		if(i==str1.length() ||  j==str2. length()) {
			return 0;
		}

		int myAns;
		if(str1.charAt(i) == str2.charAt(j)) {
			int smallAns;
			if(dp[i+1][j+1]==-1) {
				smallAns = lcsMemo(str1,str2, i+1, j+1, dp);
				dp[i+1][j+1] = smallAns;
			}
			else {
				smallAns = dp[i+1][j+1];
			}
			myAns = 1 + smallAns;
		}else{
			int ans1,ans2;
			if(dp[i+1][j]==-1) {
				ans1 = lcsMemo(str1,str2, i+1, j, dp);
				dp[i+1][j] = ans1;
			}
			else {
				ans1 = dp[i+1][j];
			}
			if(dp[i][j+1]==-1) {
				ans2 = lcsMemo(str1,str2, i, j+1, dp);
				dp[i][j+1] = ans2; 
			}
			else {
				ans2 = dp[i][j+1];
			}
			myAns = Math.max (ans1, ans2);

		}

		return myAns;
	}
	public static int lcsRecur(String s, String t) {
		//Your code goes here
		if(s.length()==0 || t.length()==0){
			return 0;
		}
		if(s.charAt(0)==t.charAt(0)){
			return 1+lcsRecur(s.substring(1),t.substring(1));
		}
		else{
			return Math.max(lcsRecur(s, t.substring(1)),lcsRecur(s.substring(1), t));
		}
	}

	public static int lcsHelper (String str1, String str2, int i, int j) {

		if(i==str1.length() ||  j==str2. length()) {
			return 0;
		}

		int myAns;
		if(str1.charAt(i) == str2.charAt(j)) {


			int smallAns = lcsHelper(str1,str2, i+1, j+1);
			myAns = 1 + smallAns;

		}else{

			int ans1 = lcsHelper(str1, str2, i+1,j);
			int ans2 = lcsHelper(str1, str2, i, j+1);
			myAns = Math.max (ans1, ans2);

		}

		return myAns;
	}

	public static int LcsIter(String str1, String str2) {

		int m = str1.length();
		int n = str2.length();

		int[][] dp = new int[m+1][n+1];

		for(int i=m-1; i>=0; i--) {
			for(int j=n-1; j>=0; j--) {

				int ans;
				if(str1.charAt(i) == str2.charAt(j)) {
					ans = 1 + dp[i+1] [j+1];
				}else {
					int ans1 = dp[i][j+1]; 
					int ans2 = dp[i+1][j];
					ans = Math.max(ans1,ans2);
				}
				dp[i][j] = ans;
			}
		}
		return dp[0][0];
	}

}