package com.ninja.search_sort;

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class BubbleSort
{
	public static void main(String[] args) {
		int arr[] = {4,3,6,8,1,5,7};
		bubbleSort(arr);
//		printArray(arr);
	}
	public static void bubbleSort(int[] arr){
    	//Your code goes here
        int n = arr.length;
        for(int i=1;i<n-1;i++){
            for(int j=0;j<n-i;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }  
}

