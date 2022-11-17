package com.ninja.stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class RemoveRedundantBrackets {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {

    	String expression = br.readLine().trim();
    	System.out.println(RemoveRedundantBracketsSol.checkRedundantBrackets(expression));
    }
}
class RemoveRedundantBracketsSol {

	public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> st = new Stack<>();
        char[] str = expression.toCharArray();
        // Iterate through the given expression
        for (char ch : str) {
 
            // if current character is close parenthesis ')'
            if (ch == ')') {
                char top = st.peek();
                st.pop();
 
                // If immediate pop have open parenthesis '('
                // duplicate brackets found
                boolean flag = true;
 
                while (top != '(') {
 
                    // Check for operators in expression
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') {
                        flag = false;
                    }
 
                    // Fetch top element of stack
                    top = st.peek();
                    st.pop();
                }
 
                // If operators not found
                if (flag == true) {
                    return true;
                }
            } else {
                st.push(ch); // push open parenthesis '(',
            }                // operators and operands to stack
        }
        return false;
	}
}