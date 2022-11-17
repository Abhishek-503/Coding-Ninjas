package com.ninja.stack;

import com.ninja.exception.StackUnderflowException;
import com.ninja.linkedlist.LinkedListNode;

public class StackLL<T> {
	private LinkedListNode<T> head;
	private int size;
	public int length() {
		return size;
	}
	public void push(T i) {
		LinkedListNode<T> temp = new LinkedListNode<>(i);
		temp.next = head;
		head = temp;
		size++;
	}
	public T top() throws StackUnderflowException {
		// TODO Auto-generated method stub
		if(head==null) {
			throw new StackUnderflowException("Stack is Empty");
		}
		return head.data;
	}
	public T pop() throws StackUnderflowException {
		if(head==null) {
			throw new StackUnderflowException("Stack is Empty");
		}
		T data = head.data;
		head = head.next;
		size--;
		return data;
	}
	public boolean isEmpty() {
//		if(head==null) {
//			return true;
//		}
//		return false;
		return size==0;
	}
	
	
}
