package com.practice.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GraphMatrix extends Graph {

    private int[][] adjEdges;
    private List<Vertex> vertices;


    @Override
    public void addVertex(Vertex data) {
        if(vertices == null) {
            vertices = new ArrayList<>();
        }
        vertices.add(data);
    }

    @Override
    public void addEdge(Vertex one, Vertex two) {
        if(adjEdges == null) {
            adjEdges = new int[vertices.size()][vertices.size()];
        }
        int i = vertices.indexOf(one);
        int j = vertices.indexOf(two);

        adjEdges[i][j] = 1;
        adjEdges[j][i] = 1;
    }

    @Override
    public boolean isNeighbor(Vertex one, Vertex two) {
        int i = vertices.indexOf(one);
        int j = vertices.indexOf(two);
        return adjEdges[i][j] == 1;
    }

    @Override
    public Vertex bfs(Vertex needle) {
        Vertex startVertex = vertices.get(0);
        if(startVertex.data.equals(needle.data)) {
            return startVertex;
        }
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        startVertex.isVisited = true;
        queue.add(startVertex);
        while(!queue.isEmpty()) {
            Vertex curr = queue.remove();
            Iterable<Vertex> neighbors = getUnvisitedAdjVertices(curr);
            for(Vertex v : neighbors) {
                System.out.println(v.data);
                if(v.data.equals(needle.data)) {
                    return v;
                } else {
                    v.isVisited = true;
                    queue.add(v);
                }
            }

        }
        for(Vertex v : vertices) {
            v.isVisited = false;
        }
        return null;
    }

    @Override
    public Vertex dfs(Vertex needle) {
        Vertex startVertex = vertices.get(0);
        if(startVertex.data.equals(needle.data)) {
            return startVertex;
        }
        ArrayDeque<Vertex> stack = new ArrayDeque<>();
        startVertex.isVisited = true;
        stack.push(startVertex);
        while(!stack.isEmpty()) {
            Vertex curr = stack.peek();
            Vertex neighbor = getUnvisitedNeighbor(curr);
            if(neighbor == null) {
                stack.pop();
            } else {
                if(needle.data.equals(neighbor.data)) {
                    return neighbor;
                } else {
                    neighbor.isVisited = true;
                    stack.push(neighbor);
                }
            }
        }

        for(Vertex v : vertices) {
            v.isVisited = false;
        }
        return null;
    }

    private Vertex getUnvisitedNeighbor(Vertex vertex) {
        return IntStream.range(0,adjEdges[0].length)
                .filter(i -> adjEdges[vertices.indexOf(vertex)][i] == 1)
                .mapToObj(x -> vertices.get(x))
                .filter(x -> !x.isVisited)
                .findFirst()
                .orElse(null);
    }

    private Iterable<Vertex> getUnvisitedAdjVertices(Vertex vertex) {
        return IntStream.range(0,adjEdges[0].length)
                .filter(i -> adjEdges[vertices.indexOf(vertex)][i] == 1)
                .mapToObj(x -> vertices.get(x))
                .filter(y -> !y.isVisited)
                .collect(Collectors.toList());
    }

    @Override
    public Iterable<Vertex> getAdjVertices(Vertex vertex) {
        return IntStream.range(0,adjEdges[0].length)
                .filter(i -> adjEdges[vertices.indexOf(vertex)][i] == 1)
                .mapToObj(x -> vertices.get(x))
                .collect(Collectors.toList());
    }
}
