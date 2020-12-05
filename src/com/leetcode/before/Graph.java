package com.leetcode.before;

import com.leetcode.before.Vertex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Map<Vertex, List<Vertex>> inDegreeVertices;
    private Map<Vertex, List<Vertex>> outDegreeVertices;

    public Graph() {
        this.inDegreeVertices = new HashMap<>();
        this.outDegreeVertices = new HashMap<>();
    }

    public Map<Vertex, List<Vertex>> getInDegreeVertices() {
        return inDegreeVertices;
    }

    public Map<Vertex, List<Vertex>> getOutDegreeVertices() {
        return outDegreeVertices;
    }

    public void addVertex(int label) {
        inDegreeVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
        outDegreeVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void addEdge(int label1, int label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        outDegreeVertices.get(v1).add(v2);
        inDegreeVertices.get(v2).add(v1);
    }
}
