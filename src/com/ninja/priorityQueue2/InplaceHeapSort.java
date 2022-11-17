package com.ninja.priorityQueue2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InplaceHeapSort {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Solution.inplaceHeapSort(input);
		for (int i : input) {
			System.out.print(i + " ");
		}
	}

}

class Solution {

	public static void inplaceHeapSort(int arr[]) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Change in the given input itself.
		* Taking input and printing output is handled automatically.
		*/
		heapSort(arr);
	}
    
    public static void downHeapify(int arr[],int i,int n) {
        int parentIndex=i;
        int leftChildIndex= 2*parentIndex+1;
        int rightChildIndex= 2*parentIndex+2;
        while(leftChildIndex<n){
            int minIndex= parentIndex;
            if(arr[leftChildIndex] <arr[minIndex]){
                minIndex=leftChildIndex;
            }

            if(rightChildIndex<n && arr[rightChildIndex]<arr[minIndex]){
                minIndex= rightChildIndex;
            }
            if(minIndex==parentIndex){
                return;
            }
            int temp= arr[parentIndex];
            arr[parentIndex] = arr[minIndex];
            arr[minIndex]= temp;
            parentIndex= minIndex;
            leftChildIndex= 2*parentIndex+1;
            rightChildIndex= 2*parentIndex+2;
        }

    }


    public static void heapSort(int[] arr){
        //Build the heap
        int n= arr.length;
        for(int i=(n/2)-1; i>=0;i--){
            downHeapify(arr,i,n);
        }
        //Remove elemts from starting one by one, and put them at respective last position
        for(int i=n-1;i>=0;i--){
          int temp= arr[i];
          arr[i]= arr[0];
          arr[0]= temp;
          downHeapify(arr, 0,i);
        }
    }
}
