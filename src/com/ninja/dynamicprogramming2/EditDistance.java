/*Edit Distance
Send Feedback
You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
1. Delete a character
2. Replace a character with another one
3. Insert a character
Note :
Strings don't contain spaces in between.
 Input format :
The first line of input contains the string S of length M.

The second line of the input contains the String T of length N.
Output format :
Print the minimum 'Edit Distance' between the strings.
Constraints :
0 <= M <= 10 ^ 3
0 <= N <= 10 ^ 3

Time Limit: 1 sec
Sample Input 1 :
abc
dc
Sample Output 1 :
2
 Explanation to the Sample Input 1 :
 In 2 operations we can make string T to look like string S.
First, insert character 'a' to string T, which makes it "adc".

And secondly, replace the character 'd' of string T with 'b' from the string S. This would make string T as "abc" which is also string S. 

Hence, the minimum distance.
Sample Input 2 :
whgtdwhgtdg
aswcfg
Sample Output 2 :
9*/
package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditDistance {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {

		String s = br.readLine().trim();
		String t = br.readLine().trim();


		System.out.println(EditDistanceSol.editDistance(s, t));
	}
}


class EditDistanceSol {

	public static int editDistance(String s, String t) {

		int m = s.length();
		int n = t.length();

		int[][] dp = new int[m+1][n+1];
		//Top Down
		//		dp[0][0] = 0;
		//		for(int i = 1;i<=m; i++) {
		//			dp[0][i] = i;
		//		}
		//		for(int i = 1;i<=n; i++) {
		//			dp[i][0] = i;
		//		}
		//		for(int i = 1;i<=m;i++) {
		//			for(int j = 1;j<=n;j++) {
		//				if(s.charAt(m-i) == t.charAt(n-j)) {
		//					dp[i][j] = dp[i-1][j-1];
		//				}
		//				else{
		//					dp[i][j]=1+Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1]);
		//				}
		//			}
		//		}
		//		return dp[m][n];
		//Bottom Up
		dp[m][n] = 0;
		for(int i = 0;i<m; i++) {
			dp[i][n] = m-i;
		}

		for(int i = 0;i<n; i++) {
			dp[m][i] = n-i;
		}

		for(int i = m-1;i>=0;i--) {
			for(int j = n-1;j>=0;j--) {
				if(s.charAt(i) == t.charAt(j)) {
					dp[i][j] = dp[i+1][j+1];
				}
				else{
					dp[i][j]=1+Math.min(Math.min(dp[i+1][j],dp[i][j+1]),dp[i+1][j+1]);
				}
			}
		}
		return dp[0][0];
	}

	public static int editDistance2(String s1, String s2){
		int m=s1.length();
		int n=s2.length();
		int storage	[][]=new int [m+1][n+1];
		for(int i=0;i<=m;i++){
			for(int j=0;j<=n;j++){
				storage[i][j]=-1;
			}
		}
		return editDistance(s1,s2,storage);
	}
	private static int editDistance(String s1,String s2,int storage[][]){
		int m=s1.length();
		int n=s2.length();
		if(m==0 && n==0){
			storage[m][n]=0;
			return storage[m][n];}
		if(m==0){
			storage[m][n]=n;
			return storage[m][n];}
		if(n==0){
			storage[m][n]=m;
			return storage[m][n];}
		if(storage[m][n]!=-1)
			return storage[m][n];
		else{
			if(s1.charAt(0)==s2.charAt(0))
				return editDistance(s1.substring(1),s2.substring(1),storage);
			else{
				//insert
				int op1=editDistance(s1,s2.substring(1),storage);
				//delete
				int op2=editDistance(s1.substring(1),s2,storage);
				//sustitute
				int op3=editDistance(s1.substring(1),s2.substring(1),storage);
				storage[m][n]=1+Math.min(op1,Math.min(op2,op3));
			}

		}
		return storage[m][n];
	}


}