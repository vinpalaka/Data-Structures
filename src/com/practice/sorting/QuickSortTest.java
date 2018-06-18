package com.practice.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuickSortTest {

    @Test
    public void sort() {
        QuickSort q = new QuickSort();
        int[] ar = {1, 9, 8, 2, 15, 11, 12, 14, 5};
        Arrays.stream( q.sort(ar)).forEach(System.out::println);

    }
}