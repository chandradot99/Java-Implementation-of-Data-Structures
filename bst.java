import java.util.*;
import java.util.Scanner.*;

class Node
{
	int data;
	Node left,right;

	Node(int d)
	{
		data = d;
		left = right = null;
	}

}

class BST
{
	Node root;

	Scanner in = new Scanner(System.in);

	BST()
	{
		root = null;
	}


// function to insert new node into bst
 	
	Node insert(Node root, int data)
	{
		if(root == null)
			return new Node(data);
		else if(data < root.data)
			root.left = insert(root.left,data);
		else if(data > root.data)
			root.right = insert(root.right,data);
		else
			System.out.println(data+" is already present");

		return root;

	}

// function to create a bst

	void create()
	{
		int data;
		char ch;
		while(true)
		{
			System.out.print("enter data for new node : ");
			data = in.nextInt();

			if(root == null)
				root = new Node(data);
			else
				root = insert(root,data);
			
			System.out.print("more nodes(y/n) ");
			ch = in.next().charAt(0);
			if(ch == 'n')
				break;
		}
	}

// preorder traversal of bst

	void preorder(Node root)
	{
		if(root == null)
			return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
	}

// inorder traversal of bst

	void inorder(Node root)
	{
		if(root == null)
			return;
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}

// postorder traversal of bst

	void postorder(Node root)
	{
		if(root == null)
			return;

		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}

// function to display bst

	void display()
	{
		preorder(root);
		System.out.println();
		inorder(root);
		System.out.println();
		postorder(root);
		System.out.println();
	}
}

class Main
{
	public static void main(String args[])
	{
		BST t = new BST();
		t.create();
		t.display();
	}
}
