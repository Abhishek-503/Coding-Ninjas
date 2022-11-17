package com.ninja.time_complexity;

/*
INP:
1
9
0 7 2 5 4 7 1 3 6
OUT:
7
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FindDuplicateElement {

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

    		int[] input = takeInput();
        	System.out.println(FindDuplicateElementSol.findDuplicate(input));

        	t -= 1;
    	}
    }
}

class FindDuplicateElementSol {

	public static int findDuplicate(int[] arr) {
		//Your code goes here
//		quickSort(arr,  0, arr.length-1);
		Arrays.sort(arr);
//		FindDuplicateElement.printArray(arr);
		for(int i= 0;i<arr.length-1;i++) {
			if(arr[i]==arr[i+1]) {
				return arr[i];
			}
		}
		return arr[0];
	}
	
	public static void quickSort(int[] arr, int start, int end) {
		if(start>end) {
			return;
		}
		int index = partition(arr, start, end);
		quickSort(arr, start, index-1);
		quickSort(arr, index+1, end);
		
	}
	public static int partition(int[] arr, int start, int end) {
		int pivot = arr[end];
		int i = start-1;
		for(int j = start;j<end;j++) {
			if(arr[j]<=pivot) {
				++i;
				swap(arr, i, j);
			}
		}
		swap(arr, i+1, end);
		return i+1;
	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}