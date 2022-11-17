package com.ninja.dynamicprogramming2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class SubSetSum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void main(String[] args) throws NumberFormatException, IOException {
		int size = Integer.parseInt(br.readLine().trim());
		int[] input = new int[size];

		if (size == 0) {
			System.out.print("No");
			return;
		}

		String[] strNums;
		strNums = br.readLine().split("\\s");

		for (int i = 0; i < size; ++i) {
			input[i] = Integer.parseInt(strNums[i]);
		}

		int sum = Integer.parseInt(br.readLine().trim());
		if (SubSetSumSol.isSubsetPresent(input, size, sum)) {
			System.out.print("Yes");
		} else {
			System.out.print("No");
		}
		SubSetSumSol.subsetSumHelper(input, sum);
	}
}

class SubSetSumSol {

	static boolean isSubsetPresent(int[] A, int n, int k) {

		// `T[i][j]` stores true if subset with sum `j` can be attained
		// using items up to first `i` items
		boolean[][] T = new boolean[n + 1][k + 1];

		// if the sum is zero
		for (int i = 0; i <= n; i++) {
			T[i][0] = true;
		}

		// do for i'th item
		for (int i = 1; i <= n; i++)
		{
			// consider all sum from 1 to sum
			for (int j = 1; j <= k; j++)
			{
				if(A[i-1] > j) {
					T[i][j] = T[i-1][j];
				}
				else {
					T[i][j] = T[i-1][j] || T[i-1][j-A[i-1]];
				}
			}
		}

		return T[n][k];

	}
	/*
	 * SOLUTION - 1 
	 * static int subset_count = 0; static boolean
	 * isSubsetPresent(int[] arr, int n, int sum) { subset_sum(arr, 0, 0, sum);
	 * if(subset_count>0) return true; else return false;
	 * 
	 * }
	 * 
	 * static void subset_sum(int list[], int sum, int starting_index, int
	 * target_sum) { if( target_sum == sum ) { subset_count++; if(starting_index <
	 * list.length) subset_sum(list, sum - list[starting_index-1], starting_index,
	 * target_sum); } else { for( int i = starting_index; i < list.length; i++ ) {
	 * subset_sum(list, sum + list[i], i + 1, target_sum); } } }
	 */

	/* SOLUTION - 2
	 * static boolean isSubsetPresent(int[] arr, int n, int sum) {
	 * 
	 * Your class should be named Solution Don't write main(). Don't read input, it
	 * is passed as function argument. Return output and don't print it. Taking
	 * input and printing output is handled automatically.
	 * 
	 * return isSubsetPresentHelper(arr,n-1,sum); } static boolean
	 * isSubsetPresentHelper(int[] arr, int n, int sum) { if (sum == 0) { return
	 * true; }
	 * 
	 * // base case: no items left, or sum becomes negative if (n < 0 || sum < 0) {
	 * return false; }
	 * 
	 * // Case 1. Include the current item `A[n]` in the subset and recur // for the
	 * remaining items `n-1` with the remaining total `k-A[n]` boolean include =
	 * isSubsetPresentHelper(arr, n - 1, sum - arr[n]);
	 * 
	 * // Case 2. Exclude the current item `A[n]` from the subset and recur for //
	 * the remaining items `n-1` boolean exclude = isSubsetPresentHelper(arr, n - 1,
	 * sum);
	 * 
	 * // return true if we can get subset by including or excluding the // current
	 * item return include || exclude;
	 * 
	 * }
	 */

	public static boolean subsetSum(int[] A, int n, int k, Map<String, Boolean> lookup)
	{
		// return true if the sum becomes 0 (subset found)
		if (k == 0) {
			return true;
		}

		// base case: no items left, or sum becomes negative
		if (n < 0 || k < 0) {
			return false;
		}

		// construct a unique map key from dynamic elements of the input
		String key = n + "|" + k;

		// if the subproblem is seen for the first time, solve it and
		// store its result in a map
		if (!lookup.containsKey(key))
		{
			// Case 1. Include the current item `A[n]` in the subset and recur
			// for the remaining items `n-1` with the decreased total `k-A[n]`
			boolean include = subsetSum(A, n - 1, k - A[n], lookup);

			// Case 2. Exclude the current item `A[n]` from the subset and recur for
			// the remaining items `n-1`
			boolean exclude = subsetSum(A, n - 1, k, lookup);

			// assign true if we get subset by including or excluding
			// current item
			lookup.put(key, include || exclude);
		}

		// return solution to the current subproblem
		return lookup.get(key);
	}

	public static void subsetSumHelper(int[] A, int k)
	{

		// create a map to store solutions to subproblems
		Map<String, Boolean> lookup = new HashMap<>();

		if (subsetSum(A, A.length - 1, k, lookup)) {
			System.out.println(",Subsequence with the given sum exists");
		}
		else {
			System.out.println(",Subsequence with the given sum does not exist");
		}
	}
}
