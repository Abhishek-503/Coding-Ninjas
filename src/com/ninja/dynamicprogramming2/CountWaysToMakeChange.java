/*Ways To Make Coin Change
Send Feedback
For the given infinite supply of coins of each of denominations, D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make the change for Value V using coins of denominations D.
Return 0 if the change isn't possible.
Input Format
The first line of the input contains an integer value N, which denotes the total number of denominations.

The second line of input contains N values, separated by a single space. These values denote the value of denomination.

The third line of the input contains an integer value, that denotes the value of V.
Output Format
Print the total total number of ways i.e. W.
Constraints :
1 <= n <= 10
1 <= V <= 1000

Time Limit: 1sec
Sample Input 1 :
3
1 2 3
4
Sample Output 1 :
4
Explanation to Sample Input 1 :
Number of ways are - 4 total i.e. (1,1,1,1), (1,1, 2), (1, 3) and (2, 2).
Sample Input 2 :
6
1 2 3 4 5 6
250
Sample Output 2 :
13868903*/
package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class CountWaysToMakeChange {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {

		int numDenominations = Integer.parseInt(br.readLine().trim());

		int denominations[] = new int[numDenominations];
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < numDenominations; ++i) {
            denominations[i] = Integer.parseInt(strNums[i]);
        }
		int value = Integer.parseInt(br.readLine().trim());

		
		System.out.println(CountWaysToMakeChangeSol.countWaysToMakeChange(denominations, value));
		
	}

}

class CountWaysToMakeChangeSol {

	
	public static int countWaysToMakeChange(int coins[], int value){
        // Write your code here
		int cols = value;
        int rows = coins.length;

        int[][] matrix = new int[rows+1][cols+1];

        for(int i=0; i <= rows; i++){
            matrix[i][0] = 1;
        }
        for(int i=0; i <= cols; i++){
            matrix[0][i] = 0;
        }

        for(int i=1; i <= rows; i++){
            for(int j=1; j <=cols; j++){
                if(j >= coins[i-1]){
                    matrix[i][j] = (matrix[i-1][j])+(matrix[i][j-coins[i-1]]);
                }else{
                    matrix[i][j] = matrix[i-1][j];
                }
            }
        }

//        for(int i=0; i <= rows; i++) {
//            for (int j = 0; j <= cols; j++) {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
        return matrix[rows][cols];
		
	}
	
}