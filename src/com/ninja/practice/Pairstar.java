package com.ninja.practice;

import java.util.Scanner;

public class Pairstar {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		System.out.println(PairstarSol.addStars(input));
	}
}

class PairstarSol {

	// Return the updated string
	public static String addStars(String s) {
		// Write your code here
		if(s.length()==1){
            return s;
        }
        String s1 = addStars(s.substring(1));
        if(s1.charAt(0)==s.charAt(0)) {
        	return s.charAt(0)+"*"+s1;
        }
		return s.charAt(0)+s1;
        
	}
}