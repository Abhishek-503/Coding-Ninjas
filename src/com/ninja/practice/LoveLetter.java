package com.ninja.practice;

public class LoveLetter {
	public static void main(String[] args) {
	    String str = "hiab odgo";
	    int input = 4;
	    String[] strArr = str.split(" ");
	    int count = 0;
	    for(String s:strArr){
	        int len = s.length();
	        System.out.println(s);
	        String temp = s.substring(0,len-input);
	        String temp2 = s.substring(len-input);
	        System.out.println(temp2+temp);
	        if((temp2+temp).equals(s))
                count++;
	    }
	    System.out.println(count);
	}
}
