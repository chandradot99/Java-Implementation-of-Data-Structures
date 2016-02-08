import java.util.*;
import java.util.Scanner.*;

class Node
{
	int data;
	Node next;

	Node(int d)
	{
		data = d;
		next = null;
	}
}

class List
{
	Node head;
	Scanner in = new Scanner(System.in);

	List()
	{
		head = null;
	}

// function to create a linked list

	void create()
	{
		int data;
		Node ptr;
		char ch;
		while(true)
		{
			System.out.print("enter the data for the new node : ");
			data = in.nextInt();

			ptr = new Node(data);

			if(head == null)
			{
				head = ptr;
			}
			else
			{
				ptr.next = head;
				head = ptr;
			}

			System.out.print("more nodes?(y/n) ");
			ch = in.next().charAt(0);
			if(ch == 'n')
				break;
		}
	}

// function to display a list

	void display()
	{
		Node temp = head;

		while(temp!=null)
		{
			System.out.print(temp.data+" ");
			temp = temp.next;
		}	
	}

// recursive function to display list in reverse order

	void rDisplay(Node temp)
	{
		if(temp == null)
			return;

		rDisplay(temp.next);
		System.out.print(temp.data+" ");
	}

	void displayReverse()
	{
		rDisplay(head);
	}

// recursive function to reverse the order of the linked list

	Node rList(Node temp)
	{
		if(temp.next == null)
		{
			head = temp;
			return temp;
		}
		Node previous = rList(temp.next);
		previous.next = temp;
		temp.next = null;
		return temp;

	}

	void listReverse()
	{
		rList(head);
	}

}

class Main
{
	public static void main(String args[])
	{
		List l = new List();
		l.create();
		l.display();
		System.out.println();
		//l.displayReverse();
		System.out.println();
		l.listReverse();
		l.display();

	}
}
