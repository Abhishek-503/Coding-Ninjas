package com.ninja.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EvenAfterOdd {
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

            LinkedListNode<Integer> newHead = EvenAfterOddSol.evenAfterOdd(head);
            print(newHead);

            t -= 1;
        }

    }
}

class EvenAfterOddSol {

	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		if(head==null || head.next==null){
            return head;
        }
        LinkedListNode<Integer> oddList = null, oddTail = null;
        LinkedListNode<Integer> evenList = null, evenTail = null;
        LinkedListNode<Integer> temp = head;
		while(temp!=null){
            if(temp.data%2!=0){
                if(oddList!=null){
                    oddTail.next = new LinkedListNode<>(temp.data);
                	oddTail = oddTail.next;
                }
                else{
                    oddList = new LinkedListNode<>(temp.data);
            		oddTail = oddList;
                }
            }
            else{
                if(evenList!=null){
                    evenTail.next = new LinkedListNode<>(temp.data);
                	evenTail = evenTail.next;
                }
                else{
                    evenList = new LinkedListNode<>(temp.data);
            		evenTail = evenList;
                }
                
            }
            temp = temp.next;
        }
        
        if(oddTail!=null)
        	oddTail.next = evenList;
        else
            oddList = evenList;
        return oddList;
	}
}
