import java.util.*;
import java.util.Scanner.*;

class Queue
{
	int Front,Rear,size;
	int queue[];

	Queue(int s)
	{
		size = s;
		Front = 0;
		Rear = -1;
		queue = new int[size];
	}

// function to check queue is full

	boolean isFull()
	{
		return (Rear == size-1) ? true : false;
	}

// function to check queue is empty

	boolean isEmpty()
	{
		return (Front == Rear+1) ? true : false;
	}

// function to insert into the queue

	void enqueue(int data)
	{
		if(isFull())
			System.out.println("Queue is overflowed");
		else
		{
			queue[++Rear] = data;
			System.out.println(data+" is enqueued");
		}
	}

// function to remove from the queue

	void dequeue()
	{
		if(isEmpty())
			System.out.println("Queue is underflowed");
		else
		{
			int data = queue[Front];
			queue[Front++] = 0;
			System.out.println(data+" is dequeued");
		}

	}

// function to return front element

	int front()
	{
		if(!isEmpty())
			return queue[Front];
		return Integer.MIN_VALUE;// return minimum value when queue is empty
	}

// function to return rear element

	int rear()
	{
		if(!isEmpty())
			return queue[Rear];
		return Integer.MIN_VALUE;// return minimum value when queue is empty
	}

}

class Main
{
	public static void main(String args[])
	{
		Queue q = new Queue(5);
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.enqueue(40);
		q.enqueue(50);
		q.enqueue(60);
		System.out.println("front: "+q.front()+" rear: "+q.rear());
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		q.dequeue();
		System.out.println("front: "+q.front()+" rear: "+q.rear());
		q.dequeue();
	}
}
