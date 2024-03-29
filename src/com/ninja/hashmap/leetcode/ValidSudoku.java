package com.ninja.hashmap.leetcode;

public class ValidSudoku {

	public boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] box = new boolean[9][9];
		
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < box[0].length; j++) {
				if(board[i][j]!='.') {
					int num = board[i][j] - '0' - 1;
					int k = (i/3)*3 + j/3;
					if(row[i][num] || col[j][num] || box[k][num]) {
						return false;
					}
					row[i][num] = col[j][num] =  box[k][num] = true;
				}
			}
		}
		return true;
	}
	
}
