package com.ninja.trees;

import java.util.ArrayList;
import java.util.Scanner;

public class RemoveLeaves {
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

	public static void printTreeLevelWise(TreeNode<Integer> root){
		if(root == null) {
			return;
		}
		QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>(); 
		pendingNodes.enqueue(root);
		pendingNodes.enqueue(null);
		while(!pendingNodes.isEmpty()){
			TreeNode<Integer> currentNode = null;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				e.printStackTrace();
			}
			if(currentNode == null) {
				if(pendingNodes.isEmpty()) {
					break;
				}
				System.out.println();
				pendingNodes.enqueue(null);
				continue;
			}
			System.out.print(currentNode.data + " ");
			int numChild = currentNode.children.size();
			for(int i = 0 ; i < numChild; i++){
				pendingNodes.enqueue(currentNode.children.get(i));
			}
		}
	}

	public static void main(String[] args) {
		TreeNode<Integer> root =  takeInputLevelWise();
		root = RemoveLeavesSol.removeLeafNodes(root);
		printTreeLevelWise(root);
	}
}

class RemoveLeavesSol {
	public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
		/* Your class should be named Solution
		 * Don't write main().
		 * Don't read input, it is passed as function argument.
		 * Return output and don't print it.
	 	 * Taking input and printing output is handled automatically.
		*/
		if(root.children.size()==0 || root==null){
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0;i<root.children.size();i++){
            TreeNode<Integer> child = root.children.get(i);
            if(child.children.size()==0){
                list.add(i);
            }
        }
        for(int i = list.size()-1;i>=0;i--){
            int j = list.get(i);
            root.children.remove(j);
        }
        for(int i = 0;i<root.children.size();i++){        	
        	TreeNode<Integer> node = removeLeafNodes(root.children.get(i));
        	if(node==null) {
        		root.children.remove(i);
        	}
        }
        return root;
	}
}