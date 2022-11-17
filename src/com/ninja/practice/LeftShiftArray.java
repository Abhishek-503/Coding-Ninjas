package com.ninja.practice;

/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class LeftShiftArray
{
	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7};
		int d = 2;
		int n = arr.length;
        for(int i=0;i<2;i++){
            int temp = arr[0];
            for(int j=0;j<n-1;j++){
                arr[j] = arr[j+1];
            }
            arr[n-1] = temp;
            printArray(arr);
        }
        
	}
	public static void printArray(int[] arr) {
        for (int element : arr) {
            System.out.print(element + " ");
        }

        System.out.println();
    }
	
}
