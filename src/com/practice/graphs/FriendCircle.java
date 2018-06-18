package com.practice.graphs;

public class FriendCircle {
    public static int findCircleNum(int[][] M) {

        boolean[][] visited = new boolean[M.length][M[0].length];
        for(int i = 0; i < M.length; i++) {
            for(int j = 0; j < M[0].length; j++) {
                if( M[i][j] == 0)
                    visited[i][j] = true;
            }
        }
        int count = 0;
        for(int i = 0; i < visited.length; i++) {
            for(int j = 0; j < visited[0].length; j++) {
                if(!visited[i][j]) {
                    count++;
                    dfs(visited, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(boolean[][] visited, int i, int j) {
        if( i == visited.length || j == visited[0].length)
            return;
        else {
            visited[i][j] = true;
            boolean[] edge = visited[i];
            for(int x = 0; x < edge.length; x++) {
                if(!edge[x]) {
                    visited[i][x] = true;
                    dfs(visited, x, 0);
                }
            }
        }
    }
}
