package com.ninja.priorityQueue2;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class kLargestElements {
	static Scanner s = new Scanner(System.in);

	public static void main(String[] args) {
		int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = kLargestElementsSol.kLargest(input, k);
		for(int i : output) {
			System.out.println(i);
		}
		
	}
}
class kLargestElementsSol {

	public static ArrayList<Integer> kLargest(int input[], int k) {
		/* Your class should be named Solution
		* Don't write main().
		* Don't read input, it is passed as function argument.
		* Return output and don't print it.
		* Taking input and printing output is handled automatically.
		*/
		PriorityQueue<Integer> pq= new PriorityQueue<Integer> ();
		ArrayList<Integer> klargest = new ArrayList<>();
        for(int i=0;i<k;i++){
            pq.add(input[i]);
        }

        for(int i=k; i<input.length;i++){
            if(pq.peek()<input[i]){
                pq.poll();
                pq.add(input[i]);
            }
        }
        while(!pq.isEmpty()){
            klargest.add(pq.poll());
        }
        return klargest;
	}
}
