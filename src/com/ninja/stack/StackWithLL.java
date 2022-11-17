package com.ninja.stack;

import com.ninja.exception.StackUnderflowException;

public class StackWithLL {

	public static void main(String[] args) throws StackUnderflowException {
		StackLL<Integer> stack = new StackLL<>();
		System.out.println(stack.length());
//		System.out.println(stack.top());
		stack.push(10);
		System.out.println(stack.length());
		System.out.println(stack.top());
		stack.push(20);
		System.out.println(stack.top());
		System.out.println(stack.length());
		System.out.println(stack.isEmpty());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
	}

}
