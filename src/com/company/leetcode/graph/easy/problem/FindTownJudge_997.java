package com.company.leetcode.graph.easy.problem;

import com.company.leetcode.graph.easy.Graph;
import com.company.leetcode.graph.easy.Vertex;

import java.util.List;
import java.util.Map;

public class FindTownJudge_997 {
    public int findJudge(int N, int[][] trust) {
        int result = -1;

        Graph graph = new Graph();
        for (int i=1; i<=N; i++) {
            graph.addVertex(i);
        }

        for (int i=0; i<trust.length; i++) {
            int start = trust[i][0];
            int end = trust[i][1];
            graph.addEdge(start, end);
        }

        Map<Vertex, List<Vertex>> inDegreeVertices =  graph.getInDegreeVertices();
        Map<Vertex, List<Vertex>> outDegreeVertices =  graph.getOutDegreeVertices();

        for (Vertex key : outDegreeVertices.keySet()) {
            if(outDegreeVertices.get(key).size() == 0 && inDegreeVertices.get(key).size() == N-1) {
                result = key.label;
            }
        }

        return result;
    }
}
