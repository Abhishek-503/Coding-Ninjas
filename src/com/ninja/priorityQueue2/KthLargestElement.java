package com.ninja.priorityQueue2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class KthLargestElement {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		System.out.println(KthLargestElementSol.kthLargest(n, input, k));
	}
}

class KthLargestElementSol {

	public static int kthLargest(int n, int[] input, int k) {
		// Write your code here
		PriorityQueue<Integer> pQueue = new PriorityQueue<>();
		int i = 0;
		for (; i < k; i++) {
			pQueue.add(input[i]);
		}
		for (; i < input.length; i++) {
			if (pQueue.element() < input[i]) {
				pQueue.remove();
				pQueue.add(input[i]);
			}
		}
		return pQueue.element();
	}
}
