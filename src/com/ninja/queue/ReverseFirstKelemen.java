package com.ninja.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Input {
	int n;
	int k;
	Queue<Integer> queue;

	public Input(int n, int k, Queue<Integer> queue) {
		this.queue = queue;
		this.n = n;
		this.k = k;
	}

}

public class ReverseFirstKelemen {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static Input takeInput() throws NumberFormatException, IOException {
    	String[] n_k = br.readLine().trim().split(" ");

    	int n = Integer.parseInt(n_k[0]);
    	int k = Integer.parseInt(n_k[1]);

    	String[] values = br.readLine().trim().split(" ");

    	Queue<Integer> queue = new LinkedList<>();

    	for (int i = 0; i < n; i++) {
    		queue.add(Integer.parseInt(values[i]));
    	}

    	return new Input(n, k, queue);

    }

    public static void main(String[] args) throws NumberFormatException, IOException {
    	Input input = takeInput();

    	int n = input.n;
    	int k = input.k;
    	Queue<Integer> queue = input.queue;

    	queue = ReverseFirstKelemenSol.reverseKElements(queue, k);


    	while (!queue.isEmpty()) {
    		System.out.print(queue.poll() + " ");
    	}
    }
}

class ReverseFirstKelemenSol {

    public static Queue<Integer> reverse(Queue<Integer> input, int k){
        if(input.size()==0){
            return input;
        }
        if(k == 0){
            return input;
        }
        int temp = input.poll();
        input = reverse(input, k-1);
        input.add(temp);
        return input;
    }
    
	public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
		//Your code goes here
        int count = input.size()-k;
        input = reverse(input, k);
        while(!input.isEmpty() && count>0){
            int temp = input.poll();
            input.add(temp);
            count--;
        }
        return input;
	}

}