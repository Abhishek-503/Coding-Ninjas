package com.ninja.practice;

public class ArraysBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[5];
		int[] arr2 = new int[3];
//		int[][] arr1 = {{3,6,9 },
//				{1,4,7 },
//				{2,8,9}};
//		int[][] arr1 = {{6,9,8,5 },
//				{9,2,4,1 },
//				{8,3,9,3 },
//				{8,7,8,6 }};
		int[][] arr1 = {{6,9 },
				{8, 5 },
				{9, 2}};
//		6 9 8 5 
//		9 2 4 1 
//		8 3 9 3 
//		8 7 8 6 
//		6 9 
//		8 5 
//		9 2
//		int max = Integer.MIN_VALUE;
//		String rc = "row";
//		int index = 0;
//		for(int i=0;i<arr1.length;i++) {
//			int sum = 0;
//			int j=0;
//			for(;j<arr1[i].length;j++) {
//				sum = sum + arr1[i][j];
//			}
//			if(sum>max) {
//				index = i;
//				max = sum;
//			}
//		}
//		
//		for(int i=0;i<arr1[0].length;i++) {
//			int sum = 0;
//			int j=0;
//			for(;j<arr1.length;j++) {
//				sum = sum + arr1[j][i];
//			}
//			if(sum>max) {
//				index = i;
//				max = sum;
//				rc = "column";
//			}
//		}
//		System.out.println(rc + " " + index + " "+ max);
		int[][][] a = new int[4][2][];
		for(int i = 0;i<a.length;i++) {
			a[i] = new int[1][2];
		}
	}

}
