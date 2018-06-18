package com.practice.graphs.directed;

import java.util.*;

public class MyDirectedGraph<E> {
    public class Vertex<e> {
        E data;
        boolean isVisited;
        public Vertex(E data) {
            this.data = data;
        }
    }

    Map<E, Map<E, Vertex>> graph = new HashMap<>();
    E start;

    public MyDirectedGraph(E start) {
        this.start = start;
    }

    /**
     * Add an edge from start to end
     * @param start
     * @param end
     */
    public void addEdge(E start, E end) {
        Map<E, Vertex> map = new HashMap<>();
        map.put(end, new Vertex(end));
        graph.merge(start, map, (x, y) -> {
                x.putAll(y);
                return x;
        } );
    }

    public E dfs(E key) {
        Set<E> visited = new HashSet<>();
        if(start.equals(key))
            return start;
        return dfsNow(key, start, visited);
    }

    private E dfsNow(E key, E start, Set<E> visited) {
        E found = null;
        visited.add(start);
        Map<E, Vertex> vertices = graph.get(start);
        if(vertices == null)
            return found;
        for(E v : vertices.keySet()) {
            if(v.equals(key))
                return v;
            if(!visited.contains(v)) {
                found = dfsNow(key, v, visited);
                if(found != null)
                    break;
            }
        }
        return found;
    }

    public String getSmallestCycle(E start) {
        ArrayDeque<E> q = new ArrayDeque<>();
        Map<E, List<E>> vistited = new HashMap<>();
        vistited.put(start, new ArrayList<>());
        q.add(start);
        while(!q.isEmpty()) {
            E parent = q.remove();
            Map<E, Vertex> set = graph.get(parent);
            if(set == null)
                continue;
            for(E v : set.keySet()) {
                List<E> seen = new ArrayList<>();
                seen.addAll(vistited.get(parent));
                seen.add(parent);
                if(!vistited.containsKey(v))
                    q.add(v);
                vistited.merge(v, seen, (x, y) -> {
                    x.addAll(y);
                    return x;
                });

                if(seen.contains(v)) {
                    seen.add(v);
                    return seen.toString();
                }
            }

        }
        return null;
    }


}
