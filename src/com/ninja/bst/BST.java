package com.ninja.bst;

public class BST {


	private BinaryTreeNode<Integer> root; 

	public Boolean search(int data){
		return searchhelper(data,root);
	} 
	private Boolean searchhelper(int data,BinaryTreeNode<Integer> root){
		if(root==null){
			return false;
		}
		if(root.data==data){
			return true;
		}
		if(root.data>data){
			return searchhelper(data,root.left);
		}else
		{
			return searchhelper(data,root.right);
		}
	}  

	public void insert(int data){
		root= insertDatahelper(data,root);
	}
	private BinaryTreeNode<Integer> insertDatahelper(int data,BinaryTreeNode<Integer> root){
		if(root==null){
			BinaryTreeNode<Integer> ans=new BinaryTreeNode<Integer>(data);
			return ans;
		}
		if(root.data<data){
			root.right=insertDatahelper(data,root.right);
		}
		else {
			root.left= insertDatahelper(data,root.left);
		}
		return root;
	}


	public void remove(int data){
		root=deleteData(data,root);
	}
	private BinaryTreeNode<Integer> deleteData(int data, BinaryTreeNode<Integer> root) {
		if (root == null) {
			return null;
		}
		if (data < root.data) {
			root.left = deleteData(data, root.left);
			return root;
		} else if (data > root.data) {
			root.right = deleteData(data, root.right);
			return root;
		} else {
			if (root.left == null && root.right == null) {
				return null;
			} else if (root.left == null) {
				return root.right;
			} else if (root.right == null) {
				return root.left;
			} else {
				int rightMax=  smallest(root.right);
				root.data= rightMax;
				BinaryTreeNode<Integer> outputRight= deleteData(rightMax, root.right);
				root.right= outputRight;
				return root;
			}
		}

	}

	public static int smallest(BinaryTreeNode<Integer> root){  
		/* loop down to find the rightmost leaf */
		if(root==null){
			return Integer.MAX_VALUE;
		}
		return Math.min(root.data,Math.min(smallest(root.left),smallest(root.right)));
	}  


	private void printTree (BinaryTreeNode<Integer> root){
		if(root==null){
			return ;
		}
		String toBePrinted = root.data+":";
		if(root.left!=null){
			toBePrinted+="L:"+root.left.data+",";
		}
		if(root.right!=null){
			toBePrinted+="R:"+root.right.data;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	public void printTree (){
		printTree(root);
	}
}