package com.practice.file_io.sum;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReadFileTest {

    @Test
    public void readFile() {
        long start = System.currentTimeMillis();
        long sum = ReadFile.readFile("text0.txt");
        long s = getValue();
        System.out.println(sum + " for read file:" + (System.currentTimeMillis()-start)/1000 + " seconds");
    }

    @Test
    public void readFiles() {
        long start = System.currentTimeMillis();
        long sum = ReadFile.readFiles("text");
        long s = getValue();
        System.out.println(sum + " for read file:" + (System.currentTimeMillis()-start)/1000 + " seconds");
    }

    private long getValue() {
        long sum = 0;
            for(int j = 0; j < 10000000; j++) {
                sum+= j;
            }
        return sum;
    }
}