/*Return subsets sum to K
Send Feedback
Given an array A of size n and an integer K, return all subsets of A which sum to K.
Subsets are of length varying from 0 to n, that contain elements of the array. But the order of elements should remain same as in the input array.
Note : The order of subsets are not important.
Input format :
Line 1 : Integer n, Size of input array
Line 2 : Array elements separated by space
Line 3 : K 
Constraints :
1 <= n <= 20
Sample Input :
9 
5 12 3 17 1 18 15 3 17 
6
Sample Output :
3 3
5 1*/
package com.ninja.recursion3;

import java.util.Scanner;

public class ReturnSubsetsSumToK {
	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		int output[][] = ReturnSubsetsSumToKSol.subsetsSumK(input, k);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}
}
class ReturnSubsetsSumToKSol {

	// Return a 2D array that contains all the subsets which sum to k
	public static int[][] subsetsSumK(int input[], int p) {
		// Write your code here
		return subsetsSumK2(input, p, 0);

	}
	
	public static int[][] subsetsSumK2(int[] input, int p, int start){
		//Base Condition when start equals input.length
		if(start == input.length) {
			//if sum is 0 which means we found the series where sum leads to 0.
			if(p == 0)
				return new int[1][0];
			else
				return new int[0][0];
		}
		
		int startValue = input[start];
		int[][] smallOp1 = subsetsSumK2(input, p, start+1);
		int[][] smallOp2 = subsetsSumK2(input, p - startValue, start+1);
		int[][] sol = new int[smallOp1.length + smallOp2.length][];
		
		int k = 0;
		for(int i = 0;i<smallOp1.length;i++) {
			sol[k] = smallOp1[i];
			k++;
		}
		
		for(int i = 0;i<smallOp2.length;i++) {
			sol[k] = new int[smallOp2[i].length+1];
			sol[k][0] = startValue;
			for(int j = 0;j<smallOp2[i].length;j++) {
				sol[k][j+1] = smallOp2[i][j];
			}
			k++;
		}
		return sol;
	}	
	
	public static int[][] subsetsSumK(int[] input, int p, int start) {
		if (start == input.length) {
			if (p == 0) {
				return new int[1][0];
			}
			else {
				return new int[0][0];
			}
		}
		int cn=input[start];
		int[][] smallans1=subsetsSumK(input, p,start+1);
		int[][] smallans2=subsetsSumK(input, p-cn, start+1);

		int[][] myans=new int[smallans1.length+smallans2.length][];
		int k=0;
		for(int i=0;i<smallans1.length;i++){
			myans[k]=smallans1[i];
			k++;

		}
		for(int i=0;i<smallans2.length;i++){
			myans[k]=new int[smallans2[i].length+1];
			myans[k][0]=cn;
			for(int j=0;j<smallans2[i].length;j++){
				myans[k][j+1]=smallans2[i][j];
			}
			k++;
		}
		return myans;
	}
}
