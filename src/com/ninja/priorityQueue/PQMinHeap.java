package com.ninja.priorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.ninja.exception.PriorityQueueException;

public class PQMinHeap {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		PQMinHeapImpl pq = new PQMinHeapImpl();
		int choice = Integer.parseInt(st.nextToken());
		while(choice != -1) {
			switch(choice) {
				case 1 : // insert
					int element = Integer.parseInt(st.nextToken());
					pq.insert(element);
					break;
				case 2 : // getMin
				try {
					System.out.println(pq.getMin());
				} catch (PriorityQueueException e) {
					System.out.println(Integer.MIN_VALUE);
					return;
				}
					break;
				case 3 : // removeMin
				try {
					System.out.println(pq.removeMin());
				} catch (PriorityQueueException e) {
					System.out.println(Integer.MIN_VALUE);
					return;
				}
					break;
				case 4 : // size
					System.out.println(pq.size());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice = Integer.parseInt(st.nextToken());
		}
	}

}
class PQMinHeapImpl {

	private ArrayList<Integer> heap;

	public PQMinHeapImpl() {
		heap = new ArrayList<Integer>();
	}

	boolean isEmpty() {
		return heap.size() == 0;
	}

	int size() {
		return heap.size();
	}

	int getMin() throws PriorityQueueException {
		if (isEmpty()) {
			// Throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}

	void insert(int element) {
		heap.add(element);
		int childIndex = heap.size() - 1;
		int parentIndex = (childIndex - 1) / 2;

		while (childIndex > 0) {
			if (heap.get(childIndex) < heap.get(parentIndex)) {
				int temp = heap.get(childIndex);
				heap.set(childIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childIndex = parentIndex;
				parentIndex = (childIndex - 1) / 2;
			} else {
				return;
			}
		}
	}

	int removeMin() throws PriorityQueueException{
		if(isEmpty()){
            throw new PriorityQueueException();
        }
        
        int ans = heap.get(0);
        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        int parentIndex = 0;
        int leftChildIndex = 1;
        int rightChildIndex = 2;
        
        while(leftChildIndex < heap.size()){
            int minIndex = parentIndex;
            if(heap.get(leftChildIndex) < heap.get(minIndex)){
                minIndex = leftChildIndex;
            }
            if(rightChildIndex < heap.size() && (heap.get(rightChildIndex) < heap.get(minIndex))){
                minIndex = rightChildIndex;
            }
            if(minIndex == parentIndex){
                break;
            }
    		int temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            parentIndex = minIndex;
            leftChildIndex = 2*parentIndex+1;
            rightChildIndex = 2*parentIndex+2;
            
        }
        return ans;
	}
}

