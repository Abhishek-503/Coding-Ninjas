/*Level wise linkedlist
Send Feedback
Given a binary tree, write code to create a separate linked list for each level. You need to return the array which contains head of each level linked list.
Input format :
The first line of input contains data of the nodes of the tree in level order form. The data of the nodes of the tree is separated by space. If any node does not have left or right child, take -1 in its place. Since -1 is used as an indication whether the left or right nodes exist, therefore, it will not be a part of the data of any node.
Output format :
Each level linked list is printed in new line (elements are separated by space).
Constraints:
Time Limit: 1 second
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
Sample Output 1:
5 
6 10 
2 3 
9*/
package com.ninja.bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import com.ninja.linkedlist.LinkedListNode;

public class LevelwiseLL {
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
	
	private static void print(LinkedListNode<Integer> temp)
	{
		while(temp != null){
			System.out.print(temp.data + " ") ;
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException {
		BinaryTreeNode<Integer> root = takeInput();
		ArrayList<LinkedListNode<Integer>> output = LevelwiseLLSol.constructLinkedListForEachLevel2(root);
		if(output!=null)
		{
			for(LinkedListNode<Integer> head : output){
				print(head);
				
			}
		}
	}

}

class LevelwiseLLSol {

//	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
//		// Write your code here
//        if(root==null){
//            return null;
//        }
//        Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
//        Queue<Integer> queue2 = new LinkedList<>();
//        ArrayList<LinkedListNode<Integer>> list = new ArrayList<>();
//        queue.add(root);
//        queue.add(null);
//        queue2.add(root.data);
//        queue2.add(-1);
//        while(!queue.isEmpty()) {
//			BinaryTreeNode<Integer> node = queue.poll();
//			if(node==null) {
//				if(!queue.isEmpty()) {
//					queue.add(null);
//                    queue2.add(-1);
//				}
//			}
//			else {             
//				if(node.left!=null) {
//					queue.add(node.left);
//                    queue2.add(node.left.data);
//				}
//				if(node.right!=null) {
//					queue.add(node.right);
//                    queue2.add(node.right.data);
//				}
//			}
//		}
//
//        while(!queue2.isEmpty()) {
//        	LinkedListNode<Integer> head = null;
//        	LinkedListNode<Integer> tail = null;
//        	head = new LinkedListNode<Integer>(queue2.poll());
//        	tail = head;
//        	while(queue2.peek()!=-1 && !queue2.isEmpty()) {  
//        		LinkedListNode<Integer> node = new LinkedListNode<Integer>(queue2.poll());
//        		tail.next = node;
//        		tail = tail.next;
//        	}
//        	if(!queue2.isEmpty() && queue2.peek()==-1) {
//        		queue2.poll();
//        	}
//        	list.add(head);
//        	
//        }
//        return list;
//        
//	}

	public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel2(BinaryTreeNode<Integer> root){
		// Write your code here
        if(root==null){
            return null;
        }
        Queue<BinaryTreeNode<Integer>> pendingNodes = new LinkedList<>();
        ArrayList<LinkedListNode<Integer>> output = new ArrayList<>();
        pendingNodes.add(root);
        int currentLevelCount = 1;
        int nextLevel = 0;
        LinkedListNode<Integer> currHead = null;
        LinkedListNode<Integer> currTail = null;
        while(!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> node = pendingNodes.remove();
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(node.data);
			if(currHead == null) {
				currHead = newNode;
				currTail = newNode;
			}
			if(currHead != null) {
				currTail.next = newNode;
				currTail = newNode;
			}
			if(node.left!=null) {
				pendingNodes.add(node.left);	
				nextLevel++;
			}
			if(node.right!=null) {
				pendingNodes.add(node.right);
				nextLevel++;
			}
			currentLevelCount--;
			if(currentLevelCount==0) {
				output.add(currHead);
				currHead = null;
		        currTail = null;
		        currentLevelCount = nextLevel;
		        nextLevel = 0;
			}
		}
        return output;
	}
}
