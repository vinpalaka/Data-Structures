package com.practice.maze;

import com.practice.lists.ListNode;
import com.practice.threads.FindSum;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.*;

public class FindMazeTest {

    @Test
    public void hasPath() {
        int[][] maze = {{0,0,1,0,0},{0,0,0,0,0},{0,0,0,1,0},{1,1,0,1,1},{0,0,0,0,0}};
        int[] start = new int[]{0, 4};
        int[] dest = new int[] {4, 4};
        System.out.println(FindMaze.hasPath(maze, start,dest));



    }
}