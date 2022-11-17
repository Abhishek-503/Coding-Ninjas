package com.ninja.bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class NodetoRootPath {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	public static BinaryTreeNode<Integer> takeInput() throws IOException {
		st = new StringTokenizer(br.readLine());
		int rootData = Integer.parseInt(st.nextToken());
		if (rootData == -1) {
			return null;
		}
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			int leftChildData = Integer.parseInt(st.nextToken());
			if (leftChildData != -1) {
				BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<Integer>(leftChildData);
				currentNode.left = leftChild;
				pendingNodes.enqueue(leftChild);
			}
			int rightChildData = Integer.parseInt(st.nextToken());
			if (rightChildData != -1) {
				BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<Integer>(rightChildData);
				currentNode.right = rightChild;
				pendingNodes.enqueue(rightChild);
			}
		}
		return root;
	}

	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		int k = Integer.parseInt(br.readLine());
		ArrayList<Integer> output = NodetoRootPathSol.getPath(root, k);
		if(output != null) {
			for(int i : output) {
				System.out.print(i+" ");
			}
		}
	}

}

class NodetoRootPathSol {
	public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
		if(root==null){
            return null;
        }
        if(root.data==data){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(root.data);
            return list;
        }
        if(root.data<=data){
            ArrayList<Integer> arrRight = getPath(root.right, data);
            if(arrRight!=null){
                arrRight.add(root.data);
            	return arrRight;
            }
            
        }
        if(root.data>data){
            ArrayList<Integer> arrLeft = getPath(root.left, data);
            if(arrLeft!=null){
                arrLeft.add(root.data);
            	return arrLeft;
            }
        }
        return null;
	}
}
