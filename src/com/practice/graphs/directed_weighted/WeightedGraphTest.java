package com.practice.graphs.directed_weighted;

import com.practice.graphs.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeightedGraphTest {

    @Test
    public void addEdge() {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge("San Jose", "Fremont", 30);
        graph.addEdge("San Jose", "Palo Alto", 40);
        graph.addEdge("Fremont", "San Francisco", 60);
        graph.addEdge("Palo Alto", "San Francisco", 10);
        System.out.println(graph.getShortestDistance("San Jose", "San Francisco"));

    }
}