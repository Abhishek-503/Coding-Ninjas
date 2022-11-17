/*Second Largest Element In Tree
Send Feedback
Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.
Input format :
Elements in level order form separated by space (as per done in class). Order is - 

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element 
Output format:
Second Largest node data
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40*/
package com.ninja.trees;

import java.util.Scanner;

public class SecondlargestElement {
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
		TreeNode<Integer> ans = SecondlargestElementSol.findSecondLargest(root);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		} 
	}
}


class SecondlargestElementSol {

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



	static class Pair<T>{
		T first;
		T second;
		Pair(T first,T second){
			this.first = first;
			this.second = second;
		}
	}

	public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){


		// Write your code here
		return findSecondLargestT(root).second;
	}
	public static Pair<TreeNode<Integer>> findSecondLargestT(TreeNode<Integer> root){
		Pair<TreeNode<Integer>> output;
		if(root == null){
			output = new Pair<TreeNode<Integer>>(null,null);
			return output;
		}
		output = new Pair<TreeNode<Integer>>(root,null);
		for(TreeNode<Integer> child : root.children){
			Pair<TreeNode<Integer>> childPair = findSecondLargestT(child);
			if(childPair.first.data > output.first.data){
				if(childPair.second==null||childPair.second.data < output.first.data){
					output.second = output.first;
					output.first = childPair.first;
				} else {
					output.first = childPair.first;
					output.second = childPair.second;
				}
			} else if(childPair.first.data.equals(output.first.data) && childPair.second != null){
				output.second = childPair.second;
			} else if(output.first.data != childPair.first.data && (output.second == null || childPair.first.data>output.second.data)){
				output.second = childPair.first;
			}
		}
		return output;
	}
    public static Pair<TreeNode<Integer>> findSecondLargestHelper(TreeNode<Integer> root){
    	Pair<TreeNode<Integer>> output;
    	if(root == null) {
    		output = new Pair<>(null,null);
    		return output;
    	}
    	output = new Pair<>(root, null);
    	for(TreeNode<Integer> node : root.children) {
    		Pair<TreeNode<Integer>> temp = findSecondLargestHelper(node);
    		if(temp.first.data > output.first.data) {
    			if(temp.second==null || temp.second.data < output.first.data) {
    				output.second = output.first;
    				output.first = temp.first;
    			}
    			else {
    				output.first = temp.first;
    				output.second = temp.second;
    			}
    		}
    		else if(temp.first.data.equals(output.first.data) && temp.second!=null) {
    			output.second = temp.second;
    		}
    		else if(temp.first.data!=output.first.data &&((output.second==null) || (temp.first.data > output.second.data))) {
    			output.second = temp.first;		
    		}
    	}
    	return output;
    }

}
