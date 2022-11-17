package com.ninja.practice;

public class ArrayDiagonalBorderSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] mat = 
//		{{1,2,3,10},
//		{4,5,6,11},
//		{7,8,9,12},
//		{13,14,15,16}};
		int[][] mat = 
			{{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16, 17, 18, 19, 20},
			{21 ,22 ,23 ,24 ,25}};
//		1 2 3 4 5
//		6 7 8 9 10
//		11 12 13 14 15
//		16 17 18 19 20
//		21 22 23 24 25
		int sum = 0;
		int n = mat.length;
        if(n>0){
            for(int i=0;i<n;i++) {
                for(int j=0;j<mat[i].length;j++) {
                    if(i==j && i!=0 && j!=0 && i!=n-1 && j!=n-1) {
                        sum = sum+mat[i][j];
                    }
                    if((i==0 || i==n-1) && j<n) {
                        sum = sum+mat[i][j]+mat[j][i];
                    }
                }
				sum = sum + mat[i][n-i-1];
            }
            sum = sum - mat[0][0] - mat[0][n-1]*2 - mat[n-1][0]*2 - mat[n-1][n-1];
            if(n%2!=0) {
                sum = sum - mat[n/2][n/2];
            }
            System.out.print(sum);
        }
        else{
            System.out.print(sum);
        }
		
		System.out.println(sum);
	}

}
