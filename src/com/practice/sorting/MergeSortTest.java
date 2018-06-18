package com.practice.sorting;


import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class MergeSortTest {

    @Test
    public void mergeSort() {
        MergeSort m = new MergeSort();
        int[] nums = new int[] {4, 10, 2, 11, 1, 40, 3, 9, 8};

        m.mergeSort(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

}