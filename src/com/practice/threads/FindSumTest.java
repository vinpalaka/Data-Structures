package com.practice.threads;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class FindSumTest {

    @Test
    public void getSum() {

        List<String> files = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            files.add("text"+i+".txt");
        }
        long start = System.currentTimeMillis();
        long sum = FindSum.getSum(files);
        System.out.println(sum + " for thread read file:" + (System.currentTimeMillis()-start)/1000 + " seconds");
    }
}