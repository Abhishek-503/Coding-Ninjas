package com.ninja.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class PrintLevelOrder {
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
		
		PrintLevelOrderSol.printLevelWise(root);
	}
}

class PrintLevelOrderSol {

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		//Your code goes here
        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
        if(root.data==-1){
            return;
        }
        queue.add(root);
        while(!queue.isEmpty()){
            BinaryTreeNode<Integer> first = queue.poll();
            String str = ""+first.data;
            if(first.left!=null){
                str += ":L:"+first.left.data+",";
                queue.add(first.left);
            }
            else{
                str += ":L:-1,";
            }
            if(first.right!=null){
                str += "R:"+first.right.data;
                queue.add(first.right);
            }
            else{
                str += "R:-1";
            }
            System.out.println(str);
        }
	}
	
}
