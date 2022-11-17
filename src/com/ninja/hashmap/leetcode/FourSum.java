package com.ninja.hashmap.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FourSum {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[] takeInput() throws IOException {
		int size = Integer.parseInt(br.readLine().trim());
		int[] input = new int[size];

		if (size == 0) {
			return input;
		}

		String[] strNums;
		strNums = br.readLine().split("\\s");

		for (int i = 0; i < size; ++i) {
			input[i] = Integer.parseInt(strNums[i]);
		}

		return input;
	}

	public static void printArray(List<List<Integer>> arr) {
		if(arr.size()==0) {
			System.out.println("No Quadraple found");
			return;
		}
		for (List<Integer> element : arr) {
			System.out.println(element);
		}

		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		int[] arr = takeInput();
		int k = Integer.parseInt(br.readLine());
		printArray(FourSumSol.fourSum(arr,k));

	}

}

class FourSumSol{

	public static List<List<Integer>> fourSum(int[] arr, int k) {
		if(arr==null || arr.length<4) {
			return Collections.emptyList();
		}
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		int n = arr.length;
		Arrays.sort(arr);
		for(int i=0;i<n-3;i++) {
			if(i>0 && (arr[i]==arr[i-1])) {
				continue;
			}
			for(int j = i+1;j<n-2;j++) {
				if(j>i+1 && (arr[j]==arr[j-1])) {
					continue;
				}
				int newSum = k - arr[i] - arr[j];
				int lo = j+1;
				int hi = n-1;
				while(lo<hi) {
					if(lo > j+1 && arr[lo]==arr[lo-1]) {
						lo++;
						continue;
					}
					if(hi < n-1 && arr[hi]==arr[hi+1]) {
						hi--;
						continue;
					}
					int sum = arr[lo]+arr[hi];
					if(sum < newSum) {
						lo++;
					}
					else if(sum > newSum) {
						hi--;
					}
					else {
						list.add(Arrays.asList(arr[i], arr[j], arr[lo], arr[hi]));
						lo++;
						hi--;
					}
				}
			}
		}
		return list;
	}
	
}
