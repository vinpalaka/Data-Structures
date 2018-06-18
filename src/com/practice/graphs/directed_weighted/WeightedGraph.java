package com.practice.graphs.directed_weighted;

import java.util.*;

public class WeightedGraph<E> {

    PriorityQueue<Vertex<E>> queue;
    Map<E, Vertex<E>> vertexMap;

    class Edge {
        public Edge(Vertex<E> destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        Vertex<E> destination;
        int weight;
    }

    class Vertex<E>{
        public Vertex(E data) {
            this.data = data;
        }

        Set<Edge> edges = new HashSet<>();

        void addEdge(Edge e) {
            edges.add(e);
        }

        E data;

        public void setShortestDistance(int shortestDistance) {
            this.shortestDistance = shortestDistance;
        }

        int shortestDistance = Integer.MAX_VALUE;

    }

    public void addEdge(E start, E destination, int weight) {
        Vertex<E> startVertex;
        if((startVertex = vertexMap.get(start)) == null) {
            startVertex = new Vertex<>(start);
            vertexMap.put(start, startVertex);
        }
        Vertex<E> endVertex = vertexMap.computeIfAbsent(destination, (x)->new Vertex<>(destination));
        startVertex.addEdge(new Edge(endVertex, weight));
    }

    public WeightedGraph() {
        vertexMap = new HashMap<>();
    }

    /**
     * Implements Djstra's
     * @param start
     * @param end
     * @return
     */
    public int getShortestDistance(E start, E end) {
        queue = new PriorityQueue<>(Comparator.comparingInt(o->o.shortestDistance));
        Vertex<E> startVer = vertexMap.get(start);
        startVer.setShortestDistance(0);
        queue.add(startVer);
        while (!queue.isEmpty()) {
            Vertex<E> curr = queue.poll();
            Set<Edge> edges = curr.edges;
            if(end.equals(curr.data)) {
                return curr.shortestDistance;
            }
            int currentDistance = curr.shortestDistance;
            for(Edge edge : edges) {
                Vertex<E> adjacentVertex = edge.destination;
                if(adjacentVertex.shortestDistance > currentDistance + edge.weight) {
                    adjacentVertex.setShortestDistance(currentDistance + edge.weight);
                    queue.remove(adjacentVertex);
                    queue.add(adjacentVertex);
                }
            }
        }
        return 0;
    }
}
