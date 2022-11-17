package com.ninja.search_sort;

public class MergeSortWithSortedArr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr1 = {3,4,4,7,10,12};
		int[] arr2 = {1,2,6,13};
		int arr[] = new int[arr1.length+arr2.length];
		int j = 0;
		int k = 0;
		int i = 0;
		while(j<arr1.length && k<arr2.length){
			if(arr1[j]<=arr2[k]) {
				arr[i] = arr1[j];
				j++;
			}
			else {
				arr[i] = arr2[k];
				k++;
			}
			i++;
		}
		while(j<arr1.length) {
			arr[i] = arr1[j];
			j++;
			i++;
		}
		while(k<arr2.length) {
			arr[i] = arr2[k];
			k++;
			i++;
		}
		System.out.println(j+" "+k);
		for(j=0;j<arr.length;j++) {
			System.out.println(arr[j]);
		}
	}

}
