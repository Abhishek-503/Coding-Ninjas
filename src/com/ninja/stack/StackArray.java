package com.ninja.stack;

import com.ninja.exception.StackOverflowException;
import com.ninja.exception.StackUnderflowException;

public class StackArray {
	
	private int data[];
	private int topIndex;

	public StackArray() {
		super();
		this.data = new int[5];
		this.topIndex = -1;
	}

	public int size() {
		return topIndex;
	}

//	public void push(int i) throws StackOverflowException{
//		if(size()==data.length-1) {
//			throw new StackOverflowException("Stack Overflow");
//		}
//		this.data[++topIndex] = i;
//	}
	
	public void push(int i) {
		if(size()==data.length-1) {
			doubleCapacity();
		}
		this.data[++topIndex] = i;
	}

	public int pop() throws StackUnderflowException{
		if(isEmpty()) {
			throw new StackUnderflowException("Stack Underflow");
		}
		return this.data[topIndex--];
	}

	public boolean isEmpty() {
		if(topIndex!=-1) {
			return false;
		}
		return true;
	}

	public int top() {
		if(!isEmpty()) {
			return this.data[topIndex];
		}
		return -1;
	}
	
	private void doubleCapacity() {
		int temp[] = data;
		data = new int[2*temp.length];
		for(int i = 0;i<temp.length;i++) {
			data[i] = temp[i];
		}
	}
	
}
