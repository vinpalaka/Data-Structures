package com.practice.lists;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FlattenListTest {

    @Test
    public void flatten() {
        FlattenList flattenList = new FlattenList();
        List<Integer> l = new ArrayList<>(Arrays.asList(1,2,3));

        List<Integer> m = new ArrayList<>(Arrays.asList(1,2,3));

        Set<List<Integer>> set = new HashSet<List<Integer>>();
        set.add(l);
        set.add(m);
        System.out.println(set);
    }
}