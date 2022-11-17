package com.ninja.trees;

import java.util.Scanner;

public class NodeGreaterThanX {
	static Scanner s = new Scanner(System.in);

	public static TreeNode<Integer> takeInputLevelWise(){
	QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>();  // Queue of node that are entered themselves but their children aren't added yet
//	System.out.println("Enter root Data");
	int rootData = s.nextInt();
	TreeNode<Integer> root = new TreeNode<Integer>(rootData);
	pendingNodes.enqueue(root);
	while(!pendingNodes.isEmpty()){
		TreeNode<Integer> currentNode;
		try {
			currentNode = pendingNodes.dequeue();
//			System.out.println("Enter number of children of "+currentNode.data);
			int numChild = s.nextInt();
			for(int i = 0 ; i < numChild; i++){
//				System.out.println("Enter "+ i + "th child of " + currentNode.data);
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


public static void main(String[] args) {
	int x = s.nextInt();
		TreeNode<Integer> root =  takeInputLevelWise();
		System.out.println(NodeGreaterThanXSol.numNodeGreater(root, x));
	}
}

class NodeGreaterThanXSol {
	public static int numNodeGreater(TreeNode<Integer> root,int x){

		// Write your code here		
        if(root==null){
            return 0;
        }
        int d = root.data;
        int count = 0;
        if(d>x){
            count++;
        }
        for(int i = 0;i<root.children.size();i++){
            int c = numNodeGreater(root.children.get(i),x);
            count += c;
        }
        return count;

	}
}
