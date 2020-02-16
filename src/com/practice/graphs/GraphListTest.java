package com.practice.graphs;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

public class GraphListTest {

    GraphList<String> graph;
    private static final String FREMONT = "Fremont";
    private static final String UNION_CITY = "Union City";
    private static final String SAN_JOSE = "San Jose";
    private static final String OAKLAND = "Oakland";
    private static final String PALO_ALTO = "Oakland";
    private static final String SAN_FRANCISCO = "San Francisco";
    private static final String PLEASANTON = "Pleasanton";
    private static final String SAN_RAFAEL = "San Rafael";
    private static final String SANTA_CRUZ = "Santa Cruz";
    private static final String MONTEREY = "Monterey";
    private static final String SANTA_ROSA = "Santa Rosa";


    @Before
    public void setUp() throws Exception {
        graph = new GraphList<String>();
        graph.addVertex(FREMONT);
        graph.addVertex(UNION_CITY);
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
        graph.addEdge(FREMONT, PLEASANTON);
        graph.addEdge(PLEASANTON, UNION_CITY);

        graph.addEdge(SAN_FRANCISCO, PALO_ALTO);
        graph.addEdge(SAN_FRANCISCO, OAKLAND);
        graph.addEdge(SAN_FRANCISCO, SAN_RAFAEL);
        graph.addEdge(SAN_JOSE, SANTA_CRUZ);
        graph.addEdge(SANTA_CRUZ, MONTEREY);
        graph.addEdge(SAN_RAFAEL, SANTA_ROSA);
    }

    @Test
    public void testAdd() {

        assertTrue(graph.isNeighbor(FREMONT, SAN_JOSE));
        assertTrue(graph.isNeighbor(SANTA_CRUZ, SAN_JOSE));
        assertTrue(graph.isNeighbor(SAN_RAFAEL, SANTA_ROSA));

        assertFalse(graph.isNeighbor(FREMONT, SANTA_ROSA));
        assertFalse(graph.isNeighbor(SAN_FRANCISCO, MONTEREY));
    }

    @Test
    public void testdFS() throws Exception {
           assertFalse(graph.bfs(FREMONT, SANTA_ROSA));
    }

    @Test
    public void testdFS2() throws Exception {
        assertTrue(graph.bfs(SAN_FRANCISCO, SANTA_ROSA));
    }

    @Test
    public void testdFS3() throws Exception {
        assertTrue(graph.bfs(UNION_CITY, MONTEREY));
    }

    @Test
    public void testdFSFalse() throws Exception {
        assertFalse(graph.bfs(FREMONT, SAN_FRANCISCO));
    }

}