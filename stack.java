import java.util.*;
import java.util.Scanner.*;

class Stack
{
	int top;
	int size;
	int stack[];

	Stack(int s)
	{
		size = s;
		top = -1;
		stack = new int[size];
	}


// function to check stack is full
	
	boolean isFull()
	{
		return (top == size-1) ? true : false;
	}

// function to check stack is empty

	boolean isEmpty()
	{
		return (top == -1) ? true : false;
	}

// function to push into the stack

	void push(int data)
	{
		if(isFull())
			System.out.println("Stack is overflowed");
		else
		{
			stack[++top] = data;
			System.out.println(data+" is pushed into the stack");
		}
	}

// function to pop from the stack

	void pop()
	{
		if(isEmpty())
			System.out.println("stack is underflowed");
		else
		{
			int data = stack[top];
			stack[top--] = 0;
		 	System.out.println(data+" is poped out from the stack");
		}
	}

// function to return top element of the stack

	int peek()
	{
		if(!isEmpty())
			return stack[top];

		return Integer.MAX_VALUE;
	}
}

class Main
{
	public static void main(String args[])
	{
		Stack s = new Stack(5);
		s.push(10);
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		s.push(60);
		System.out.println(s.peek());
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		s.pop();
		System.out.println(s.peek());
		s.pop();
	}
}
