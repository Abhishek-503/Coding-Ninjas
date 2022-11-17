package com.ninja.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ReverseLL {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;
        StringTokenizer tk = new StringTokenizer(br.readLine());
		int data = Integer.parseInt(tk.nextToken());
		while(data != -1) {
			LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
			if(head == null) {
				head = newNode;
				tail = newNode;
			}
			else {
				tail.next = newNode;
				tail = newNode;
			}
			data = Integer.parseInt(tk.nextToken());
		}
		return head;
	}
	
	public static void print(LinkedListNode<Integer> head){
		while(head != null){
			System.out.print(head.data +" ");
			head = head.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws IOException{
        int t = Integer.parseInt(br.readLine().trim());
        while (t != 0){
            LinkedListNode<Integer> head = takeInput();
//            LinkedListNode<Integer> ans = ReverseLLSol2.reverse(head);
            LinkedListNode<Integer> ans = ReverseLLSol2.reverseRBest(head);
//            LinkedListNode<Integer> ans = ReverseLLSol2.reverse_I(head);
            print(ans);

            t--;
        }

	}
}

class ReverseLLSol2{
	public static LinkedListNode<Integer> reverse_I(LinkedListNode<Integer> head){
		DoubleNode ans = reverseList(head);
		return ans.head;
	}
	
	private static DoubleNode reverseList(LinkedListNode<Integer> head) {
		DoubleNode ans;
		if(head==null || head.next ==null) {
			ans = new DoubleNode(head, head);
			return ans;
		}
		DoubleNode smallNode = reverseList(head.next);
		smallNode.tail.next = head;
		head.next = null;
		ans = new DoubleNode();
		ans.head = smallNode.head;
		ans.tail = head;
		return ans;
	}
	
	public static LinkedListNode<Integer> reverse(LinkedListNode<Integer> head){
	if (head == null || head.next == null)
		 return head;
	LinkedListNode<Integer> prev = null;
	LinkedListNode<Integer> curr = head;
	LinkedListNode<Integer> next = curr.next;
	 while (next != null){
	 curr.next = prev;
	 prev = curr; 
	 curr = next;
	 next = next.next;
	 }
	 curr.next = prev;
	 return curr;
	}
	
	  public static LinkedListNode<Integer> reverseRBest(LinkedListNode<Integer> head){
		    if(head==null || head.next==null){
		        return head;
		    }
		    LinkedListNode<Integer> smallHead= reverseRBest(head.next);
		    LinkedListNode<Integer> reversedTail= head.next;
		    reversedTail.next= head;
		    head.next= null;
		    return smallHead;
		}
}