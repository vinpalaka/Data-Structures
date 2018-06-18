package com.practice.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            map.put(i, new ArrayList<Integer>());
        }

        for(int[] edge : edges) {
            map.get(edge[0]).add(edge[1]);
        }
        int count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(!visited[i]) {
                count++;
                dfs(i, visited, map);
            }
        }
        return count;
    }

    private void dfs(int start, boolean[] visited, Map<Integer, List<Integer>> map) {
        if(visited[start])
            return;
        else {
            visited[start] = true;
            for(int next : map.get(start)) {
                dfs(next, visited, map);
            }
        }
    }
}
