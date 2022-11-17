package com.ninja.practice;

public class CompressString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "aaabbccdsa";
		int count = 1;
		char[] ch = str.toCharArray();
		
		int n = ch.length;
		char temp = ch[0];
        String op = ""+temp;
		for(int i=1;i<n;i++) {
			if(ch[i-1]==ch[i] && ch[i] == temp) {
				count++;
			}
			else {
				temp = ch[i];
				
				if(count!=1) {
					op = op + count + temp;
				}
				else {
					op = op + temp;
				}
				count = 1;
			}	
		}
		if(count>1) {
			System.out.println(op+count);
		}
		else {
			System.out.println(op);
		}
		
	}

}
