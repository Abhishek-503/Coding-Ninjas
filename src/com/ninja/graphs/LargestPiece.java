/*Largest Piece
Send Feedback
Its Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's . But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with eachother on the cake. Given the size of cake N and the cake , can you find the size of the biggest piece of '1's for Gary ?
Constraints :
1<=N<=50
Input Format :
Line 1 : An integer N denoting the size of cake 
Next N lines : N characters denoting the cake
Output Format :
Size of the biggest piece of '1's and no '0's
Sample Input :
2
11
01
Sample Output :
3*/
package com.ninja.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LargestPiece {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String[] takeInput() throws IOException {
		int n = Integer.parseInt(br.readLine().trim());


		String[] edge = new String[n];
		for (int i = 0; i < n; i++) {
			edge[i] = br.readLine().replaceAll("\\s", "");
		}
		return edge;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		String[] edge = takeInput();
		int ans = LargestPieceSol.dfs(edge,edge.length);
		System.out.println(ans);   
	}	
}

class LargestPieceSol {

	static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	static int d[][];

	static int ma=0;
	static int caky(int n,String cake[],int i,int j)
	{ 
		if (i<0||i>=n||j<0||j>=n) return 0;

		if (d[i][j]==1) return 0;

		if (cake[i].charAt(j)=='0') return 0;

		int t=0;

		d[i][j]=1;

        for(int p = 0;p<dir.length;p++){
            int x = i + dir[p][0];
            int y = j + dir[p][1];
            t += caky(n,cake,x,y);
        }

		return t+1;


	}

	public static int dfs(String[] edge, int n) {    
		d= new int[n][n];
		int k = 0;
		for (int i=0;i<n;i++)
		{  
			for (int j=0;j<n;j++) 
			{ 
				if(d[i][j]==0 && edge[i].charAt(j)=='1') 
					k=caky(n,edge,i,j); 
				if (k>ma) 
					ma=k; 
			}

		}

		return ma;
	}
}