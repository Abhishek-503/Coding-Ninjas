package com.ninja.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class ConnectingDots {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static String[] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");

		int N = Integer.parseInt(strNums[0]);
		int M = Integer.parseInt(strNums[1]);

		String[] Graph = new String[N];

		for (int i = 0; i < N; ++i) {
			Graph[i] = br.readLine();
		}

		return Graph;
	}

	public static void main(String[] args) throws NumberFormatException, IOException {


		String[] Graph = takeInput();
		if (new Solution().solve(Graph,Graph.length,Graph[0].length())==1){
			System.out.print("true");
		}
		else{
			System.out.print("false");
		}
	}
}

class Solution {

	int l=0;
	void solve1(String b[],int n, int m,int i,int j,char c,int t,int[][] d)
	{ 
		if (i<0||i>=n||j<0||j>=m) return ;

		if (b[i].charAt(j)!=c) return ;

		if (d[i][j]!=0) { 
			System.out.println(d[i][j]+" "+t+" "+(d[i][j]-t+1));
			if (d[i][j]-t+1>=4) 
				l++; 
			return ;    
		}
		if (l>0) 
			return ;
		t++;
		d[i][j]=t;
		solve1(b,n,m,i+1,j,c,t,d);
		solve1(b,n,m,i,j+1,c,t,d);
		solve1(b,n,m,i-1,j,c,t,d);
		solve1(b,n,m,i,j-1,c,t,d);
	}


	int solve(String[] b , int n, int m)
	{ 
		int[][] d=new int[n][m];
		for (int i=0;i<n;i++) 
		{ 
			d[i]=new int[m];
			for (int j=0;j<m;j++) 
				d[i][j]=0;
		}

		for (int i=0;i<n;i++)

		{ 
			for (int j=0;j<m&&l==0;j++) 
			{
				if (d[i][j]==0) 
					solve1(b,n,m,i,j,b[i].charAt(j),0,d);

				if (l>0) break;
			}
		}
		
		for (int i=0;i<n;i++) 
		{ 
			for (int j=0;j<m;j++) 
				System.out.print(d[i][j]+" ");
			System.out.println();
		}

		System.out.println(l);
		if (l>0) return 1; else return 0;
	}

}