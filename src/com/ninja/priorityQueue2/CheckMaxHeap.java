package com.ninja.priorityQueue2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class CheckMaxHeap {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(CheckMaxHeapSol.checkMaxHeap(input));
	}
}

class CheckMaxHeapSol {

	public static boolean checkMaxHeap(int arr[]) {
		/*
		 * Your class should be named Solution Don't write main(). Don't read input, it
		 * is passed as function argument. Return output and don't print it. Taking
		 * input and printing output is handled automatically.
		 */
        int parentIndex, leftChildIndex, rightChildIndex;
        boolean maxHeapProperty=true;
		for (int i = 0; i < arr.length; i++) {
			parentIndex = i;
			leftChildIndex = 2 * parentIndex + 1;
			rightChildIndex = 2 * parentIndex + 2;
			if (leftChildIndex < arr.length) {
				if (arr[parentIndex] < arr[leftChildIndex]) {
					maxHeapProperty = false;
					break;
				}
				if (rightChildIndex < arr.length && arr[parentIndex] < arr[rightChildIndex]) {
					maxHeapProperty = false;
					break;
				}
			}
		}
		return maxHeapProperty;
	}
}
