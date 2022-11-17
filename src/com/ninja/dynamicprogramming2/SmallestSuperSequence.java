package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmallestSuperSequence {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException  {
		String str1 = br.readLine();
		String str2 = br.readLine();
		int min_len = SmallestSuperSequenceSol.smallestSuperSequence(str1, str2);
		System.out.print(min_len);
	}
}

class SmallestSuperSequenceSol {

	public static int smallestSuperSequence(String str1, String str2) {

		int[][] dp = new int[str1.length()+1][str2.length()+1];
		for(int i = 0;i<=str1.length();i++) {
			dp[i][str2.length()] = str1.length()-i;
		}
		for(int i = 0;i<=str2.length();i++) {
			dp[str1.length()][i] = str2.length()-i;
		}
		for (int i = str1.length()-1; i >=0; i--) {
			for (int j = str2.length()-1; j >=0; j--) {
				if(str1.charAt(i) == str2.charAt(j)) {
					System.out.println(str1.charAt(i)+" "+str2.charAt(j)+","+i+","+j);
					dp[i][j] = 1 + dp[i+1][j+1];
				}
				else {
					dp[i][j] = 1 + Math.min(dp[i][j+1], dp[i+1][j]);
				}
			}
		}

		//        for (int i = 0; i < dp.length; i++) {
		//			for (int j = 0; j < dp.length; j++) {
		//				System.out.print(dp[i][j]+ " ");
		//			}
		//			System.out.println();
		//		}
		return dp[0][0];
	}

}
