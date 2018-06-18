package com.practice.graphs;

public abstract class Graph<E> implements IGraph<E> {
    protected static class Vertex<E> {
        protected boolean isVisited;
        protected E data;

        protected Vertex(E data) {
            this.data = data;
        }
    }
}
