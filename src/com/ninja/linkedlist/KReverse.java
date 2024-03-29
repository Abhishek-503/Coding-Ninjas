package com.ninja.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KReverse {
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
        
        int t = Integer.parseInt(br.readLine().trim());

        while (t > 0) {
            
            LinkedListNode<Integer> head = takeInput();
            int k = Integer.parseInt(br.readLine().trim());

            LinkedListNode<Integer> newHead = KReverseSol.kReverse(head, k);
            print(newHead);
            
            t -= 1;
        }

    }
}

class KReverseSol {
	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
	    if(head==null){
	        return null;
	    }
	    if(k==0 || k==1){
	        return head;
	    }
	    LinkedListNode<Integer> prev = null;
	    LinkedListNode<Integer> curr = head;
	    LinkedListNode<Integer> currNext = curr.next;
	    LinkedListNode<Integer> tail = curr;
	    int count = k;
	    while(count>1 && currNext!=null){
	        curr.next = prev;
	        prev = curr;
	        curr = currNext;
	        currNext = currNext.next;
	        count--;
	    }
	    curr.next = prev;
	    if(currNext!=null){
	        tail.next = kReverse(currNext, k);
	        return curr;
	    }
	    else{
	        return curr;
	    }
	}
}
