package com.ninja.recursion;

import java.util.Scanner;

public class StairCase {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(StairCaseSol.staircase(n));
	}
}
class StairCaseSol {
	
	
    public static int staircase(int n){
		
    	if(n<0)
    		return 0;
    	if(n==1 || n==0) {
    		return 1;
    	}
    	return staircase(n-1)+staircase(n-2)+staircase(n-3);
	}
	
}