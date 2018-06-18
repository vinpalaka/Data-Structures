package com.practice.graphs;


import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GraphListTest extends GraphTest {

    @Before
    public void setUp() throws Exception {
        graph = new GraphList();
        super.setUp();
    }

    @Test
    public void testdFS() throws Exception {
            assertEquals("Santa Rosa", graph.dfs(new Graph.Vertex("Santa Rosa")).data);
    }

    @Test
    public void testbFS() {
            assertEquals("Santa Rosa", graph.bfs(new Graph.Vertex("Santa Rosa")).data);
    }


}