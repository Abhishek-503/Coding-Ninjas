package com.ninja.search_sort;

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class All_search_sort
{
	public static void main(String[] args) {
		System.out.println("Hello World");
	}
	public static void selectionSorting(int[] arr) {
    	//Your code goes here
        for(int i=0;i<arr.length-1;i++){
            int min = i;
            for(int j = i+1;j<arr.length;j++){
                if(arr[j]<=arr[min]){
                    min = j;
                }
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }   
     public static int binarySearch(int[] arr, int x) {
    	//Your code goes here
        int start = 0;
        int end = arr.length-1;
        int mid =0;
        while(start<=end){
            mid = (start+end)/2;
            if(arr[mid]>x){
                end = mid-1;
            }
            else if(arr[mid]<x){
                start = mid+1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
    public static void printArray(int[]arr){
    int n=arr.length;
    for(int i=0;i<n;i++){
        System.out.println(arr[i]);
    }
}
public static void selectionSort(int[] arr){
    int n=arr.length;
    for(int i=0;i<n-1;i++){
        //Insert element at ith position
        int min=Integer.MAX_VALUE;
        int minIndex=-1;
        for(int j=i;j<n;j++){
            //Finding the minimum element among j positions
            if(arr[j]<min){
                min=arr[j];
                minIndex=j;
            }
        }
        //Swap element at minIndex with the ith element
        int temp=arr[minIndex];
        arr[minIndex]=arr[i];
        arr[i]=temp;
    }
}
}

