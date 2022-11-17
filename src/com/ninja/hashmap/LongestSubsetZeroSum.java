/*Longest subset zero sum
Send Feedback
Given an array consisting of positive and negative integers, find the length of the longest subarray whose sum is zero.
Input Format:
The first line of input contains an integer, that denotes the value of the size of the array. Let us denote it with the symbol N.
The following line contains N space separated integers, that denote the value of the elements of the array.
Output Format
The first and only line of output contains length of the longest subarray whose sum is zero.
Constraints:
0 <= N <= 10^8
Time Limit: 1 sec
Sample Input 1:
10 
 95 -97 -387 -435 -5 -70 897 127 23 284
Sample Output 1:
5
Explanation:
The five elements that form the longest subarray that sum up to zero are: -387, -435, -5, -70, 897 */
package com.ninja.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class LongestSubsetZeroSum {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(LongestSubsetZeroSumSol.lengthOfLongestSubsetWithZeroSum(arr));
	}
}

class LongestSubsetZeroSumSol {

	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
//		HashMap<Integer, Integer> map = new HashMap<>();
//		int[] sum = new int[arr.length];
//		sum[0] = arr[0];
//		map.put(sum[0], 0);
//		int start = -1, end = -1;
//		for(int i = 1 ; i<sum.length;i++){
//			sum[i] = sum[i-1]+arr[i];
//			map.put(sum[i],i);
//		}
//		for(int i = 0;i<sum.length;i++){
//			if(map.get(sum[i])>i && (map.get(sum[i])-i > end - start || start == -1)){
//				start = i;
//				end = map.get(sum[i]);
//			}
//		}
//		if(map.get(0)!=null&&(start==-1||map.get(0)> end - start ||(map.get(0)== end - start
//				-1 && start >0))){
//			start = -1;
//			end = map.get(0);
//		}
//		return (end - start);
		HashMap<Integer, Integer> map = new HashMap<>();
		int len = 0;
		for(int i = 1 ; i<arr.length;i++){
			arr[i] += arr[i-1];
		}
		
		for(int i = 0 ; i<arr.length;i++){
			System.out.println(arr[i]);
		}
		for(int i = 0;i<arr.length;i++){
			if(arr[i]==0) {
				if(len < i+1) {
					len = i+1;
				}
			}
			else if(map.containsKey(arr[i])) {
				if(len < (i - map.get(arr[i]))) {
					len = i - map.get(arr[i]);
				}
			}
			else {
				map.put(arr[i], i);
			}
		}

		return len;
	}
}