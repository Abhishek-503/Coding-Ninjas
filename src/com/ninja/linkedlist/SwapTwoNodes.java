package com.ninja.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwapTwoNodes {
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
	            String[] i_j = br.readLine().trim().split("\\s");

	            int i = Integer.parseInt(i_j[0]);
	            int j = Integer.parseInt(i_j[1]);

	            LinkedListNode<Integer> newHead = SwapTwoNodesSol.swapNodes(head, i, j);
	            print(newHead);
	            
	            t -= 1;
	        }

	    }
}

class SwapTwoNodesSol {

    private static int length(LinkedListNode<Integer> head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
	public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		if(i==j)
        	return head;
        if(head==null){
            return head;
        }
        
        if(i<length(head) && j<length(head)){
            LinkedListNode<Integer> prevNode1 = null;
            LinkedListNode<Integer> nextNode1 = null;
            LinkedListNode<Integer> prevNode2 = null;
            LinkedListNode<Integer> nextNode2 = null;
            LinkedListNode<Integer> temp = head;
            LinkedListNode<Integer> tail = head;
            LinkedListNode<Integer> node1 = null;
            LinkedListNode<Integer> node2 = null;
            int count = 0;
            while(tail!=null){

                if((i==0 && j==1)|| (j==1 && i==0)){
                    node1 = head;
                    node2 = head.next;
                    head = head.next.next;
                    node2.next = node1;
                    node1.next = head;
                    return node2;

                }
                else if((i==0 || j==0) && (j>1 || i>1)){
                    if((i==0 && count==j-1)||(j==0 && count==i-1)){
                        node1 = head;
                        node2 = tail.next;
                        prevNode2 = tail;
                        nextNode1 = head.next;
                        if(tail.next.next==null){
                            prevNode2.next = node1;
                            node1.next = null;
                            node2.next = nextNode1;
                            return node2;
                        }
                        else{
                            node1.next = tail.next.next;
                            prevNode2.next = node1;                                
                            node2.next = nextNode1;
                            return node2;
                        }                            
                    }
                }
                else if((i==j-1) && ((count==j-1) || (count==i-1))){
                    prevNode1 = tail;
                    node1 = tail.next;
                    node2 = tail.next.next;
                    nextNode2 = node2.next;
                    prevNode1.next = node2;
                    node2.next = node1;
                    node1.next = nextNode2;
                    return head;
                }
                else{
                    if(count==i-1){
                        prevNode1 = tail;
                        nextNode1 = tail.next.next;
                        node1 = tail.next;
                    }
                    if(count==j-1){
                        prevNode2 = tail;
                        nextNode2 = tail.next.next;
                        node2 = tail.next;
                    }
                }

                tail = tail.next;
                count++;
            }
            prevNode1.next = node2;
            node2.next = nextNode1;
            prevNode2.next = node1;
            node1.next = nextNode2;
            return temp;

        }
        else{
            return null;
        }
          
        
	}

}
