package com.ninja.practice;

public class MaxOccuringChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "abdefgbabfba";
		char[] ch = str.toCharArray();
        int[] arr = new int[256];
        for(int i=0;i<ch.length;i++) {
        	arr[ch[i]] = arr[ch[i]]+1;
        }
//        for (int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
        int max = Integer.MIN_VALUE;
        int index = 0;
        String op = "";
        for(int i=0;i<arr.length;i++) {
        	if(arr[i]>max) {
        		
        		max = arr[i];
        		index = i;
        	}
        	
        }
        System.out.println((char)index);
	}

}
