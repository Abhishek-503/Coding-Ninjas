package com.ninja.practice;

public class MinLenWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abc de ghihjk a uvw h j";
		String[] strArr = s.split(" ");
		int min = strArr[0].length();
		String res = strArr[0];
		for(int i = 1;i<strArr.length;i++) {
			int len = strArr[i].length();
			if(len<min) {
				res = strArr[i];
				min = len;
			}
		}
		System.out.println(res);
	}

}
