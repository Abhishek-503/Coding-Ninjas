package com.ninja.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DeleEveryNnodes {
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
            String[] m_n = br.readLine().trim().split("\\s");

            int m = Integer.parseInt(m_n[0]);
            int n = Integer.parseInt(m_n[1]);

            LinkedListNode<Integer> newHead = DeleEveryNnodesSol.skipMdeleteN(head, m, n);
            print(newHead);
            
            t -= 1;
        }

    }
}

class DeleEveryNnodesSol {
	
	public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		//Your code goes here
        LinkedListNode<Integer> temp = head;
        LinkedListNode<Integer> tail = head;
        if(M==0){
            return null;
        }
        while(true){
            int count = M;
            while(tail!=null && count>1){
                tail = tail.next;
                count--;
            }
            if(tail==null)
                break;
            LinkedListNode<Integer> temp1 = tail;
            int count1 = N;
            while(temp1.next!=null && count1>0){
                temp1 = temp1.next;
                count1--;
            }
            tail.next = temp1.next;
            tail = tail.next;
            if(tail==null)
                break;
            
        }
        return temp;
	}
}
