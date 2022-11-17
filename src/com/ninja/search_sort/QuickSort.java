package com.ninja.search_sort;

public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,6,8,5,3};
		QuickSortSol.quickSort(arr, 0, arr.length-1);
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}

class QuickSortSol{
	public static void quickSort(int[] arr, int start,int end) {
		if(start<end) {
			int index = partition(arr, start, end);
			quickSort(arr, start, index-1);
			quickSort(arr, index+1, end);
		}
	}

	private static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start-1;
		for(int j=start;j<end;j++) {
			if(arr[j]<pivot) {
				i++;
				swap(arr, i, j);
			}
		}
		swap(arr,i+1,end);
		return i+1;
	}

	private static void swap(int[] arr, int i, int j)
	{
	    int temp = arr[i];
	    arr[i] = arr[j];
	    arr[j] = temp;
	}
	 
}