package com.ninja.queue;

public class CircularQueue {

}
class CircularQueueSol {
	int size;
	int rear;
	int front;
	int arr[];
	CircularQueueSol(int capacity){
		arr = new int[capacity];
		front = -1;
		rear = -1;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public boolean isFull() {
		return size==arr.length;
	}
	
	public void enqueue(int element) {
		if(isFull()) {
			//Double capacity
		}
		if(size==0) {
			front = 0;
		}
//		rear++;
//		if(rear==arr.length) {
//			rear = 0;
//		}
		rear = (rear+1)%arr.length;
		arr[rear] = element;		
		size++;
	}
	
	public int dequeue(int element) {
		if(isEmpty()) {
			//Double capacity
		}
		int temp = arr[front];
		front = (front+1)%arr.length;	
		size--;
		if(size==0) {
			rear = -1;
			front = -1;
		}
		return temp;
	}
}