/*BFS
Send Feedback
Given an undirected and disconnected graph G(V, E), print its BFS traversal.
Note:
1. Here you need to consider that you need to print BFS path starting from vertex 0 only. 
2. V is the number of vertices present in graph G and vertices are numbered from 0 to V-1. 
3. E is the number of edges present in graph G.
4. Take graph input in the adjacency matrix.
5. Handle for Disconnected Graphs as well
Input Format :
The first line of input contains two integers, that denote the value of V and E.
Each of the following E lines contains space separated two integers, that denote that there exists an edge between vertex a and b.
Output Format :
Print the BFS Traversal, as described in the task.
Constraints :
0 <= V <= 1000
0 <= E <= (V * (V - 1)) / 2
0 <= a <= V - 1
0 <= b <= V - 1
Time Limit: 1 second
Sample Input 1:
4 4
0 1
0 3
1 2
2 3
Sample Output 1:
0 1 3 2*/
package com.ninja.graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class GetPath_DFS {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();
		int edges[][]=new int[V][V];
		for(int i=0;i<E;i++){
			int sv=s.nextInt();
			int ev=s.nextInt();
			edges[sv][ev]=1;
			edges[ev][sv]=1;
		}
		int V1=s.nextInt();
		int V2=s.nextInt();
		boolean visited[]=new boolean[V];
		ArrayList<Integer> ans=getPathDFS(edges,visited,V1,V2);
		if(ans!=null){
			for(int elem:ans)
			{
				System.out.print(elem+" ");
			}
		}
	}
	public static ArrayList<Integer> getPathDFS(int[][] edges,boolean[] visited,int V1,int V2){
		if(V1==V2)
		{
			ArrayList<Integer> ans=new ArrayList<>();
			visited[V1]=true;
			ans.add(V1);
			return ans;
		}
		visited[V1]=true;
		for(int i=0;i<edges.length;i++)
		{
			if(edges[V1][i]==1 && !visited[i])
			{ 
				ArrayList<Integer> arr=getPathDFS(edges,visited,i,V2); 
				if(arr!=null)
				{
					arr.add(V1);

					return arr;
				}
			}
		}
		return null;
	}
}