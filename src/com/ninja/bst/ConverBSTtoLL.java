package com.ninja.bst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.ninja.linkedlist.LinkedListNode;

public class ConverBSTtoLL {
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
		LinkedListNode<Integer> head = ConverBSTtoLLSolution.constructLinkedList(root);
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
class Tracker {
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
    public Tracker(LinkedListNode<Integer> head,LinkedListNode<Integer> tail){
        this.head = head;
        this.tail = tail;
    }
}

class ConverBSTtoLLSolution {


	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
       	Tracker tc = helper(root);
        if(root==null)
            return null;
       	return tc.head;
		
	}
    private static Tracker helper(BinaryTreeNode<Integer> root) {
		if(root==null){
            return null;
        }
        Tracker lt = helper(root.left);
        LinkedListNode<Integer> nextNode = new LinkedListNode<Integer>(root.data);  
        Tracker rt = helper(root.right);    
        Tracker track = null;
		if(lt==null && rt==null){
            track = new Tracker(nextNode,nextNode);
        }
        if(lt==null && rt!=null){
            nextNode.next = rt.head;
            track = new Tracker(nextNode,rt.tail);
        }
        if(lt!=null && rt==null){
            lt.tail.next = nextNode;
            track = new Tracker(lt.head,nextNode);
        }
        if(lt!=null && rt!=null){
            lt.tail.next = nextNode;
            nextNode.next = rt.head;
            track = new Tracker(lt.head,rt.tail);
        }
        return track;
	}
    
}