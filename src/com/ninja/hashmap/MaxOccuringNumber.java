package com.ninja.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MaxOccuringNumber {

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
		System.out.println(MaxOccuringNumberSol.maxFrequencyNumber(arr));


	}
}

class MaxOccuringNumberSol {

	public static int maxFrequencyNumber(int[] arr){ 
		HashMap<Integer,Integer> map = new HashMap<>();
		int ans = Integer.MIN_VALUE;
		int max = 0;
		for(int i:arr){
			if(map.containsKey(i)) {
				map.put(i, map.get(i)+1);
			}
			else {
				map.put(i, 1);
			}
		}
		for(int i : arr) {
			if(map.get(i) > max) { 
				max = map.get(i);
				ans = i;
			}
		}
		return ans;
	}
	public static int maxFrequencyNumber2(int[] arr){
		HashMap<Integer, Integer> max = new HashMap<>();
		for(int i=0;i<arr.length;i++){
			if(max.containsKey(arr[i])){
				max.put(arr[i],max.get(arr[i])+1);
			}else{
				max.put(arr[i],1);
			}
		}

		int ma = 0,
				ans = Integer.MIN_VALUE;
		for(int i : arr) {
			if(max.get(i) > ma) { 
				ma = max.get(i);
				ans = i;
			}
		}
		return ans;
	}
}