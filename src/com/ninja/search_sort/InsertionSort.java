package com.ninja.search_sort;


/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class InsertionSort
{
	public static void printArray(int[]arr){
    int n=arr.length;
    for(int i=0;i<n;i++){
        System.out.println(arr[i]);
    }
}
public static void insertionSort(int[] arr){
    int n=arr.length;
    for(int i=1;i<n;i++){
        //Insert ith element in sorted position
        int j=i-1;
        int temp=arr[i];
        while(j>=0 && arr[j]>temp){
            arr[j+1]=arr[j];
            j--;
        }
        //Position will be j+1;
        arr[j+1]=temp;
        
       
    }
}
    
public static void main(String args[]) {
    int[] arr={9,6,3,7,2,8,1,5};
    insertionSort(arr);
    printArray(arr);
    }
}

