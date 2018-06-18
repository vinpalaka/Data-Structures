package com.practice.graphs;

import java.util.*;

/**
 * Looks for cycles in this graph
 */
public class ValidTree {
    public boolean validTree(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }

        boolean[] visited = new boolean[n];
        ArrayDeque<Integer> q = new ArrayDeque<Integer>();
        q.add(0);
        while(!q.isEmpty()) {
            int next = q.remove();
            List<Integer> list = map.get(next);
            if(visited[next])
                return false;
            visited[next] = true;

            for(int child : list) {
                if(!visited[child]){
                    q.add(child);
                }
            }
        }

        for(boolean b : visited) {
            if(!b)
                return false;
        }
        return true;
    }
}
