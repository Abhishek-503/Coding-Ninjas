package com.ninja.practice;

public class SplitString 
{
	public static void main(String[] args) {
		String str = "Welcome to Coding Ninjas";
		String[] s = str.split(" ");
		for (int i=0;i<s.length;i++){
		    System.out.println(s[i]);
		} 
	}
}