package com.practice.graphs;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphMatrixTest extends GraphTest {

    @Before
    public void setUp() throws Exception {
        graph = new GraphMatrix();
        super.setUp();
    }

    @Test
    public void testdFS() {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10000000 ; i++) {
            assertEquals("Santa Rosa", graph.dfs(new Graph.Vertex("Santa Rosa")).data);
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("TIme: " + diff );
    }

    @Test
    public void testbFS() {
        long start = System.currentTimeMillis();
        for(int i = 0; i < 10 ; i++) {
            assertEquals("Santa Rosa", graph.bfs(new Graph.Vertex("Santa Rosa")).data);
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        System.out.println("TIme: " + diff );
    }
}
