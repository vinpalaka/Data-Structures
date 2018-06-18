package com.practice.trees.leetcode;


/**
 * https://leetcode.com/problems/unique-paths/description/
 */
class UniquePaths {
    public static int uniquePaths(int m, int n) {
        Integer[][] map = new Integer[m][n];
        for(int i = 0; i<m;i++){
            map[i][0] = 1;
        }
        for(int j= 0;j<n;j++){
            map[0][j]=1;
        }

        printMap(map);
        for(int i = 1;i<m;i++){
            for(int j = 1;j<n;j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
                printMap(map);
            }
        }
        return map[m-1][n-1];
    }

    private static void printMap(Integer[][] map) {
        for(int i = 0; i < map[0].length; i++) {
            for(int j = 0; j < map.length; j++) {
                System.out.print(map[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("=============================");
    }

}

