package com.ninja.hashmap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class LongConsecutiveSeq {
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

	public static void printArray(ArrayList<Integer> arr) {
		for (int element : arr) {
			System.out.print(element + " ");
		}

		System.out.println();
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		int[] arr = takeInput();
		ArrayList<Integer> ans = LongConsecutiveSeqSol.longestConsecutiveIncreasingSequence(arr);
		printArray(ans);

	}
}

class LongConsecutiveSeqSol {
	
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0;i<arr.length;i++) {
			map.put(arr[i], i);
		}
		ArrayList<Integer> arrList = new ArrayList<>();
		for(Integer i:map.keySet()) {
			arrList.add(i);
		}

		ArrayList<ArrayList<Integer>> tracker = new ArrayList<>();
		int count = 1;
		for(Integer j : arrList) {
			if(count>1) {
				count--;
				continue;
			}
			int k = j+1;
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(j);
			while(map.containsKey(k)) {
				temp.add(k);
				count++;
				k++;
			}
			tracker.add(temp);
		}
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int max = Integer.MIN_VALUE;
		for(ArrayList<Integer> l:tracker) {
			if(l.size()>max) {
				max = l.size();
			}
		}
		for(ArrayList<Integer> l:tracker) {
			if(l.size()==max) {
				list.add(l);
			}
		}
		int s = map.get(list.get(0).get(0));
		int end = map.get(list.get(0).get(list.get(0).size()-1));
		list.remove(0);
		for(ArrayList<Integer> i: list) {
			if(s > map.get(i.get(0))) {
				s = map.get(i.get(0));
				end = map.get(i.get(i.size()-1));
			}
		}
		ArrayList<Integer> l = new ArrayList<>();
		if(s==end) {;
			l.add(arr[s]);
			return l;
		}	
		l.add(arr[s]);
		l.add(arr[end]);
		return l;
    }

}
