package com.ninja.recursion;

import java.util.Scanner;

public class MergeSort {
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		s.close();
		return arr;
	}
	
	public static void printArray(int input[]) {
		for(int i = 0; i < input.length; i++) {
			System.out.print(input[i] + " ");
		}
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		MergeSortSol.mergeSort(input);
		printArray(input);
	}
}

class MergeSortSol {

	public static void mergeSort(int[] input){
		// Write your code here
		sort(input,0,input.length-1);
	}
	
	public static void sort(int[] input, int l, int r) {
		if(l<r) {
			int mid = l+ (r-l)/2;
			sort(input, l, mid);
			sort(input, mid+1, r);
			merge(input, l, mid, r);
		}
	}
//	public static void merge(int[]s1,int[]s2,int[]d){
//        int i=0;
//        int j=0;
//        int k=0;
//        while(i<s1.length && j<s2.length){
//            if(s1[i]<=s2[j]){
//                d[k]=s1[i];
//                i++;
//                k++;
//            }else{
//                d[k]=s2[j];
//                k++;
//                j++;
//            }
//        }
//        if(i<s1.length){
//            while(i<s1.length){
//                d[k]=s1[i];
//                i++;
//                k++;
//            }
//        }
//        if(j<s2.length){
//            while(j<s2.length){
//                d[k]=s2[j];
//                k++;
//                j++;
//            }
//        }
//    }
//    public static void mergeSort(int a[]){
//        if(a.length<=1){
//            return;
//        }
//        int b[]=new int[a.length/2];
//        int c[]=new int[a.length-b.length];
//        for(int i=0;i<a.length/2;i++){
//            b[i]=a[i];
//        }
//        for(int i=a.length/2;i<a.length;i++){
//            c[i-a.length/2]=a[i];
//        }
//        mergeSort(b);
//        mergeSort(c);
//        merge(b,c,a);
//    }
	
	public static void merge(int[] arr, int l, int m, int r) {
		// TODO Auto-generated method stub
		int n1 = m-l+1;
		int n2 = r-m;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		for(int i=0;i<n1;i++) {
			L[i] = arr[l+i];
		}
		for(int j=0;j<n2;j++) {
			R[j] = arr[m+1+j];
		}
		int j = 0;
		int k = 0;
		int i = l;
		while(j<L.length && k<R.length){
			if(L[j]<=R[k]) {
				arr[i] = L[j];
				j++;
			}
			else {
				arr[i] = R[k];
				k++;
			}
			i++;
		}
		while(j<L.length) {
			arr[i] = L[j];
			j++;
			i++;
		}
		while(k<R.length) {
			arr[i] = R[k];
			k++;
			i++;
		}
	}

}