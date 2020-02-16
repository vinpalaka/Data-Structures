package com.practice.graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GraphMatrix<E> {

    private int[][] adjEdges;
    private List<Vertex> vertices;

    protected static class Vertex<E> {
        protected boolean isVisited;
        protected E data;

        protected Vertex(E data) {
            this.data = data;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof GraphMatrix.Vertex))
                return false;
            GraphMatrix.Vertex<?> vertex = (GraphMatrix.Vertex<?>) o;
            return Objects.equals(data, vertex.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

    public GraphMatrix() {
        vertices = new ArrayList<>();
    }

    public void addVertex(E data) {
        Vertex<E> vertex = new Vertex<>(data);
        vertices.add(vertex);
    }

    public void addEdge(E one, E two) {
        if(adjEdges == null){
            adjEdges = new int[vertices.size()][vertices.size()];
        }

        int i = vertices.indexOf(new Vertex<E>(one));
        int j = vertices.indexOf(new Vertex<E>(two));

        adjEdges[i][j] = 1;
        adjEdges[j][i] = 1;
    }

    public boolean isNeighbor(E one, E two) {
        int i = vertices.indexOf(new Vertex<E>(one));
        int j = vertices.indexOf(new Vertex<E>(two));
        return adjEdges[i][j] == 1;
    }

    public boolean bfs(E one, E two) {
        int i = vertices.indexOf(new Vertex<E>(one));
        Vertex<E> startVertex = vertices.get(i);
        if(startVertex.data.equals(two)) {
            return true;
        }
        ArrayDeque<Vertex> queue = new ArrayDeque<>();
        startVertex.isVisited = true;
        queue.add(startVertex);
        while(!queue.isEmpty()) {
            Vertex curr = queue.remove();
            Iterable<Vertex> neighbors = getUnvisitedAdjVertices(curr);
            for(Vertex v : neighbors) {
                System.out.println(v.data);
                if(v.data.equals(two)) {
                    return true;
                } else {
                    v.isVisited = true;
                    queue.add(v);
                }
            }

        }
        for(Vertex v : vertices) {
            v.isVisited = false;
        }
        return false;
    }

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

}
