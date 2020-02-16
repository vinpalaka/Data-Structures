package com.practice.graphs;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GraphList<E> {

    Map<Vertex, Set<Vertex>> adjList;
    Map<E, Vertex> vertexMap;

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
            if (!(o instanceof Vertex))
                return false;
            Vertex<?> vertex = (Vertex<?>) o;
            return Objects.equals(data, vertex.data);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data);
        }
    }

    public GraphList() {
        adjList = new HashMap<>();
    }

    public void addVertex(E data) {
        Vertex<E> vertex = new Vertex<>(data);
        adjList.merge(vertex, new HashSet<>(), (old, newHashSet) -> {
            old.addAll(newHashSet);
            return old;
        });
    }

    public void addEdge(E first, E second) {
        Vertex<E> one = new Vertex<>(first);
        Vertex<E> two = new Vertex<>(second);
        if (adjList.containsKey(one)) {
            adjList.get(one).add(two);
        } else {
            adjList.put(one, new HashSet<>(Collections.singleton(two)));
        }

        if(adjList.containsKey(two)) {
            adjList.get(two).add(one);
        } else {
            adjList.put(two, new HashSet<>(Collections.singleton(one)));
        }
    }

    public boolean isNeighbor(E one, E two) {
        return adjList.get(new Vertex<E>(one)).contains(new Vertex<E>(two));
    }


    //Use breadth first search to see if there is a path from start to end
    public boolean bfs(E start, E end) throws Exception {
        Vertex<E> startVertex = new Vertex<>(start);
        Vertex<E> needle = new Vertex<>(end);
        if(!adjList.containsKey(startVertex)) {
            throw new Exception("Did not find start node.");
        }

        if(startVertex.data.equals(needle.data)) {
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
                if(v.data.equals(needle.data)) {
                    return true;
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
        return false;
    }

    //Use depth first search to see if there is a path from start to end
    public boolean dfs(E start, E end) throws Exception {
        Vertex<E> startVertex = new Vertex<>(start);
        Vertex<E> needle = new Vertex<>(end);
        if(!adjList.containsKey(startVertex)) {
            throw new Exception("Did not find start node.");
        }

        if(startVertex.data.equals(needle.data)) {
            return true;
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
                    return true;
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
        return false;
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

    public Iterable<Vertex> getAdjVertices(Vertex vertex) {
        return adjList.get(vertex);
    }
}
