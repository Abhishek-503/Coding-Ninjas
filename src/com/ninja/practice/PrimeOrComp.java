package com.ninja.practice;

/******************************************************************************

Online Java Compiler.
Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

 *******************************************************************************/
import java.util.*;
public class PrimeOrComp
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean isPrime = true;
		int N = sc.nextInt();
		int div = 2;
		while(div<=N/2){
			if(N%div==0)
				isPrime = false;
			div = div+1; 
		}
		if(isPrime){
			System.out.println("Prime");
		}
		else{
			System.out.println("Composite");
		}

	}
}
