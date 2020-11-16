package com.company.study.section.section2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12978
 */
public class Delivery {

  public static void main(String[] args) {
    int count = 0;
    int[][] road = {{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
    int N = 5;
    int K = 3;
    int[] dist = new int[N+1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    Graph graph = new Graph(road.length+1);
    for (int[] edge : road) {
      graph.addDirectionlessEdge(edge[0], edge[1], edge[2]);
    }

    graph.dijkstra(1,dist);
    for (int i : dist) count += i<=K ? 1 : 0;
    System.out.println(Arrays.toString(dist));
    System.out.println(count);
  }

  static class Graph {

    private final List<List<Edge>> graph;

    public Graph(int nodeSize) {
      graph = new ArrayList<>();
      for (int i=1; i<=nodeSize; i++) graph.add(new LinkedList<>());
    }

    public void addDirectionlessEdge(int node1, int node2, int distance) {
      graph.get(node1).add(new Edge(node2, distance));
      graph.get(node2).add(new Edge(node1, distance));
    }

    public void dijkstra(int s, int[] dist) {
      dist[s] = 0;
      PriorityQueue<Edge> priorityQueue = new PriorityQueue();
      priorityQueue.offer(new Edge(s,0));

      while (!priorityQueue.isEmpty()) {
        Edge curEdge = priorityQueue.poll();

        int curDestination = curEdge.destination;
        int curDistance = curEdge.distance;

        if (dist[curDestination] < curDistance) continue;


        List<Edge> nextEdge = graph.get(curDestination);
        for (int i=0; i<nextEdge.size(); i++) {
          int nextDestination = nextEdge.get(i).destination;
          int nextDistance = nextEdge.get(i).distance;

          if (dist[nextDestination] >= curDistance + nextDistance) {
            dist[nextDestination] = curDistance + nextDistance;
            priorityQueue.offer(new Edge(nextDestination, dist[nextDestination]));
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
      return Integer.compare(this.distance, o.distance); // 오름차순
    }
  }

}
