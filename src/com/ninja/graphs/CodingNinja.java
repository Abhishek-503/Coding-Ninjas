package com.ninja.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class CodingNinja {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String[] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");
		int size = 2;
		int[] input = new int[size];
		for (int i = 0; i < size; ++i) {
			input[i] = Integer.parseInt(strNums[i]);
		}


		String[] Graph = new String[input[0]];

		for (int i = 0; i < input[0]; ++i) {
			Graph[i] = br.readLine();
		}

		return Graph;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		String[] Graph = takeInput();
		System.out.println(new CodingNinjaSol().solve(Graph,Graph.length,Graph[0].length()));


	}
}

class CodingNinjaSol {

	//	private static boolean checker(String arr[], int n, int m, int i, int j, String s, boolean[][] visited)
	//	{
	//		if (s.length() == 0)
	//		{
	//			return true;
	//		}
	//		if (i < 0 || j < 0 || i >= n || j >= m)
	//		{
	//			return false;
	//		}
	//		int row_array[] = { i - 1, i, i + 1 };
	//		int col_array[] = { j - 1, j, j + 1 };
	//		for (int p = 0; p < 3; p++)
	//		{
	//			for (int q = 0; q < 3; q++)
	//			{
	//				if (row_array[p] == i && col_array[q] == j)
	//				{
	//					continue;
	//				}
	//
	//				int row = row_array[p];
	//				int col = col_array[q];
	//				if (row < 0 || col < 0 || row >= n || col >= m)
	//				{
	//					continue;
	//				}
	//				if (arr[row].charAt(col) == s.charAt(0) && !visited[row][col])
	//				{
	//					visited[row][col] = true;
	//					boolean checked = checker(arr, n, m, row, col, s.substring(1), visited);
	//					if (checked)
	//					{
	//						return checked;
	//					}
	//					else
	//					{
	//						visited[row][col] = false;
	//					}
	//				}
	//			}
	//		}
	//		return false;
	//	}
	//
	//
	//
	//
	//	public int solve(String arr[],int n, int m)
	//	{
	//
	//		boolean[][] visited = new boolean[n][m];
	//		for (int i = 0; i < n; i++)
	//		{
	//			visited[i] = new boolean[m];
	//			for (int j = 0; j < m; j++)
	//			{
	//				visited[i][j] = false;
	//			}
	//		}
	//
	//
	//		for (int i = 0; i < n; i++)
	//		{
	//			for (int j = 0; j < m; j++)
	//			{
	//				if (arr[i].charAt(j) == 'C')
	//				{
	//					//creating dynamic boolean 2d array
	//
	//
	//					//checking
	//					if(checker(arr, n, m, i, j, "ODINGNINJA", visited))
	//					{
	//						return 1;
	//					}
	//
	//					//deleting dynamic boolean array
	//					for(int p=0; p<n; p++)
	//					{
	//						for(int q=0; q<m; q++)
	//						{
	//							visited[p][q]=false;
	//						}
	//					}
	//				}
	//			}
	//		}
	//		return 0;
	//	}

	public static int solve(String[] Graph , int N, int M)
	{
		String searchingString = "CODINGNINJA";
		boolean[][] visited = new boolean[Graph.length][];
		for(int i=0;i<Graph.length;i++) {
			visited[i] = new boolean[Graph[i].length()];
		}

		for(int i=0;i<Graph.length;i++) {

			for(int j=0;j<Graph[i].length();j++) {
				if(Graph[i].charAt(j) == 'C' ) {

					boolean ans =  dfs( Graph,visited,searchingString.substring(1),i,j);
					if(ans) {
						return 1;
					}


				}
			}

		}
		return 0;

	}

	public static boolean dfs(String[] graph, boolean[][] visited, String searchString,int i,int j) {

		if(searchString.length() == 0) {
			visited[i][j] = true;
			return true;
		}

		visited[i][j] = true;
		// To traverse in 8 different directions
		int[] X_Dir = {-1,1,0,0,1,-1,1,-1 };
		int[] Y_Dir = {0,0,-1,1,1,-1,-1,1 };

		for(int k=0;k<X_Dir.length;k++) {

			int x = i+ X_Dir[k];
			int y = j+ Y_Dir[k];

			if( x>=0 && y>=0 && x< graph.length &&
					y < graph[x].length() && 
					graph[x].charAt(y) ==searchString.charAt(0) && !visited[x][y]  ) {

				boolean smallAns = dfs(graph, visited, searchString.substring(1), x, y);
				if(smallAns) {
					return smallAns;
				}

			}


		}

		visited[i][j] = false;
		return false;


	}


}