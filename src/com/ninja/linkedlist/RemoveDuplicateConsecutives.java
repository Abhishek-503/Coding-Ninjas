package com.ninja.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RemoveDuplicateConsecutives {
    
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

            head = RemoveDuplicateConsecutivesSol.removeDuplicates(head);
            print(head);

            t -= 1;
        }
        
    }
}
class RemoveDuplicateConsecutivesSol {
	public static LinkedListNode<Integer> removeDuplicates(LinkedListNode<Integer> head) {
		//Your code goes here
        if(head==null)
            return head;
        LinkedListNode<Integer> temp = head;
        while(temp!=null && temp.next!=null){
        	System.out.println(temp.data+","+temp.next.data);
            if(temp.data.equals(temp.next.data)){
                if(temp.next.next!=null){
                    temp.next = temp.next.next;
                }
                else{
                     temp.next = null;
               		 break;	
                }
                   
            }
            else
            	temp = temp.next;
        }
        
        return head;
	}
}

class ReverseLLSol {

	public static void printReverse(LinkedListNode<Integer> root) {
		if(root==null){
            return;
        }
        printReverse(root.next);
        System.out.print(root.data+" ");
	}

}
