package GraphTraversal;

import java.util.Stack;

import Graph;

import java.util.Queue;
import java.util.LinkedList;


class Node {
	int data;
	Node link;
	public Node(int n) { // constructor
		data = n;
		link=null;
	}
	public Node(int n, Node tmpNode) {
		data=n;
		link=tmpNode;
	}
	
}

class Graph{
	int N=7;//������ ����
	Node header[]=new Node[N];
	boolean visited[]=new boolean[N]; // for traversal
	public Graph() {
	}
	public void build() {
		Node tmpNode;
		tmpNode= new Node(3, null); 
		tmpNode = new Node(2, tmpNode);
		tmpNode = new Node(1, tmpNode);
		header[0]= tmpNode;
		//you can do it this way
		header[1]=new Node (0, new Node(4,null));
		header[2]=new Node(0, new Node(4, new Node(5,null)));
		header[3]= new Node(0, new Node(5, null));
		header[4]=  new Node(1, new Node(5, new Node(6,null)));
		header[5]= new Node(2, new Node(3, new Node(6,null)));
		header[6]= new Node(4, new Node(5, null));
		
	}
	public void printList() {
		Node tmpNode;
		
		for (int i=0; i<N; i++) {
			tmpNode=header[i];
			System.out.print(i+" : ");
			while(tmpNode!=null) {
				System.out.print("->"+tmpNode.data);
				tmpNode=tmpNode.link;
			}
			System.out.println();
		}
		System.out.println();
		
	}
	public void DFS(int startV) {
		Node tmpNode;
		int v;
		for(int i=0; i<N;i++) {
			visited[i]=false;
		}
		Stack s = new Stack();
		s.push(startV);
		while(!s.isEmpty()) {// not stack empty
			v=(int)s.pop();
			if(visited[v]==false) { // not visited yet
				System.out.print("->" + v);
				visited[v]=true;
				
				// find adjacent vertex
				tmpNode=header[v];
				while(tmpNode!=null) {
					
					if(visited[tmpNode.data]==false) { // not visited yet
						s.push(tmpNode.data);
					}
					tmpNode=tmpNode.link;
				}
			}
			
		}
		System.out.println();
	}
	public void BFS(int startV) {
		Node tmpNode;
		int v;
		for(int i=0; i<N;i++) {
			visited[i]=false;
		}
		Queue<Integer> q = new LinkedList();
		q.add(startV);
		while(!q.isEmpty()) {// not stack empty
			v=(int)q.remove();
			if(visited[v]==false) { // not visited yet
				System.out.print("->" + v);
				visited[v]=true;
				
				// find adjacent vertex
				tmpNode=header[v];
				while(tmpNode!=null) {
					
					if(visited[tmpNode.data]==false) { // not visited yet
						q.add(tmpNode.data);
					}
					tmpNode=tmpNode.link;
				}
			}
			
		}
		System.out.println();
	}
}
public class GraphTraversal {

	public static void main(String[] args) {
		
		Graph g1 = new Graph();
		g1.build();
		System.out.println("print Graph ");
		g1.printList();
		System.out.println("DFS");
		g1.DFS(0);
		System.out.println("BFS");
		g1.BFS(0);
	}
		
}
