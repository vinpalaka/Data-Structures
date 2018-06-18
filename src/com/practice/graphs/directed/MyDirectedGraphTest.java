package com.practice.graphs.directed;

import com.practice.graphs.Graph;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyDirectedGraphTest {

    @Test
    public void dfs() {
        MyDirectedGraph<Character> s = new MyDirectedGraph<>('a');
        s.addEdge('a', 'b');
        s.addEdge('a', 'c');
        s.addEdge('b', 'd');
        s.addEdge('d', 'e');
        s.addEdge('c', 'd');
        s.addEdge('c', 'f');
        s.addEdge('c', 'h');
        System.out.println(s.dfs('h'));
    }

    @Test
    public void cycle() {
        MyDirectedGraph<Character> s = new MyDirectedGraph<>('a');
        s.addEdge('a', 'b');
        s.addEdge('a', 'c');
        s.addEdge('b', 'd');
        s.addEdge('d', 'e');
        s.addEdge('c', 'd');
        s.addEdge('c', 'f');
        s.addEdge('c', 'h');
        s.addEdge('h', 'd');
        s.addEdge('e', 'h');
        System.out.println(s.getSmallestCycle('a'));
    }

    @Test
    public void cycleSImp() {
        MyDirectedGraph<Character> s = new MyDirectedGraph<>('a');
        s.addEdge('a', 'b');
        s.addEdge('a', 'e');
        s.addEdge('b', 'c');
        s.addEdge('c', 'g');
        s.addEdge('c', 'n');
        s.addEdge('g', 'b');


        System.out.println(s.getSmallestCycle('a'));
    }
}