// Adjacency List Representation of Graph

import java.util.*;
import java.util.Scanner.*;

class Node
{
	int des;
	Node next;

	Node(int d)
	{ 
		des = d;
		next = null;
	}
}

class Graph
{
	int vert,edge;
	Node adjList[];
	Scanner in = new Scanner(System.in);

	Graph(int v, int e)
	{
		vert = v;
		edge = e;
		adjList = new Node[vert];
		Arrays.fill(adjList,null);
	}

// function to add edges

	void addEdges(int src, int des)
	{
		Node ptr = new Node(des);

		if(adjList[src] != null)
		{
			ptr.next = adjList[src];
			adjList[src] = ptr;
		}	
		else
			adjList[src] = ptr;
	}

// function to create adjacency list

	void create()
	{
		int src,des;
		for(int i=0;i<edge;i++)
		{
			System.out.print("enter source and destination vertices : ");
			src = in.nextInt();
			des = in.nextInt();

			addEdges(src,des);
		//	addEdges(des,src); // uncomment this for undirected graphs
		}

	}

// function to dispaly adjacency list

	void display()
	{
		Node temp;
		for(int i=0;i<vert;i++)
		{
			temp = adjList[i];
			System.out.print("vertex "+i+" : ");

			while(temp!=null)
			{
				System.out.print(temp.des+" ");
				temp = temp.next;
			}
			System.out.println();
		}
	}

// breadth first traversal for connected graphs

	void bfsUtil(int start, boolean visited[])
	{
		LinkedList<Integer> pq = new LinkedList<Integer>();

		pq.add(start);
		visited[start] = true;

		while(pq.size()>0)
		{
			int current = pq.poll();
			System.out.print(current+" ");
			Node temp = adjList[current];

			while(temp!=null)
			{
				if(!visited[temp.des])
				{
					visited[temp.des] = true;
					pq.add(temp.des);
				}	
				temp = temp.next;	
			}	
		}
		System.out.println();
	}

// additional function for bfs of disconnected graphs

	void bfs()
	{
		boolean visited[] = new boolean[vert];

		for(int i=0;i<vert;i++)
		{
			if(!visited[i])
				bfsUtil(i,visited);
		}
	}

// depth first search for connected graphs

	void dfsUtil(int current, boolean visited[])
	{
		System.out.print(current+" ");
		visited[current] = true;

		Node temp = adjList[current];

		while(temp!=null)
		{
			if(!visited[temp.des])
				dfsUtil(temp.des,visited);

			temp = temp.next;
		}
	}

// additional function for dfs of disconnected graphs

	void dfs()
	{
		boolean visited[] = new boolean[vert];
		for(int i=0;i<vert;i++)
		{
			if(!visited[i])
				dfsUtil(i,visited);
		}
		System.out.println();
	}


}

class Main
{
	public static void main(String args[])
	{
		Scanner in = new Scanner(System.in);
		int vert,edge;
		System.out.print("enter the no of vertices and edges : ");
		vert = in.nextInt();
		edge = in.nextInt();
		
		Graph g = new Graph(vert,edge);
		g.create();
		g.display();

		g.bfs();
		g.dfs();
	}
}
