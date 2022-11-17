package com.ninja.graphs;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {

    public static void printHelper(int edges[][], int sv,boolean visited[]){
//        Queue<Integer> q = new LinkedList<>();
//        q.add(sv);
//        visited[sv]=true;
//        while(q.size()!=0){
//            int firstelem = q.remove();
//            System.out.print(firstelem+" ");
//            for(int i=0; i<edges.length; i++){
//                if(edges[firstelem][i]==1 && !visited[i]){
//                    q.add(i);
//                    visited[i]=true;
//                }       
//            }
//        }   
    	Queue<Integer> pendingQueue = new LinkedList<Integer>();
    	pendingQueue.add(sv);
    	visited[sv] = true;
    	while(!pendingQueue.isEmpty()) {
    		int n = pendingQueue.poll();
    		System.out.print(n+" ");
    		for (int i = 0; i < edges.length; i++) {
				if(edges[n][i] == 1 && !visited[i]) {
					pendingQueue.add(i);
					visited[i] = true;
				}
			}
    	}
    }
    // we have to deal with both connected and non connected
    public static void print(int edges[][]){
//        boolean visited[] = new boolean[edges.length];
//        for(int i=0; i< edges.length; i++){
//            if(!visited[i]){
//                printHelper(edges, i, visited);   
//            }
//        }
    	boolean[] visited = new boolean[edges.length];
    	for(int i = 0;i<edges.length;i++) {
    		if(!visited[i]) {
    			printHelper(edges, i, visited);
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
        print(edges);
	}
}