package com.ninja.binarytree;

import java.util.ArrayList;
import java.util.Scanner;

public class LongestLeafToRoot {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); // we can skip writing again inside <> after java version 1.7 
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = s.nextInt();
			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = s.nextInt();
			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}
	
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<Integer> output = LongestLeafToRootSol.longestRootToLeafPath(root);
		for(int i : output) {
			System.out.println(i);
		}
	}

}

class PairList{
	ArrayList<Integer> list = new ArrayList<Integer>();
	int depth;
	PairList(ArrayList<Integer> list, int depth){
		this.list = list;
		this.depth = depth;
	}
}
class LongestLeafToRootSol {
	//Absolutely Working
//	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
//		return (helper(root)).list;
//		
//	}
//	
//	private static PairList helper(BinaryTreeNode<Integer> root) {
//		if(root==null) {
//			return new PairList(null, 0);
//		}
//		PairList pL = helper(root.left);
//		PairList pR = helper(root.right);
//		PairList output = new PairList(null, 0);
//		ArrayList<Integer> aList;
//		if(pL.list==null && pR.list==null) {
//			aList = new ArrayList<>();
//			aList.add(root.data);
//			output.list = aList;
//			output.depth = 0;
//			return output;
//		}
//		if(pL.list==null && pR.list!=null) {
//			aList = new ArrayList<>();
//			aList.addAll(pR.list);
//			aList.add(root.data);
//			output.list = aList;
//			output.depth = pR.depth+1;
//			return output;
//		}
//		if(pR.list==null && pL.list!=null) {
//			aList = new ArrayList<>();
//			aList.addAll(pL.list);
//			aList.add(root.data);
//			output.list = aList;
//			output.depth = pL.depth+1;
//			return output;
//		}
//		if(pR.depth >= pL.depth) {
//			aList = new ArrayList<>();
//			aList.addAll(pR.list);
//			aList.add(root.data);
//			output.list = aList;
//			output.depth = pR.depth+1;
//			return output;
//		}
//		else {
//			aList = new ArrayList<>();
//			aList.addAll(pL.list);
//			aList.add(root.data);
//			output.list = aList;
//			output.depth = pL.depth+1;
//			return output;
//		}
//	}
	//Improved Code
	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		// Write your code here
		if(root==null){
            return null;
        }
        ArrayList<Integer> leftAns = longestRootToLeafPath(root.left);
        ArrayList<Integer> rightAns = longestRootToLeafPath(root.right);
        if(leftAns==null && rightAns==null){
            ArrayList<Integer> newList = new ArrayList<>();
            newList.add(root.data);
            return newList;
        }
        if(leftAns==null && rightAns!=null){
            rightAns.add(root.data);
            return rightAns;
        }
        if(leftAns!=null && rightAns==null){
            leftAns.add(root.data);
            return leftAns;
        }
        if(rightAns.size()>=leftAns.size()){
            rightAns.add(root.data);
            return rightAns;
        }
        else{
            leftAns.add(root.data);
            return leftAns;
        }
	}
}