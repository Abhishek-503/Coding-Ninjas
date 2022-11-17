package com.ninja.recursion3;

import java.util.Scanner;

public class ReturnPermutationOfString {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String output[] = ReturnPermutationOfStringSol.permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
}
class ReturnPermutationOfStringSol {
	public static int fact(int n) {
		int fact = 1;
		for(int i = n;i >= 1;i--) {
			fact = fact * i;
		}
		return fact;
	}
	public static String[] permutationOfString(String input){
		// Write your code here
		if(input.length() == 1){
			String[] retVal = {input};
			return retVal;
		}
		String[] rop = permutationOfString(input.substring(1));
		String[] tp = new String[fact(rop[0].length() + 1)];
		int k = 0;
		for(int i = 0;i < rop.length;i++){
			String temp = rop[i];
			for(int j = 0;j <= temp.length();j++,k++) {
				tp[k] = temp.substring(0,j) + input.charAt(0) + temp.substring(j);
			}
		}
		return tp;
	}
	
	public static String[] permutationOfString2(String input){
		// Write your code here
		if(input.length()==1) {
			String[] op = {input};
			return op;
		}
		
		String[] smallOp = permutationOfString2(input.substring(1));
		String[] op = new String[fact(smallOp[0].length() + 1)];
		
		int k = 0;
		for(int i = 0;i<smallOp.length;i++) {
			String temp = smallOp[i];
			for(int j = 0;j<temp.length();j++) {
				op[k] = temp.substring(0, j) + input.charAt(0) + temp.substring(j);
				k++;
			}
		}
		return op;
	}

}
