package com.practice.graphs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GraphList<E> extends Graph  {

    Map<Vertex, Set<Vertex>> adjList;
    Map<E, Vertex> vertexMap;

    public GraphList() {

    }

    @Override
    public void addVertex(Vertex data) {
        if(adjList == null) {
            adjList = new HashMap<>();
        }
        adjList.put(data, new HashSet<>());
    }

    @Override
    public void addEdge(Vertex one, Vertex two) {
        if(adjList.containsKey(one)) {
            adjList.get(one).add(two);
        } else {
            adjList.put(one, Stream.of(two).collect(Collectors.toSet()));
        }

        if(adjList.containsKey(two)) {
            adjList.get(two).add(one);
        } else {
            adjList.put(two, Stream.of(one).collect(Collectors.toSet()));
        }
    }

    @Override
    public boolean isNeighbor(Vertex one, Vertex two) {
        return adjList.get(one).contains(two);
    }

    @Override
    public Vertex bfs(Vertex needle) {
        Vertex startVertex = adjList.entrySet().iterator().next().getKey();
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
        Iterator<Map.Entry<Vertex, Set<Vertex>>> iter = adjList.entrySet().iterator();
        while(iter.hasNext()) {
            iter.next().getKey().isVisited=false;
        }
        return null;
    }


    @Override
    public Vertex dfs(Vertex needle) {
        Vertex startVertex = adjList.entrySet().iterator().next().getKey();
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
        Iterator<Map.Entry<Vertex, Set<Vertex>>> iter = adjList.entrySet().iterator();
        while(iter.hasNext()) {
            iter.next().getKey().isVisited=false;
        }
        return null;
    }

    private Vertex getUnvisitedNeighbor(Vertex vertex) {
        Set<Vertex> set = (Set<Vertex>) getAdjVertices(vertex);
        return set.stream()
                .filter(x ->!x.isVisited)
                .findFirst()
                .orElse(null);
    }

    private Iterable<Vertex> getUnvisitedAdjVertices(Vertex vertex) {
        Set<Vertex> set = (Set<Vertex>) getAdjVertices(vertex);
        return set.stream()
                .filter(x -> !x.isVisited)
                .collect(Collectors.toSet());
    }

    @Override
    public Iterable<Vertex> getAdjVertices(Vertex vertex) {
        return adjList.get(vertex);
    }
}
