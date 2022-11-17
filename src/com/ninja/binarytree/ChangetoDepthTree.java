package com.ninja.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChangetoDepthTree {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public BinaryTreeNode<Integer> takeInput() throws NumberFormatException, IOException {
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

	public void inOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}

		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);

	}

	public void main(String[] args) throws NumberFormatException, IOException {
		BinaryTreeNode<Integer> root = takeInput();
		
		ChangetoDepthTreeSol.changeToDepthTree(root);
		inOrder(root);
	}

		
}
	
class ChangetoDepthTreeSol {

	public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
	    //Your code goes here
        depthTree(root,0);
	}
    
    public static void depthTree(BinaryTreeNode<Integer> root, int depth) {
	    //Your code goes here
        if(root==null){
            return;
        }
        root.data = depth;
        if(root.left!=null){
            depthTree(root.left, depth+1);
        }
        if(root.right!=null){
            depthTree(root.right, depth+1);
        }
	}

}	
