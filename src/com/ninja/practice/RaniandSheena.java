package com.ninja.practice;

import java.util.Scanner;

public class RaniandSheena {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = 1;
		String s = "";
		while(t<=n) {
			int A = sc.nextInt();
			int N = sc.nextInt();
			int[] items = new int[N];
			for(int i=0;i<N;i++) {
				items[i] = sc.nextInt();
			}
			for(int j=0;j<N-1;j++) {
				for(int k = j+1;k<N;k++) {
					if((items[j]+items[k])==A) {
						s = s+(j+1)+" "+(k+1)+"\n";
					}
				}
			}
			t++;
		}
		System.out.println(s);
	}

}
