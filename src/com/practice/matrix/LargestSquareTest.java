package com.practice.matrix;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestSquareTest {

    @Test
    public void maximalSquare() {
        LargestSquare largestSquare = new LargestSquare();
        char[][] matrix = {{'1', '1', '1', '1'}, {'1', '1', '1', '1'}, {'1', '1', '1', '1'}};
        assertEquals(9, largestSquare.maximalSquare(matrix));
    }
}