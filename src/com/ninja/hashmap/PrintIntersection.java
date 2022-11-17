package com.ninja.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class PrintIntersection {
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


		int[] arr1 = takeInput();
		int[] arr2 = takeInput();
		PrintIntersectionSol.printIntersection(arr1,arr2);


	}
}

class PrintIntersectionSol {

	public static void printIntersection(int[] arr1,int[] arr2){
		HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<arr1.length;i++){
            if(map.containsKey(arr1[i])) {
            	map.put(arr1[i], map.get(arr1[i])+1);
            }
            else {
            	map.put(arr1[i], 1);
            }
        }
        
        for(int i = 0;i<arr2.length;i++){
            if(map.containsKey(arr2[i])) {
            	int freq = map.get(arr2[i]);
            	if(freq > 0) {
            		System.out.println(arr2[i]);
            		map.put(arr2[i], freq-1);
            	}
            }
        }

	}
}
