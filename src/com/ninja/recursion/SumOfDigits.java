package com.ninja.recursion;

import java.util.Scanner;

public class SumOfDigits {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(solution.sumOfDigits(n));
//		System.out.println(12/10);
	}
}

class solution {

	public static int sumOfDigits(int input){
		if(input/10==0)
			return input%10;
		return input%10 + sumOfDigits(input/10);
		
	}
}
