package com.ninja.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BubbleSortLL {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while(i < datas.length && !datas[i].equals("-1")) {
            int data = Integer.parseInt(datas[i]);
            LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(data);
            if(head == null) {
                head = newNode;
                tail = newNode;
            }
            else {
                tail.next = newNode;
                tail = newNode;
            }
            i += 1;
        }

        return head;
    }
    
    public static void print(LinkedListNode<Integer> head){
        while(head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        
        System.out.println();
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
    	LinkedListNode<Integer> head = takeInput(); 

    	head = BubbleSortLLSol.bubbleSort(head);
    	print(head);
    }
}
class BubbleSortLLSol {
	private static int length(LinkedListNode<Integer> head){
	    int count = 0;
	    while(head!=null){
	        count++;
	        head = head.next;
	    }
	    return count;
	}
	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		if(head==null){
	        return head;
	    }
	    int len = length(head);
	    
	    for(int i = 0;i<len-1;i++){
	        LinkedListNode<Integer> curr = head;
	        for(int j = 0; j<len-i-1;j++){
	            
	            int currData = curr.data;
	            int currNextData = curr.next.data;
	            if(currData>currNextData){
	                curr.data = currNextData;
	                curr.next.data = currData;
	            }
	            curr = curr.next;
	        }
	    }
	    return head;
	}
}
