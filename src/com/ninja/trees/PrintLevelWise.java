package com.ninja.trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PrintLevelWise {
	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
				int numChild = s.nextInt();
				for(int i = 0 ; i < numChild; i++){
					int currentChild = s.nextInt();
					TreeNode<Integer> childNode = new TreeNode<Integer>(currentChild);
					pendingNodes.enqueue(childNode);
					currentNode.children.add(childNode);
				}
			} catch (QueueEmptyException e) {
			}
		}
		return root;
	}


	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		PrintLevelWiseSol.printLevelWise(root); 
	}

}
class PrintLevelWiseSol {

/*	TreeNode structure 
 * 
 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	
	
	
	public static void printLevelWise(TreeNode<Integer> root){

		if(root==null) {
			return;
		}
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
		pendingNodes.add(null);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> currNode = pendingNodes.poll();
			if(currNode == null) {
				System.out.println();
				if(!pendingNodes.isEmpty()) {
					pendingNodes.add(null);
				}
			}
			else {
				System.out.print(currNode.data+" ");
				for(int i = 0; i<currNode.children.size();i++) {
					pendingNodes.add(currNode.children.get(i));
				}
			}
		}

	}
		
}
