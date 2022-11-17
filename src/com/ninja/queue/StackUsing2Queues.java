package com.ninja.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class StackUsing2Queues {

	private static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		StackUser stack = new StackUser();

		int q = s.nextInt();

		while (q > 0) {
			int choice, input;
			choice = s.nextInt();

			switch(choice) {
				case 1:
					input = s.nextInt();
					stack.push(input);
					break;

				case 2:
					System.out.println(stack.pop());
					break;

				case 3:
					System.out.println(stack.top());
					break;

				case 4:
					System.out.println(stack.getSize());
					break; 

				default: 
					System.out.println((stack.isEmpty()) ? "true" : "false");
			}

			q -= 1;
		}

	}

}


class StackUser {

    //Define the data members
	Queue<Integer> q1,q2;


    public StackUser() {
        //Implement the Constructor
    	q1 = new LinkedList<>();
    	q2 = new LinkedList<>();
    }



    /*----------------- Public Functions of Stack -----------------*/


    public int getSize() { 
        //Implement the getSize() function
    	return q1.size();
    }

    public boolean isEmpty() {
        //Implement the isEmpty() function
    	return q1.isEmpty();
    }

    public void push(int element) {
        //Implement the push(element) function
    	if(q1.isEmpty()) {
    		q1.add(element);
    	}
    	else {
    		while(!q1.isEmpty()) {
    			q2.add(q1.poll());
    		}
    		q1.add(element);
    		while(!q2.isEmpty()) {
    			q1.add(q2.poll());
    		}
    	}
    	
    }

    public int pop() {
        //Implement the pop() function
    	return q1.poll();
    }

    public int top() {
        //Implement the top() function
    	return q1.peek();
    	
    }
}