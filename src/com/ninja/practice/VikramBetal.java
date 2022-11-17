package com.ninja.practice;

import java.util.Scanner;

public class VikramBetal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
	    int t = sc.nextInt();
	    while (t > 0) {
	      int n = sc.nextInt();
	      int count = 0;
	      int[] arr = new int[n];
	      int i = 0;
	      while (i<n) {
	    	  arr[i] = sc.nextInt();
		      i++;
	      }
	      for(int j=0;j<arr.length-1;j++) {
	    	  for(int k = j+1;k<arr.length;k++) {
	    		  if(arr[j]==arr[k] && j!=k) {
	    			  count++;
	    		  }
	    	  }
	      }
	      System.out.println(count*2);
	      t--;
	    }
	}

}
