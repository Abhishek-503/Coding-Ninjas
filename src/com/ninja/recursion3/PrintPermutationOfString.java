package com.ninja.recursion3;

import java.util.Scanner;

public class PrintPermutationOfString {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		PrintPermutationOfStringSolution.permutations(input);
	}
}

class PrintPermutationOfStringSolution {

	public static void permutations(String input){
		// Write your code here
		printPermutations(input,"");
//		printPermutationHelper(input, "");
	}
	private static void printPermutationHelper(String input, String outPutSoFar) {
		if(input.length()==0) {
			System.out.println(outPutSoFar);
			return;
		}
		for(int i = 0;i<input.length();i++) {
			char ch = input.charAt(i);
			String output = input.substring(0,i) + input.substring(i+1);
			printPermutationHelper(output, outPutSoFar + ch);
		}
	}
	public static void printPermutations(String input,String outputSoFar){
		if(input.length() == 0){
			System.out.println(outputSoFar);
			return;
		}
		for(int i = 0; i < input.length();i++){
			char ch = input.charAt(i);
			String toBePermuted = input.substring(0,i) + input.substring(i + 1);
//			System.out.println(toBePermuted);
			printPermutations(toBePermuted,outputSoFar + ch);
		}
	}

}
