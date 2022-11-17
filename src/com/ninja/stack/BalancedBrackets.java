package com.ninja.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BalancedBrackets {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String expression = br.readLine().trim();
        System.out.println(Solution.isBalanced(expression));
    }
}

class Solution {

    public static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0;i<expression.length();i++) {
        	char c = expression.charAt(i);
        	if(c=='{' || c=='(' || c=='[')
        		stack.push(c);
        	else {
        		if(!stack.isEmpty()) {
        			if((stack.peek()=='(' && c ==')') || (stack.peek()=='{' && c =='}') || (stack.peek()=='[' && c ==']'))
            			stack.pop();
        		}
        		else {
        			return false;
        		}
        		
        	}
        }
        if(stack.isEmpty()) {
        	return true;
        }
        return false;
    }
}
