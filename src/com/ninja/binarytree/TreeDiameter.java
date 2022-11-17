package com.ninja.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TreeDiameter {
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
	
		int d = TreeDiameterSol2.diameterOfBinaryTree(root);
		System.out.println(d);
	
	}
}

//class TreeDiameterSol {
//    private static int height(BinaryTreeNode<Integer> root){
//        if(root==null){
//            return 0;
//        }
//        int lh = height(root.left);
//        int rh = height(root.right);
//        return 1+Math.max(lh,rh);
//    }
//	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
//		//Your code goes here
//        if(root==null){
//            return 0;
//        }
//        int h = 1 + height(root.left) + height(root.right);
//        int ld = diameterOfBinaryTree(root.left);
//        int rd = diameterOfBinaryTree(root.right);
//        // System.out.println(h+ " "+ld+" "+rd);
//        return Math.max(h,Math.max(ld,rd));
//	}
//}

class Pair{
	int height;
	int diameter;
	Pair(int height, int diameter){
		this.height = height;
		this.diameter = diameter;
	}
}
class TreeDiameterSol2 {
   
	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
		//Your code goes here
        Pair p = getDiameter(root);
        return p.diameter;
	}
	
	private static Pair getDiameter(BinaryTreeNode<Integer> root) {
		if(root==null){
        	Pair p = new Pair(0,0);
            return p;
        }
     
        Pair p1 = getDiameter(root.left);
        Pair p2 = getDiameter(root.right);
        int dist = 1+p1.height+p2.height;
        int diam = Math.max(dist, Math.max(p1.diameter,p2.diameter));
        int h = Math.max(p1.height,p2.height)+1;
        return new Pair(h,diam);
	}
}
