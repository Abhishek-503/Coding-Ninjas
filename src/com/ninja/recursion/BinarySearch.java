package com.ninja.recursion;

import java.util.Arrays;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = new int[] {2,1,6,7,3,11,9,8};
		Arrays.sort(arr);
		System.out.println(BinarySearch.search(arr,0,arr.length-1,8));
	}

	private static int search(int[] arr, int start, int end, int x) {
		// TODO Auto-generated method stub
		if(start<=end) {
			int mid = (start+end)/2;
			if(arr[mid]==x) {
				return mid;
			}
			if(arr[mid]>x) {
				return search(arr, start, mid-1, x);
			}
			return search(arr, mid+1, end, x);
		}
		return -1;
	}
}

