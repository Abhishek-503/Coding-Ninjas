/*0 1 Knapsack - Problem
Send Feedback
A thief robbing a store can carry a maximal weight of W into his knapsack. There are N items, and i-th item weigh 'Wi' and the value being 'Vi.' What would be the maximum value V, that the thief can steal?
Input Format :
The first line of the input contains an integer value N, which denotes the total number of items.

The second line of input contains the N number of weights separated by a single space.

The third line of input contains the N number of values separated by a single space.

The fourth line of the input contains an integer value W, which denotes the maximum weight the thief can steal.
Output Format :
Print the maximum value of V that the thief can steal.
Constraints :
1 <= N <= 20
1<= Wi <= 100
1 <= Vi <= 100

Time Limit: 1 sec
Sample Input 1 :
4
1 2 4 5
5 4 8 6
5
Sample Output 1 :
13
Sample Input 2 :
5
12 7 11 8 9
24 13 23 15 16
26
Sample Output 2 :
51*/
package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class KnapSack {
	private int n;
	private int[] weights;
	private int[] values;
	private int maxWeight;

	public KnapSack(int[] weights, int[] values, int n, int maxWeight) {
		this.n = n;
		this.weights = weights;
		this.values = values;
		this.maxWeight = maxWeight;
	}

	public int getSize() {
		return this.n;
	}

	public int[] getWeights() {
		return this.weights;
	}

	public int[] getValues() {
		return this.values;
	}

	public int getMaxWeight() {
		return this.maxWeight;
	}
}

public class KnapSackProblem {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static KnapSack takeInput() throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine().trim());

		if (n == 0) {
			return (new KnapSack(new int[0], new int[0], 0, 0));
		}

		String[] strWeights = br.readLine().trim().split(" ");
		String[] strValues = br.readLine().trim().split(" ");
		int maxWeight = Integer.parseInt(br.readLine().trim());

		int[] weights = new int[n];
		int[] values = new int[n];

		for (int i = 0; i < n; i++) {
			weights[i] = Integer.parseInt(strWeights[i]);
			values[i] = Integer.parseInt(strValues[i]);
		}

		return (new KnapSack(weights, values, n, maxWeight));

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		KnapSack input = takeInput();

		int n = input.getSize();
		int[] weights = input.getWeights();
		int[] values = input.getValues();
		int maxWeight = input.getMaxWeight();


		System.out.println(KnapSackProblemSol.knapsack(weights, values, n, maxWeight));
	}
}

class KnapSackProblemSol {

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		//Your code goes here
//		return knapsackHelper(weights, values, n, maxWeight, 0);
		return knapsackI(maxWeight, values, weights);
	}

	private static int knapsackHelper(int[] weights, int[] values, int n, int maxWeight, int i) {
		// TODO Auto-generated method stub
		if(i==values.length) {
			return 0;
		}
		int ans;
		if(maxWeight >= weights[i]) {
			int ans1 = values[i] + knapsackHelper(weights, values, n, maxWeight-weights[i], i+1);
			int ans2 = knapsackHelper(weights, values, n, maxWeight, i+1);
			ans = Math.max(ans1, ans2);
		}
		else {
			ans = knapsackHelper(weights, values, n, maxWeight, i+1);
		}
		return ans;
	}

	public static int knapsackI(int W, int val[], int wt[])  {

		int n = val.length;
		int[][] dp = new int[n+1][W+1];

		for(int i=n-1; i>=0; i--) {
			for(int w=0;w<=W;w++) {

				int ans;
				if(wt[i] <= w) {
					int ans1 = val[i] + dp[i+1][w-wt[i]];
					int ans2 = dp[i+1][w];
					ans = Math.max(ans1, ans2);
				}else{
					ans = dp[i+1][w];
				}
				dp[i][w] = ans;
			}
		}

//		for(int i=0; i<=n; i++) {
//			for(int w=0;w<=W;w++) {
//				System.out.print(dp[i][w]+" ");
//			}
//			System.out.println();
//		}
		return dp[0][W];
	}

}