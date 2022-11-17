package com.ninja.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinTower {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		String[] strNums = br.readLine().trim().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int x = Integer.parseInt(strNums[1]);
		int y = Integer.parseInt(strNums[2]);

		System.out.println(CoinTowerSol.findWinner(n, x, y));
	}
}
class CoinTowerSol {

	public static String findWinner(int n, int x, int y) {
		//Your code goes here
		// Write your code here .
        int dp [] = new int[n+1];

        dp[1] = 1;

        int a1 = 0;
        int a2 = 0;
        int a3 = 0;

        for(int i=2;i<dp.length;i++){
            if(i == x || i == y){
                dp[i] = 1;
                continue;
                
            }

            if(i-x >= 1){
                a1 = dp[i-x] ^ 1;
            }
            if(i-y >= 1){
                a2 = dp[i-y] ^ 1;
            }

            a3 = dp[i-1] ^ 1;

            dp[i] = Math.max(a1 ,Math.max(a2 ,a3));
        }

        if(dp[n] != 0){
            return "Beerus";
        }else{
             return "Whis";
        }
	}

}