package com.ninja.stack;

import com.ninja.exception.StackOverflowException;
import com.ninja.exception.StackUnderflowException;

public class StackUse {

	public static void main(String[] args) throws StackOverflowException, StackUnderflowException {
		StackArray stack = new StackArray();
		System.out.println(stack.isEmpty());
//		stack.pop();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(10);
		stack.push(20);
		stack.push(30);
		int topEle = stack.top();
		System.out.println(topEle);
		int len = stack.size();
		System.out.println(len);
		int popEle = stack.pop();
		System.out.println(popEle);
		stack.push(40);
		System.out.println(stack.top());
		boolean flag = stack.isEmpty();
		System.out.println(flag);

	}

}
