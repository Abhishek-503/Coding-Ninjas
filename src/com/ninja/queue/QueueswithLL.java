package com.ninja.queue;

import com.ninja.exception.QueueEmptyException;
import com.ninja.linkedlist.Node;

public class QueueswithLL<T> {
	
	//Define the data members
    Node<T> front;
    Node<T> rear;
    int size;

	public QueueswithLL() {
		
	}
	


	/*----------------- Public Functions of Stack -----------------*/


	public int getSize() { 
		return size;
    }


    public boolean isEmpty() { 
    	return size==0;
    }


    public void enqueue(T data) {
    	//Implement the enqueue(element) function
    	Node<T> newNode = new Node<>(data);
        if(rear==null || front ==null){
            rear = newNode;
            front = rear;
            size++;
            return;
        }
        rear.next = newNode;
        rear = rear.next;
        size++;
    }


    public T dequeue() throws QueueEmptyException {
    	//Implement the dequeue() function
        if(front==null){
            throw new QueueEmptyException();
        }
        T temp = front.data;
        front = front.next;
        size--;
        return temp;
    }


    public T front() throws QueueEmptyException {
    	//Implement the front() function
        if(front==null){
            throw new QueueEmptyException();
        }
        return front.data;
    }
}