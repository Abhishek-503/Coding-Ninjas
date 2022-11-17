package com.ninja.recursion3;

import java.util.Scanner;

public class KeyPad {
	public static String getOptions(int digit) {
		if(digit == 2) {
			return "abc";
		}
		if(digit == 3) {
			return "def";
		}
		if(digit == 4) {
			return "ghi";
		}
		if(digit == 5) {
			return "jkl";
		}
		if(digit == 6) {
			return "mno";
		}
		if(digit == 7) {
			return "pqrs";
		}
		if(digit == 8) {
			return "tuv";
		}
		return "wxyz";
	}
	public static void printKeypadCombinations(int input, String stringSoFar) {
		if(input == 0) {
			System.out.println(stringSoFar);
			return;
		}
		int lastDigit = input % 10;
		int smallInput = input/10;
		String optionsLastDigits = getOptions(lastDigit);
		for(int i=0; i<optionsLastDigits.length(); i++) {
			printKeypadCombinations(smallInput, optionsLastDigits.charAt(i) + stringSoFar);
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Number");
		int input = s.nextInt();
		printKeypadCombinations(input, "");
	}
}