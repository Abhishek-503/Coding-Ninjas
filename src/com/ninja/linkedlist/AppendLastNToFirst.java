package com.ninja.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AppendLastNToFirst {
static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static LinkedListNode<Integer> takeInput() throws IOException {
        LinkedListNode<Integer> head = null, tail = null;

        String[] datas = br.readLine().trim().split("\\s");

        int i = 0;
        while (i < datas.length && !datas[i].equals("-1")) {
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

            int n = Integer.parseInt(br.readLine().trim());
            head = AppendLastNToFirstSol.appendLastNToFirst(head, n);
            print(head);

            t -= 1;
        }
        
    }
}

class AppendLastNToFirstSol {

	public static LinkedListNode<Integer> appendLastNToFirst(LinkedListNode<Integer> head, int n) {
		if(head==null) {
			return head;
		}
		LinkedListNode<Integer> tail=head;
		LinkedListNode<Integer> temp;
        int count = 1;
		while(tail.next!=null) {
			tail = tail.next;
			count++;
		}
//		System.out.println(count);
        int toBemoved = count-n;
        while(toBemoved>=1) {
        	temp = head;
        	head = head.next;
        	tail.next = temp;
        	tail = tail.next;
        	tail.next = null;
        	toBemoved--;
        }
//        System.out.println(toBemoved);
		return head;
	}

	
}