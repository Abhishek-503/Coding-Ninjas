package com.ninja.graphs;

import java.io.IOException;
import java.util.Scanner;

public class DFS {

	public static void dftraversal(int adjMatrix[][], int currentVertex, boolean visited[]){
		visited[currentVertex] = true; 
		System.out.print(currentVertex + " "); 
		for(int i = 0; i < adjMatrix.length; i++){ 
			if(adjMatrix[currentVertex][i] == 1 && visited[i] == false) {
				// i is neighbor of currentVertex 
				dftraversal(adjMatrix, i, visited);
			}
		}
	}


	public static void dftraversal(int adjMatrix[][]){
		boolean visited[]= new boolean[adjMatrix. length];
		for(int i=0;i<adjMatrix.length;i++) {
			if( !visited[i]) {
				dftraversal(adjMatrix,i,visited);
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		int edges[][] = new int[V][V];
		for(int i =0; i< E; i++){
			int fv = s.nextInt();
			int sv = s.nextInt();
			edges[fv][sv] = 1;   
			edges[sv][fv] =1;
		}
		dftraversal(edges);
	}
}
