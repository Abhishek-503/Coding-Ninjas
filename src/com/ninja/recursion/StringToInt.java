package com.ninja.recursion;

import java.util.Scanner;

public class StringToInt {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(StringToIntSol.convertStringToInt(input));
	}
}

class StringToIntSol {

	public static int convertStringToInt(String input){
		if(input.length()==1) {
			return Integer.parseInt(input);
		}
		return Integer.parseInt(input.charAt(input.length()-1)+"")+convertStringToInt(input.substring(0,input.length()-1))*10;
	}
}