/*Next larger element
Send Feedback
Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.
Return NULL if no node is present with value greater than n.
Input format :

Line 1 : Integer n

Line 2 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with value just greater than n.

Sample Input 1 :
18
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
20
Sample Input 2 :
21
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
30*/
package com.ninja.trees;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
public class NextlargerElement {
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


	public static void main(String[] args) {
		int n = s.nextInt();
		TreeNode<Integer> root =  takeInputLevelWise();

		TreeNode<Integer> ans = NextlargerElementSol.findNextLargerNode(root, n);
		if(ans == null){
			System.out.println(Integer.MIN_VALUE);
		}else{
			System.out.println(ans.data);
		}

	}

}


class NextlargerElementSol {

	/*	TreeNode structure 
	 * 
	 * class TreeNode<T> {
		T data;
		ArrayList<TreeNode<T>> children;

		TreeNode(T data){
			this.data = data;
			children = new ArrayList<TreeNode<T>>();
		}
	}*/
	public static TreeNode<Integer> ans;
	public static TreeNode<Integer> temp = null;
	public static Queue<TreeNode<Integer>> pendingNodes = new LinkedList<>();
	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){

		// Write your code here
		if (ans == null) {
			if (root.data > n) {
				ans = root;
			}
		} else {
			if (root.data < ans.data && root.data > n) {
				ans = root;
			}
		}
		for (int i = 0; i < root.children.size(); i++) {
			pendingNodes.add(root.children.get(i));
			try {
				temp = findNextLargerNode(pendingNodes.remove(), n);
				if (temp.data > n && temp.data < ans.data) {
//					if (temp.data < ans.data) {
//						ans = temp;
//					}
					ans = temp;
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return ans;
	}
	
//	public static TreeNode<Integer> findNextLargestNode(TreeNode<Integer> root, int n){
//		if(ans==null) {
//			if(root.data > n) {
//				ans = root;
//			}
//		}
//		else if(root.data > n && root.data < ans.data) {
//			ans = root;
//		}
//		for(int i = 0;i<root.children.size();i++) {
//			pendingNodes.add(root.children.get(i));
//			temp = findNextLargestNode(pendingNodes.poll(),n);
//			if(temp.data > n && temp.data < ans.data) {
//				ans = temp;
//			}
//		}
//		return ans;
//	}
}

