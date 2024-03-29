package com.ninja.hashmap.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {
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

	public static void printArray(int[] arr) {
		if(arr.length==0) {
			System.out.println("No sum pair found");
			return;
		}
		for (int element : arr) {
			System.out.print(element + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		int[] arr = takeInput();
		int k = Integer.parseInt(br.readLine());
		printArray(TwoSumSol.PairSum(arr,k));

	}
}

class TwoSumSol{
	public static int[] PairSum(int[] input, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0;i<input.length;i++) {
			int complement = k - input[i];
			if(map.containsKey(complement)) {
				return new int[] {map.get(complement),i};
			}
			map.put(input[i], i);
		}
		return new int[0];
	}
}
