package com.ninja.practice;

public class SpiralArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = 
			{{1,2,3},
			{4,5,6},
			{7,8,9},
			{10,11,12}};
		int row = matrix.length;
		int col = matrix[0].length;
		int top = 0, bottom = row-1, left = 0, right = col-1;
		int dir = 1;
		while(top<=bottom && left<=right) {
			if(dir == 1) {
				for(int i = left;i<=right;i++)
				{
					System.out.print(matrix[top][i]+ " ");
				}	
				++top;
				dir = 2;
			}
			else if(dir ==2 ) {
				for(int i = top;i<=bottom;i++)
				{
					System.out.print(matrix[i][right]+" ");
				}	
				--right;
				dir = 3;
			}
			else if(dir ==3 ) {
				for(int i = right;i>=left;i--)
				{
					System.out.print(matrix[bottom][i]+" ");
				}	
				--bottom;
				dir = 4;
			}
			else if(dir ==4 ) {
				for(int i = bottom;i>=top;i--)
				{
					System.out.print(matrix[i][left]+" ");
				}	
				++left;
				dir = 1;
			}
		}

	}

}
