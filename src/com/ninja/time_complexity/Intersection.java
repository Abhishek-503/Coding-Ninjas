package com.ninja.time_complexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Intersection {

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
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {
            int[] arr1 = takeInput();
            int[] arr2 = takeInput();
            IntersectionSol.intersection(arr1, arr2);
            System.out.println();

            t -= 1;
        }
    }
}


class IntersectionSol {

//	public static void intersection(int[] arr1, int[] arr2) {
//	    mergeSort(arr1);
//	    mergeSort(arr2);
//	    for(int i=0;i<arr1.length;i++) {
//	    	int index = binarySearch(arr2, 0, arr2.length-1,arr1[i]);
//	    	if(index!=-1){
//	    		System.out.print(arr1[i]+" ");
//	    		arr2 = removeElement(arr2,index);
//	    	}
//	    }
//	}
    
	public static void intersection(int[] arr1, int[] arr2) {
	    Arrays.sort(arr1);
	    Arrays.sort(arr2);
	    int i  = 0,j = 0;
	    int m = arr1.length;
	    int n = arr2.length;
	    while(i<m && j<n) {
	    	if(arr1[i]==arr2[i]) {
	    		System.out.print(arr1[i]+" ");
	    		i++;
	    		j++;
	    	}
	    	else if(arr1[i]<arr2[j]) {
	    		i++;
	    	}
	    	else {
	    		j++;
	    	}
	    }
	}
	
	private static int[] removeElement(int[] arr2, int index) {
		// TODO Auto-generated method stub
		int[] arr = new int[arr2.length-1];
		for(int i=0;i<index;i++) {
			arr[i] = arr2[i];
		}
		for(int i = index;i<arr2.length-1;i++) {
			arr[i] = arr2[i+1];
		}
		return arr;
	}

	private static int binarySearch(int[] arr2, int s, int e, int x) {
		if(s>e) {
			return -1;
		}
		int mid = (s+e)/2;
		if(arr2[mid]<x) {
			return binarySearch(arr2, mid+1, e, x);
		}
		else if(arr2[mid]>x) {
			return binarySearch(arr2, s, mid-1, x);
		}
		else {
			return mid;
		}
	}

	public static void mergeSort(int[] a) {
		if(a.length<=1) {
			return;
		}
		int[] b = new int[a.length/2];
		for(int i = 0;i<a.length/2;i++) {
			b[i] = a[i];
		}
		int[] c = new int[a.length-b.length];
		for(int i = a.length/2;i<a.length;i++) {
			c[i-a.length/2] = a[i];
		}
		mergeSort(b);
		mergeSort(c);
		merge(b,c,a);
	}
	
	public static void merge(int[] b, int[] c, int[] a) {
		int m = b.length;
		int n = c.length;
		int i=0,j=0,k=0;
		while(i<m && j<n) {
			if(b[i]<=c[j]) {
				a[k] = b[i];
				i++;
			}
			else {
				a[k] = c[j];
				j++;
			}
			k++;
		}
		while(i<m) {
			a[k] = b[i];
			k++;
			i++;
		}
		while(j<n) {
			a[k] = c[j];
			k++;
			j++;
		}
	}
}