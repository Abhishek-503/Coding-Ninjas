package com.ninja.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelWise {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
		QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>(); 
		int start = 0;

		String[] nodeDatas = br.readLine().trim().split(" ");

		if (nodeDatas.length == 1) {
			return null;
		}

		int rootData = Integer.parseInt(nodeDatas[start]);
		start += 1;

		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while(!pendingNodes.isEmpty()){
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}

			int leftChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(leftChildData != -1){
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}

			int rightChildData = Integer.parseInt(nodeDatas[start]);
			start += 1;

			if(rightChildData != -1){
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}

		return root;
	}


	public static void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		
		PrintLevelWiseSol.printLevelWise(root);

	}
}

class PrintLevelWiseSol {
//	public static void printLevelWise(BinaryTreeNode<Integer> root) {
//		//Your code goes here
//		int h = height(root);
//		printLevelWiseHelper(root,h);
//		
//	}
//	public static void printLevelWiseHelper(BinaryTreeNode<Integer> root, int h) {
//		//Your code goes here
//		for(int i = 0;i<h;i++) {
//			printAtDepthK(root,i);
//			System.out.println();
//		}
//	}
//    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k){
//        if(root==null){
//            return;
//        }
//        if(k==0){
//            System.out.print(root.data+" ");
//            return;
//        }
//
//        printAtDepthK(root.left, k-1);
//        printAtDepthK(root.right, k-1);
//    }
//	public static int height(BinaryTreeNode<Integer> root) {
//		//Your code goes here
//        if(root==null){
//            return 0;
//        }
//        int leftHeight = height(root.left);
//        int rightHeight = height(root.right);
//        return 1+Math.max(leftHeight,rightHeight);
//	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		if(root==null) {
			return;
		}
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();
			if(node==null) {
				System.out.println();
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			}
			else {
				System.out.print(node.data+" ");
				if(node.left!=null) {
					queue.add(node.left);
				}
				if(node.right!=null) {
					queue.add(node.right);
				}
			}
		}
		
	}
}