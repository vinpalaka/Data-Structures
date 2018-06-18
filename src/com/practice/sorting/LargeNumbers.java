package com.practice.sorting;

import java.util.Arrays;

public class LargeNumbers {

    /**
     * This will sort string of large numbers that can't really be converted to
     * int or bigint or long. it's too big. Only works with non negative numbers
     * @param arr
     */
    public static void sortLargeNumbers(String[] arr) {
        String s;
        Arrays.sort(arr, (left, right) ->
        {
            /* If length of left != right, then return
               the diff of the length else  use compareTo
               function to compare values.*/
            if (left.length() != right.length())
                return left.length() - right.length();
            return left.compareTo(right);
        });
    }
}
