package com.practice.graphs;

import org.junit.Before;
import org.junit.Test;

public class GraphTest {

    IGraph<Graph.Vertex> graph;


    protected Graph.Vertex FREMONT = new Graph.Vertex("Fremont");
    Graph.Vertex SAN_JOSE = new Graph.Vertex("San Jose");
    Graph.Vertex OAKLAND = new Graph.Vertex("Oakland");
    Graph.Vertex PALO_ALTO = new Graph.Vertex("Palo Alto");
    Graph.Vertex SAN_FRANCISCO = new Graph.Vertex("San Francisco");
    Graph.Vertex PLEASANTON = new Graph.Vertex("Pleasanton");
    Graph.Vertex SAN_RAFAEL = new Graph.Vertex("San Rafel");
    Graph.Vertex SANTA_CRUZ = new Graph.Vertex("Santa Cruz");
    Graph.Vertex MONTEREY = new Graph.Vertex("Monterey");
    Graph.Vertex SANTA_ROSA = new Graph.Vertex("Santa Rosa");




    @Before
    public void setUp() throws Exception {
        graph.addVertex(FREMONT);
        graph.addVertex(SAN_JOSE);
        graph.addVertex(OAKLAND);
        graph.addVertex(PALO_ALTO);
        graph.addVertex(SAN_FRANCISCO);
        graph.addVertex(PLEASANTON);
        graph.addVertex(SAN_RAFAEL);
        graph.addVertex(SANTA_CRUZ);
        graph.addVertex(MONTEREY);
        graph.addVertex(SANTA_ROSA);

        graph.addEdge(FREMONT, SAN_JOSE);
        graph.addEdge(FREMONT, OAKLAND);
        graph.addEdge(FREMONT, PALO_ALTO);
        graph.addEdge(FREMONT, PLEASANTON);
        graph.addEdge(SAN_JOSE, PALO_ALTO);
        graph.addEdge(SAN_FRANCISCO, PALO_ALTO);
        graph.addEdge(SAN_FRANCISCO, OAKLAND);
        graph.addEdge(SAN_FRANCISCO, SAN_RAFAEL);
        graph.addEdge(SAN_JOSE, SANTA_CRUZ);
        graph.addEdge(SANTA_CRUZ, MONTEREY);
        graph.addEdge(SAN_RAFAEL, SANTA_ROSA);

    }
}