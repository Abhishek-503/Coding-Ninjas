/*in:
2
3
1 4 6
3
1 -1 4

op:
-1
2*/
package com.ninja.time_complexity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ArrayEqulibriumIndex {
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

            int[] arr = takeInput();
            System.out.println(ArrayEqulibriumIndexSol.arrayEquilibriumIndex2(arr));

            t -= 1;
        }
    }
}

class ArrayEqulibriumIndexSol {

	public static int arrayEquilibriumIndex(int[] arr){  
		//Your code goes here
		if(arr.length == 0) {
			return -1;
		}
		if(arr.length == 1) {
			return 0;
		}
		int sLeft = 0;
		int sRight = getSum(arr, 1);
		int i = 0;
        while(i<arr.length-1) {
        	if(sLeft==sRight) {
        		return i;
        	}
        	sLeft = sLeft + arr[i];
        	sRight = sRight - arr[i+1];
        	System.out.println("sLeft :"+sLeft + " , "+"sRight :"+sRight);
        	i++;
        }
//		System.out.println(sRight);
		return -1;
	}

	private static int getSum(int[] arr, int i) {
		int s = 0;
		for(int j = 1;j<arr.length;j++) {
			s = s + arr[j];
		}
		return s;
	}
	
	public static int arrayEquilibriumIndex2(int[] arr){  
		//Your code goes here
		int lSum = 0, rSum = 0;
		for(int i:arr) {
			rSum = rSum + i;
		}
		for(int i = 0;i<arr.length;i++) {
			rSum -= arr[i];
			if(lSum == rSum) {
				return i;
			}
			lSum += arr[i];
		}
		return -1;
	}
}
