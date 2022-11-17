package com.ninja.practice;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Beautify {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
        String sb = sc.next();
        int count = 1;
        int c = countMatches(sb, "77");
        System.out.println(c);
        
	}
	
	 public static boolean isEmpty(String s) {
	        return s == null || s.length() == 0;
	    }
	 
	    /* Counts how many times the substring appears in the larger string. */
	    public static int countMatches(String text, String str)
	    {
	        if (isEmpty(text) || isEmpty(str)) {
	            return 0;
	        }
	 
	        Matcher matcher = Pattern.compile(str).matcher(text);
	 
	        int count = 0;
	        while (matcher.find()) {
	            count++;
	        }
	 
	        return count;
	    }

}
