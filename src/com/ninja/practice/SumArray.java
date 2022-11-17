package com.ninja.practice;

/******************************************************************************

Online Java Compiler.
Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/

public class SumArray
{
	public static void main(String[] args) {
		int[] arr = {8,5,2};
		int[] arr2 = {1,3};

		int n1 = arr.length;
		int n2 = arr2.length;
		int[] arr3 = new int[n1];
		int d = Math.abs(n1-n2);
		for(int i=0;i<n1;i++){
			if(i>=d){
				arr3[i] = arr2[i-d];
			}
		}
		System.out.println();
		for(int j = 0;j<arr3.length;j++){
			System.out.println(arr3[j]+" ");
		}
		int sum1=0;
		int sum2=0;
		int temp=1;
		for(int i=n1-1;i>=0;i--){
			sum1 = sum1 + arr[i]*temp;
			temp = temp*10;
		}
		temp = 1;
		for(int i=n2-1;i>=0;i--){
			sum2 = sum2 + arr2[i]*temp;
			temp = temp*10;
		}
		System.out.println(sum1);
		System.out.println(sum2);
		System.out.println(sum1+sum2);
		System.out.println(856%10);
	}
}
