package com.ninja.practice;

/******************************************************************************

Online Java Compiler.
Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;
public class SumOddEven
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(0<=N && N<=(int)Math.pow(10,8)){
			int rem = N%10;
			int sumEven = 0;
			int sumOdd = 0;
			while(N!=0){
				if(rem%2==0){
					sumEven += rem;
				}
				else{
					sumOdd += rem;
				}
				N = N/10;
				rem = N%10;
			}
			System.out.println(sumEven+" "+sumOdd);
		}
	}
}

