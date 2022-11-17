package com.ninja.linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PalindromeLL {
    
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

            boolean ans = PalindromeLLSol.isPalindrome(head);
            System.out.println(ans);

            t -= 1;

        }
        
    }
}

class PalindromeLLSol {

	private static int getLength(LinkedListNode<Integer> head){
        int count = 0;
        while(head!=null){
            count++;
            head = head.next;
        }
        return count;
    }
    
	public static boolean isPalindrome(LinkedListNode<Integer> head) {
		int len = getLength(head);
        int res = 0;
        int indexEle = 0;
        if(len%2==0){
            LinkedListNode<Integer> temp = head;
            while(temp!=null){
            	res = res ^ temp.data;
            	temp = temp.next;
        	}
        }
        else{
            LinkedListNode<Integer> temp2 = head;
            
            int c = 0;
            while(temp2!=null){
            	res = res ^ temp2.data;
                
                if(c==len/2){
                    indexEle = temp2.data;
                }
                temp2 = temp2.next;   
                c++;
        	}  
        }
        System.out.println(res);
       if(res==0|| res==indexEle){
           return true;
       }
        return false;
	}

}