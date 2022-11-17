package com.ninja.graphs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
public class Islands {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static int[][] takeInput() throws IOException {
		String[] strNums;
		strNums = br.readLine().split("\\s");
		int n = Integer.parseInt(strNums[0]);
		int e = Integer.parseInt(strNums[1]);

		int[][] edges = new int[n][n];
		int firstvertex, secondvertex;

		for (int i = 0; i < e; i++) {
			String[] strNums1;
			strNums1 = br.readLine().split("\\s");
			firstvertex = Integer.parseInt(strNums1[0]);
			secondvertex = Integer.parseInt(strNums1[1]);
			edges[firstvertex][secondvertex] = 1;
			edges[secondvertex][firstvertex] = 1;
		}
		return edges;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		int [][]edges = takeInput();

		int ans = IslandsSol.numConnected(edges, edges.length);
		System.out.println(ans);

	}
}

class IslandsSol {

	public static void printHelper(int edges[][], int sv,boolean visited[]){
		Queue<Integer> q = new LinkedList<>();
		q.add(sv);
		visited[sv]=true;
		while(q.size()!=0){
			int firstelem = q.remove();
			System.out.print(firstelem+" ");
			for(int i=0; i<edges.length; i++){
				if(edges[firstelem][i]==1 && !visited[i]){
					q.add(i);
					visited[i]=true;
				}       
			}
		}   
	}

	public static int numConnected(int[][] edges, int n) {
		int count = 0;
		boolean visited[] = new boolean[edges.length];
		for(int i=0; i< edges.length; i++){
			if(!visited[i]){
				printHelper(edges, i, visited);   
				count++;
			}
		}
		return count;
	}


}