package com.ninja.practice;

import java.util.Scanner;

public class EvenOddPrime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];//{2,3,1,11,7}
		for(int i = 0;i<arr.length;i++) {
			arr[i] = sc.nextInt();
		}
		for(int i=0;i<arr.length;i++) {
			int ele = arr[i];
			if(isPrime(ele)) {
				if(ele%2==0) {
					System.out.println("Prime and even");
				}
				else {
					System.out.println("Prime and odd");
				}
			}
			else {
				if(ele%2==0) {
					System.out.println("even");
				}
				else {
					System.out.println("odd");
				}
			}
		}
	}

	private static boolean  isPrime(int ele) {
		// TODO Auto-generated method stub
		boolean flag = true;
		if(ele==1) {
			return false;
		}
		for(int i = 2;i<ele;i++) {
			if(ele%i==0) {
				return false;
			}
		}
		
		return flag;
	}

}
