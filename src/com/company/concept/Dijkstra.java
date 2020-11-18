package com.company.concept;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Dijkstra {

  public static void main(String[] args) {

    int V = 8;
    int[] distances = new int[V+1];
    Arrays.fill(distances, Integer.MAX_VALUE);
    Graph graph = new Graph(V);
    graph.addDirectionlessEdge(1,2,2);
    graph.addDirectionlessEdge(1,4,1);
    graph.addDirectionlessEdge(1,5,4);
    graph.addDirectionlessEdge(2,3,5);
    graph.addDirectionlessEdge(2,4,2);
    graph.addDirectionlessEdge(3,4,3);
    graph.addDirectionlessEdge(4,5,1);
    graph.addDirectionlessEdge(5,6,1);
    graph.addDirectionlessEdge(6,7,3);
    graph.addDirectionlessEdge(7,8,5);
    graph.addDirectionlessEdge(3,8,1);
    graph.addDirectionlessEdge(3,6,2);
    graph.dijkstra(1,distances);
    System.out.println(Arrays.toString(distances));

  }

  static class Graph {
    private List<List<Edge>> graph;

    public Graph(int size) {
      this.graph = new ArrayList<>();
      for (int i=0; i<=size; i++) graph.add(new LinkedList<>());
    }

    public void addDirectionlessEdge(int node1, int node2, int distance) {
      graph.get(node1).add(new Edge(node2, distance));
      graph.get(node2).add(new Edge(node1, distance));
    }

    public void dijkstra(int s, int[] dists) {
      dists[s] = 0;
      PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
      priorityQueue.offer(new Edge(s,0));

      while (!priorityQueue.isEmpty()) {
        Edge curEdge = priorityQueue.poll();
        int curDestination = curEdge.destination;
        int curDistance = curEdge.distance;

        if (dists[curDestination] < curDistance) continue;

        List<Edge> nextEdge = graph.get(curDestination);

        for (int i=0; i<nextEdge.size(); i++) {
          int nextDestination = nextEdge.get(i).destination;
          int nextDistance = nextEdge.get(i).distance;

          if (dists[nextDestination] > curDistance + nextDistance) {
            dists[nextDestination] = curDistance + nextDistance;
            priorityQueue.offer(new Edge(nextDestination, dists[nextDestination]));
          }
        }
      }
    }
  }

  static class Edge implements Comparable<Edge> {

    int destination;
    int distance;

    public Edge(int destination, int distance) {
      this.destination = destination;
      this.distance = distance;
    }

    @Override
    public int compareTo(Edge o) {
      return Integer.compare(distance, o.distance);
    }

    @Override
    public String toString() {
      return "Edge{" +
        "destination=" + destination +
        ", distance=" + distance +
        '}';
    }
  }

}
