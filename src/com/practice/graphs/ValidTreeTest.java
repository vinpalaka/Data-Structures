package com.practice.graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class ValidTreeTest {

    @Test
    public void validTree() {
        ValidTree g = new ValidTree();
        int[][] edges = {{0,1},{0,2},{0,3},{1,4}};
        int n = 5;
        g.validTree(n, edges);
    }
}