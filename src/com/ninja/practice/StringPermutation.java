package com.ninja.practice;

import java.util.Arrays;

public class StringPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "rate";
		String str2 = "rate";
//		char[] chr = str1.toCharArray();
//		sort(chr);
//		char[] chr2 = str2.toCharArray();
//		sort(chr2);
//        Arrays.sort(chr);
//        Arrays.sort(chr2);
//        String str3= new String(chr);
//		String str4= new String(chr2);
//		System.out.println(str3.equals(str4));
		int[] arr = new int[256];
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        for(int i=0;i<ch1.length;i++){
            arr[ch1[i]] = arr[ch1[i]]+1;
        }
        for(int i=0;i<ch2.length;i++){
            arr[ch2[i]] = arr[ch2[i]]-1;
        }
        for(int i=0;i<arr.length;i++){
           if(arr[i]!=0){
               System.out.println(false);
               break;
           }
           
        }
        
	}

	static void print(char[] arr) {	
		int n = arr.length;
        for (int i = 0; i < n; ++i) {
        	System.out.println(arr[i]);
        }
	}
	
	static void sort(char arr[])
    {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            char key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
