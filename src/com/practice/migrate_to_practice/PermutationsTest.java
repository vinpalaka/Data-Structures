package com.practice.migrate_to_practice;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PermutationsTest {

    @Test
    public void subsets() {
        int[] nums = new int[] {1,2,3};
        Permutations permutations = new Permutations();
        List<List<Integer>> list = permutations.subsets(nums);
        System.out.println(list);
    }
}