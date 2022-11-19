package prob1;

import java.util.*;

public class graph {
	 static class Edge {
		 String source;
		 String destination;
		 int weight;

		 public Edge(String source, String destination, int weight) {
		 this.source = source;
		 this.destination = destination;
		 this.weight = weight;
		 }
	}

		 static class Graph {
			 static String des,src;
			 static int ans=0;
			 static int paths=0;
			 int vertices;
			 LinkedList<Edge> [] adjacencylist;
	
			 Graph(int vertices) {
			 this.vertices = vertices;
			 adjacencylist = new LinkedList[vertices];
			 for (int i = 0; i <vertices ; i++) {
			 adjacencylist[i] = new LinkedList<>();
			 }
		}

		 public void addEgde(int i,int j,String source, String destination, int weight) {
		 Edge edge = new Edge(source, destination, weight);
		 Edge edge1 = new Edge(destination,source,weight);
		 adjacencylist[i].addFirst(edge);
		 adjacencylist[j].addFirst(edge1);
		 }

//		 public void printGraph(){
//		 for (int i = 0; i <vertices ; i++) {
//		 LinkedList<Edge> list = adjacencylist[i];
//		 for (int j = 0; j <list.size() ; j++) {
//		 System.out.println(list.get(j).source + "," + list.get(j).weight+","+
//		 list.get(j).destination + "," + list.get(j).weight);
//		 }
//		}
//	}
		 void com(String a, String b,boolean vis[],int w) {
			 if(a.equals(des)){
	                paths++;
	                ans+=w;
	                return;
	            }
	            int index=a.charAt(0)-65;
	            for(int i=0;i<adjacencylist[index].size();i++)
	            {
	                String to=adjacencylist[index].get(i).destination;
	                int toIndex=to.charAt(0)-65;
	                if(vis[toIndex]==false)
	                {
	                    vis[toIndex]=true;
	                    com(to,b,vis,w+adjacencylist[index].get(i).weight);
	                    vis[toIndex]=false;
	                }
	            }
	            return;
			 
			 }
		 double compute(String a,String b) {
			 src=a;des=b;
			 boolean visited []=new boolean [vertices];
			 paths=0;
	         ans=0;
	         visited[a.charAt(0)-65]=true;
	         com(a,b,visited,0);
	         return ((double)ans/(double) paths);
			
		 }
}
		 
		 public static void main(String[] args) {
			 int vertices = 5;
			 Graph graph = new Graph(vertices);
			 graph.addEgde(0, 1, "A","B",12);
			 graph.addEgde(0, 2, "A","C",13);
			 graph.addEgde(0, 3, "A","D",11);
			 graph.addEgde(0, 4, "A","E",8);
			 graph.addEgde(1, 2, "B","C",3);
			 graph.addEgde(2, 4, "C","E",4);
			 graph.addEgde(3, 4, "D","E",7);
			// graph.printGraph();
			 System.out.println("Average distance is : " + graph.compute("A","B"));
			 }
	 
}
