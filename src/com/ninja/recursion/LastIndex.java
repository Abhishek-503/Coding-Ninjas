package com.ninja.recursion;

import java.util.Scanner;

public class LastIndex {
	static Scanner s = new Scanner(System.in);
	
	public static int[] takeInput(){
		int size = s.nextInt();
		int[] input = new int[size];
		for(int i = 0; i < size; i++){
			input[i] = s.nextInt();
		}
		return input;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int x = s.nextInt();
		System.out.println(Solution2.lastIndex(input, x));
	}
}


class Solution2 {

	public static int lastIndex(int input[], int x) {
		// if(input.length==0){
		// return -1;
		// }
		// if(input[input.length-1]==x){
		// return input.length-1;
		// }
		// int arr[] = new int[input.length-1];
		// for(int i = 0;i<arr.length;i++){
		// arr[i] = input[i];
		// }
		// return lastIndex(arr,x);
        if(input.length==1){
            if(input[0]==x)
                return 0;
            else
                return -1;
        }
        int arr[] = new int[input.length-1];
        int primIndVal = input[0];
		for(int i = 1;i<arr.length;i++){
			arr[i-1] = input[i];
		}

        int ind = lastIndex(arr,x);
        if(ind!=-1 || primIndVal==x)
            return ind+1;
        return -1;
	}
	
}
