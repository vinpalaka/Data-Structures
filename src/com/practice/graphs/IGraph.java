package com.practice.graphs;

public interface IGraph<E> {
    void addVertex(Graph.Vertex data);

    void addEdge(Graph.Vertex one, Graph.Vertex two);

    boolean isNeighbor(Graph.Vertex one, Graph.Vertex two);

    Graph.Vertex bfs(Graph.Vertex needle);

    Graph.Vertex dfs(Graph.Vertex needle);

    Iterable<Graph.Vertex> getAdjVertices(Graph.Vertex vertex);
}
