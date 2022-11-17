package com.ninja.practice;

public class PrintLikeWave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] mat = 
//		{{1,2,3,10},
//		{4,5,6,11},
//		{7,8,9,12},
//		{13,14,15,16}};
		int[][] mat = 
			{{1,2,3},
			{4,5,6},
			{7,8,9},
			{10,11,12}};
//		1 2 3 
//		4 5 6 
//		7 8 9 
//		10 11 12 
		int n = mat.length;
		int c = mat[0].length; 
		int k = 0;
		for(int i=0;i<c;i++) {
			if(i%2==0) {
				k = 0;
				while(k<n) {
					System.out.print(mat[k][i]+" ");
					k++;
				}
			}
			else {
				k = n-1;
				while(k>=0) {
					System.out.print(mat[k][i]+" ");
					k--;
				}
			}
		}
	}

}
