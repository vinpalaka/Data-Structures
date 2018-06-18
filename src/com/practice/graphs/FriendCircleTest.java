package com.practice.graphs;

import org.junit.Test;

import static org.junit.Assert.*;

public class FriendCircleTest {

    @Test
    public void findCircleNum() {
        int[][]ar = {{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}};
        System.out.println(FriendCircle.findCircleNum(ar));
    }
}