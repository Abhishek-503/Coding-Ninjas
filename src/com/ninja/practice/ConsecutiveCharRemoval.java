package com.ninja.practice;

public class ConsecutiveCharRemoval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "xxyyzxx";
		char[] ch = str.toCharArray();
        String str1 = ""+ch[0];
        for(int i=1;i<ch.length;i++){
        	if(ch[i]!=str1.charAt(str1.length()-1)) {
        		str1 = str1+ch[i];
        	}
        }
        System.out.println(str1);
	}

}
