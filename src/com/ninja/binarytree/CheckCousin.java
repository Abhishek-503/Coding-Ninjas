package com.ninja.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class CheckCousin {
	static Scanner s = new Scanner(System.in);

	public static BinaryTreeNode<Integer> takeInput(){
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
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
		int p = s.nextInt();
		int q = s.nextInt();
		System.out.println(solution.isCousin(root, p, q));
	}
}


class solution {

	/*	Binary Tree Node class
	 * 
	 * class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
		}
	}
	 */
	
	private static boolean isSibling(BinaryTreeNode<Integer> root,int p, int q) {
		if(root==null)
			return false;
		if(root.left!=null && root.right!=null) {
			if(root.left.data==p && root.right.data==q) {
				return true;
			}
			else if(root.left.data==q && root.right.data==p) {
				return true;
			}
			else {
				return isSibling(root.left, p, q) || isSibling(root.right, p, q);
			}
		}
		if(root.left!=null) {
			return isSibling(root.left, p, q);
		}
		if(root.right!=null) {
			return isSibling(root.right, p, q);
		}
		return false;
	}
	private static int depth(BinaryTreeNode<Integer> root,int nodeData) {
		if(root == null) {
			return -1;
		}
		if(root.data == nodeData) {
			return 0;
		}
		int left = depth(root.left, nodeData); 
		if(left!=-1) {
			return left + 1;
		}
		else {
			int right = depth(root.right, nodeData); 
			if(right!=-1) {
				return right + 1;
			}
			else {
				return -1;
			}
		}
	}
	public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
		// Write your code here
		if(depth(root,p) == depth(root, q) && !isSibling(root, p, q))
			return true;
        return false;
	}
}


