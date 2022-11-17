/*Code: N Queens
Send Feedback
You are given N, and for a given N x N chessboard, find a way to place N queens such that no queen can attack any other queen on the chess board. A queen can be killed when it lies in the same row, or same column, or the same diagonal of any of the other queens. You have to print all such configurations.
Input Format :
Line 1 : Integer N
Output Format :
One Line for every board configuration. 
Every line will have N*N board elements printed row wise and are separated by space
Note : Don't print anything if there isn't any valid configuration.
Constraints :
1<=N<=10
Sample Input 1:
4
Sample Output 1 :
0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0 
0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0*/ 
package com.ninja.backtracking;

import java.util.*;
public class NQueenMultipleSol {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		NQueenMultiple.placeNQueens(n);	
	}
}

class NQueenMultiple {
	static List<List<Integer> > result
	= new ArrayList<List<Integer> >();
	static boolean[] cols,leftDiagonal,rightDiagonal;

	public static void placeNQueens(int n){

		/* Your class should be named Solution.
		 * Don't write main() function.
		 * Don't read input, it is passed as function argument.
		 * Print output as specified in the question
		 */
		List<List<Integer>> res = solveNQ(n);
		for(int i= 0;i<res.size();i++) {
			List<Integer> temp = res.get(i);
			int[][] board = new int[n][n];
			for (int j = 0; j < n; j++) {
				board[j] = new int[n];
				for (int k = 0; k < n; k++)
				{
					board[j][k] = 0;
				}
			}
			for (int j = 0; j < n; j++) {
				board[j][temp.get(j)-1] = 1;
			}
			printSolution(board);
		}
	}

	static void printSolution(int board[][])
	{
		int N = board.length;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++)
				System.out.print(board[i][j]+ " ");			
		}
		System.out.println();
	}

	static  List<List<Integer>> solveNQ(int n) {
		// cols[i] = true if there is a queen previously placed at ith column
		cols = new boolean[n];
		// leftDiagonal[i] = true if there is a queen previously placed at
		// i = (row + col )th left diagonal
		leftDiagonal = new boolean[2*n];
		// rightDiagonal[i] = true if there is a queen previously placed at
		// i = (row - col + n - 1)th rightDiagonal diagonal
		rightDiagonal = new boolean[2*n];
		result = new ArrayList<>();
		List<Integer> temp = new ArrayList<>();
		for(int i=0;i<n;i++)
			temp.add(0);
		solveNQUtil(result,n,0,temp);

		return result;
	}
	private static void solveNQUtil(List<List<Integer>> result,int n,int row,List<Integer> comb){
		if(row==n){
			// if row==n it means we have successfully placed all n queens.
			// hence add current arrangement to our answer
			// comb represent current combination
			result.add(new ArrayList<>(comb));
			return;
		}
		for(int col = 0;col<n;col++){
			// if we have a queen previously placed in the current column
			// or in current left or right diagonal we continue
			if(cols[col] || leftDiagonal[row+col] || rightDiagonal[row-col+n])
				continue;
			// otherwise we place a queen at cell[row][col] and
			//make current column, left diagonal and right diagonal true
			cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = true;
			comb.set(col,row+1);
			// then we goto next row
			solveNQUtil(result,n,row+1,comb);
			// then we backtrack and remove our currently placed queen
			cols[col] = leftDiagonal[row+col] = rightDiagonal[row-col+n] = false;
		}
	}

}
