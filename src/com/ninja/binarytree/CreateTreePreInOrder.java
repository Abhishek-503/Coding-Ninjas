package com.ninja.binarytree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Pair2 {
	int[] preOrder;
	int[] inOrder;

	public Pair2(int[] preOrder, int[] inOrder) {
		this.preOrder = preOrder;
		this.inOrder = inOrder;
	}

}
public class CreateTreePreInOrder {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static Pair2 takeInput() throws NumberFormatException, IOException {
    	int n = Integer.parseInt(br.readLine().trim());

    	int pre[] = new int[n];
    	int in[] = new int[n];

    	String[] preOrder = br.readLine().trim().split(" ");
    	String[] inOrder = br.readLine().trim().split(" ");


    	for (int i = 0; i < n; i++) {
    		pre[i] = Integer.parseInt(preOrder[i].trim());
    		in[i] = Integer.parseInt(inOrder[i].trim());
    	}

    	return new Pair2(pre, in);

    }

	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		
		Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
		pendingNodes.add(root);
        pendingNodes.add(null);

		while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> frontNode = pendingNodes.poll();

        
	        if (frontNode == null) {
	            System.out.println();

	            if (!pendingNodes.isEmpty()) {
	                pendingNodes.add(null);
	            }

	        } else {
	        	System.out.print(frontNode.data + " ");

	            if (frontNode.left != null) {
	                pendingNodes.add(frontNode.left);
	            } 

	            if (frontNode.right != null) {
	                pendingNodes.add(frontNode.right);
	            } 
	        }

		}
		
	}
    public static void main(String[] args) throws NumberFormatException, IOException {

    	Pair2 input = takeInput();

    	int[] preOrder = input.preOrder;
    	int[] inOrder = input.inOrder;

    	BinaryTreeNode<Integer> root = CreateTreePreInOrderSol.buildTree(preOrder, inOrder);

    	printLevelWise(root);

    }
}

class CreateTreePreInOrderSol {

	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
		//Your code goes here
        if(preOrder.length==0){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preOrder[0]);
        int index = -1;
        for(int i = 0;i<inOrder.length;i++){
            if(inOrder[i]==root.data){
                index = i;
                break;
            }
        }
        if(index==-1){
            return null;
        }
        	
        int[] leftInOrder = new int[index];
        int[] rightInOrder = new int[index];
        for(int i = 0;i<index;i++){
            leftInOrder[i] = inOrder[i];
        }
        for(int i = index+1;i<inOrder.length;i++){
            rightInOrder[i-(index+1)] = inOrder[i];
        }
        index = leftInOrder.length;
        int[] leftPreOrder = new int[index];
        int[] rightPreOrder = new int[index];
        for(int i = 1;i<index+1;i++){
            leftPreOrder[i-1] = preOrder[i];
        }
        for(int i = index+1;i<preOrder.length;i++){
            rightPreOrder[i-(index+1)] = preOrder[i];
        }
        BinaryTreeNode<Integer> left = buildTree(leftPreOrder, leftInOrder);
        BinaryTreeNode<Integer> right = buildTree(rightPreOrder, rightInOrder);
        root.left = left;
        root.right = right;
        return root;
	}

}