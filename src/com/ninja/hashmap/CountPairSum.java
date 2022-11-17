package com.ninja.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class CountPairSum {
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
		for (int element : arr) {
			System.out.print(element + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		int[] arr = takeInput();
		System.out.print(CountPairSumSol.PairSum(arr,arr.length));


	}
}

class CountPairSumSol {
	public static int PairSum(int[] input, int size) {
		HashMap<Integer,Integer> map = new HashMap<>();
		int ans = 0;
        for(int i = 0;i<input.length;i++){
            if(map.containsKey(input[i])) {
            	map.put(input[i], map.get(input[i])+1);
            }
            else {
            	map.put(input[i], 1);
            }
        }
		for(int i : map.keySet()) {
			if(i!=0) {
				if(map.containsKey(-i)) {
					ans += map.get(i)*map.get(-i);
				}
			}
			else {
				ans += map.get(i)*(map.get(i)-1);
			}
		}
        return ans/2;
	}
}
