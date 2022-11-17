package com.ninja.search_sort;

public class QuickSort2Sol {
	public static void main(String[] args) {
		int arr[] = new int[] {3,3,4,1,5,9,22};
//		QuickSort2.quickSort(arr, 0, arr.length-1);
		QuickSort1.quickSort1(arr, 0, arr.length-1);
		printArray(arr);
	}

	private static void printArray(int[] arr) {
		// TODO Auto-generated method stub
		for(int i:arr) {
			System.out.println(i);
		}
	}
}

class QuickSort1{
	public static void quickSort1(int[] arr, int start, int end) {
		if(start<=end) {
			int index = Partition1(arr, start, end);
			quickSort1(arr, start, index-1);
			quickSort1(arr, index+1, end);
		}
	}

	private static int Partition1(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		int pivot = arr[start];
		int count = 0;
		for(int i = start+1;i<=end;i++) {
			if(arr[i]<=pivot) {
				count++;
			}
		}
		int pivotIndex = start+count;
		arr[start] = arr[pivotIndex];
		arr[pivotIndex] = pivot;
		
		int i = start, j = end;
		while(i<j) {
			while(i<=end && arr[i]<=pivot) {
				i++;
			}
			while(j>=start && arr[j]>=pivot) {
				j--;
			}
			if(i<j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		return pivotIndex;
	}
}
class QuickSort2{
	public static void quickSort(int[] arr, int s, int e) {
		if(s<=e) {
			int index = Partition2(arr, s, e);
			quickSort(arr, s, index-1);
			quickSort(arr, index+1, e);
		}
	}

	private static int Partition2(int[] arr, int s, int e) {
		// TODO Auto-generated method stub
		int pivot = arr[e];
		int i = s-1;
		for(int j = s;j<e;j++) {
			if(arr[j]<=pivot) {
				++i;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1,e);
		return i+1;
	}

	private static void swap(int[] arr, int i, int j) {
		// TODO Auto-generated method stub
		int temp = arr[j];
		arr[j] = arr[i];
		arr[i] = temp;
	}
}