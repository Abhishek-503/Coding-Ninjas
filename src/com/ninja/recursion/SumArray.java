package com.ninja.recursion;

import java.util.Scanner;

public class SumArray {

	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(SumArrSol.sum(input));
	}

}

class SumArrSol {
	static int tot = 0;
	public static int sum(int input[]) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		if(input.length==1){
            return input[input.length-1];
        }
        int arr[] = new int[input.length-1];
        for(int i = 0;i<arr.length;i++){
            arr[i] = input[i];
        }
        return input[input.length-1] + sum(arr);
	}
}
