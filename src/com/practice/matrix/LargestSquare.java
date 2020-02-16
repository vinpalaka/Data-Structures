package com.practice.matrix;


//https://leetcode.com/problems/maximal-square/submissions/
public class LargestSquare {
    public int maximalSquare(char[][] matrix) {
        int result = 0;
        if(matrix.length == 0)
            return 0;
        if(matrix[0].length == 1)
            return matrix[0][0] == '1' ? 1 : 0;

        int[][] sum = new int[matrix.length + 1][matrix[0].length + 1];


        for(int i = 0; i < matrix.length; i++) {
            if(matrix[i][0] == '1') {
                result = 1;
                sum[i][0] = 1;
            } else {
                sum[i][0] = 0;
            }
        }

        for(int i = 0; i < matrix[0].length; i++) {
            if(matrix[0][i] == '1') {
                result = 1;
                sum[0][i] = 1;
            } else {
                sum[0][i] = 0;
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] == '1') {
                    sum[i][j] = Math.min(sum[i][j-1], Math.min(sum[i-1][j],
                            sum[i-1][j-1])) + 1;
                } else {
                    sum[i][j] = 0;

                }

                if(sum[i][j] > result)
                    result = sum[i][j];
            }
        }
        return (result * result);
    }
}
