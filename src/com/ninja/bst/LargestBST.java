package com.ninja.bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LargestBST {
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
		System.out.println(LargestBSTSol.largestBSTSubtree(root));
	}
}
class LargestBSTSol {
	/*
	 * BinaryTreeNode class
	 * 
	 * class BinaryTreeNode<T> 
	 * { 
	 * 		T data; 
	 * 		BinaryTreeNode<T> left; 
	 * 		BinaryTreeNode<T> right;
	 *		public BinaryTreeNode(T data) 
	 *		{
	 *  		this.data = data; 
	 *  	} 
	 *  }
	 */
	
//     private static int height(BinaryTreeNode<Integer> root){
//         if(root == null){
//             return 0;
//         }
//         return 1+Math.max(height(root.right),height(root.left));
//     }
    
//     public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
//         // System.out.println(isBST(root));
//         if(isBST(root)){
//             return height(root);
//         }
//         else{
//             if(root.left==null && root.right!=null){
//                 return largestBSTSubtreeHelper(root.right)-1;
//             }
//             else if(root.left!=null && root.right==null){
//                 return largestBSTSubtreeHelper(root.left)-1;
//             }
//             else{
//                 return Math.max(largestBSTSubtreeHelper(root.left),largestBSTSubtreeHelper(root.right));
//             }
//         }
//     }
    
// 	private static int largestBSTSubtreeHelper(BinaryTreeNode<Integer> root) {
// 		// Write your code here
//         boolean left = isBST(root.left);
//         boolean right = isBST(root.right);
//         int leftHeight = height(root.left);
//         int rightHeight = height(root.right);
//         if(left||right){
//             return Math.max(leftHeight,rightHeight);
//         }
//         else{
//             return Math.max(largestBSTSubtreeHelper(root.left),largestBSTSubtreeHelper(root.right));
//         }
// 	}

//     public static boolean isBST(BinaryTreeNode<Integer> root) {
// 		return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
// 	}

// 	private static boolean helper(BinaryTreeNode<Integer> root, int minValue, int maxValue) {
// 		// TODO Auto-generated method stub
// 		if(root==null)
// 			return true;
// 		if(root.data>minValue && root.data<=maxValue) {
// 			boolean b1 = helper(root.left, minValue, root.data-1);
// 			boolean b2 = helper(root.right, root.data, maxValue);
// 			return b1&&b2;
// 		}
// 		else
// 			return false;
// 	}
    
	private static class BstTracker{
		int min;
		int max;
		boolean isbst;
		int height;
	}
	
	private static BstTracker largestBST(BinaryTreeNode<Integer> root) {
		if(root==null) {
			BstTracker t = new BstTracker();
			t.min = Integer.MAX_VALUE;
			t.max = Integer.MIN_VALUE;
			t.isbst = true;
			t.height = 0;
			return t;
		}
		BstTracker left = largestBST(root.left);
		BstTracker right = largestBST(root.right);
		BstTracker ans = new BstTracker();
		if(left.isbst && right.isbst && root.data>left.max && root.data<=right.min) {
			ans.isbst = true;
		}
		else {
			ans.isbst = false;
		}
		ans.min = Math.min(root.data, left.min);
		ans.max = Math.max(root.data, right.max);
		
		if(ans.isbst) {
			ans.height = Math.max(left.height,right.height) + 1;
		}
		else {
			ans.height = Math.max(left.height,right.height);
		}
		return ans;
	}
	public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
		BstTracker output = largestBST(root);
		return output.height;
		// Write your code here
	}
}