package com.ninja.priorityQueue2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class kSmallestElement {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		int k = Integer.parseInt(br.readLine());
		ArrayList<Integer> output = kSmallestElementSol.kSmallest(n, input, k);
		Collections.sort(output);
		for (int i : output) {
			System.out.print(i + " ");
		}
	}
}

class MaxPQComparator implements Comparator<Integer> {

	public int compare(Integer o1, Integer o2) {
		if (o1 > o2) {
			return -1;
		} else if (o1 < o2) {
			return 1;
		} else {
			return 0;
		}
	}
}
class kSmallestElementSol {

	public static ArrayList<Integer> kSmallest2(int n, int[] input, int k) {
		// Write your code here
		MaxPQComparator maxPQComparator = new MaxPQComparator();
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(maxPQComparator);
		ArrayList<Integer> output = new ArrayList<>();
		for (int i = 0; i < input.length; i++) {
			pQueue.add(input[i]);
		}
		while (pQueue.size() != k) {
			pQueue.remove();
		}
		while (!pQueue.isEmpty()) {
			output.add(pQueue.remove());
		}
		return output;	
	}
	
	public static ArrayList<Integer> kSmallest(int n, int[] input, int k) {
		// Write your code here
		PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
		ArrayList<Integer> output = new ArrayList<>();
		for (int i = 0; i<k; i++) {
			pQueue.add(input[i]);
		}
		for (int i = k; i<n; i++) {
			if(input[i] < pQueue.peek()){
	            pQueue.poll();
	            pQueue.add(input[i]);
	        }
		}
		while (!pQueue.isEmpty()) {
			output.add(pQueue.remove());
		}
		return output;	
	}
	
}