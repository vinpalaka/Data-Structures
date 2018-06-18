package com.practice.sorting;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class LargeNumbersTest {

    @Test
    public void sortLargeNumbers() {
        String arr[] = {"5", "1237637463746732323",
                "97987", "12" }; //doesn't work with negative numbers

        Arrays.stream(arr).forEach(System.out::println);

        LargeNumbers.sortLargeNumbers(arr);
        System.out.println();;
        Arrays.stream(arr).forEach(System.out::println);

    }
}