package com.ninja.queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueue {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static Queue<Integer> takeInput() throws NumberFormatException, IOException {

		int n = Integer.parseInt(br.readLine().trim());

		String[] values = br.readLine().trim().split(" ");

		Queue<Integer> queue = new LinkedList<>();

		for (int i = 0; i < n; i++) {
			queue.add(Integer.parseInt(values[i]));
		}

		return queue;

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		int t = Integer.parseInt(br.readLine().trim());

		while (t > 0) {
			Queue<Integer> queue = takeInput();
			ReverseQueueSol.reverseQueue(queue);

			while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}

			System.out.println();

			t -= 1;
		}
	}
}
class ReverseQueueSol {

	public static void reverseQueue(Queue<Integer> input) {
		//Your code goes here
        if(input.size()==0){
            return;
        }
        int temp = input.poll();
        reverseQueue(input);
        input.add(temp);
        
	}

}