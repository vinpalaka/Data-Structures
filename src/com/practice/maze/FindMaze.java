package com.practice.maze;

import java.util.*;

public class FindMaze {
    public static boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        return hasPath(maze, destination, start[0], start[1], visited);
    }

    private static boolean hasPath(int[][] maze, int[] destination,
                                   int x, int y, boolean[][] visited) {
        boolean found = false;
        if(maze[x][y] == 1 || visited[x][y] || x < 0 || y < 0 || x == maze.length || y == maze[0].length)
            return found;

        visited[x][y] = true;
        //down
        int i = x + 1;
        if(i < maze.length && maze[i][y] == 0) {
            while( i < maze.length && maze[i][y] == 0) {
                if(i == destination[0] && y == destination[1])
                    return true;
                else {
                    i++;
                }
            }
            if(!visited[i-1][y])
                found = hasPath(maze, destination, i-1, y, visited);
        }


        //up
        i = x - 1;
        if(!found  && i >= 0 && maze[i][y] == 0) {
            while(i >= 0 && maze[i][y] == 0) {
                if(i == destination[0] && y == destination[1])
                    return true;
                else {
                    i--;
                }
            }
            if(!visited[i+1][y])
                found = hasPath(maze, destination, i+1, y, visited);
        }


        //left
        i = y - 1;
        if(!found && i >= 0 && maze[x][i] == 0) {
            while( i >= 0 && maze[x][i] == 0) {
                if(x == destination[0] && i == destination[1])
                    return true;
                else {
                    i--;
                }
            }
            if(!visited[x][i+1])
                found = hasPath(maze, destination, x, i+1 , visited);
        }


        //right
        i = y + 1;
        if(!found && i<maze[0].length && maze[x][i] == 0) {
            while(i<maze[0].length && maze[x][i] == 0) {
                if(x == destination[0] && i == destination[1])
                    return true;
                else {
                    i++;
                }
            }
            if(!visited[x][i-1])
                found = hasPath(maze, destination, x, i-1, visited);
        }
        return found;

    }
}
