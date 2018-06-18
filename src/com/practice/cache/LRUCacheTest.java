package com.practice.cache;

import org.junit.Test;

import static org.junit.Assert.*;

public class LRUCacheTest {

    @Test
    public void add() {
        LRUCache<Integer, Integer> cache = new LRUCache<>(5);
        cache.add(1);
        assertEquals(Integer.valueOf(1), cache.get(1));
        cache.add(2);
        cache.add(3);//1 2 3
        assertEquals(Integer.valueOf(3), cache.get(3));//1 2 3
        cache.add(4);//1 2 3 4
        assertEquals(Integer.valueOf(1), cache.get(1));//2 3 4 1
        cache.add(2);//3 4 1 2
        cache.add(5);//3 4 1 2 5
        assertEquals(Integer.valueOf(3), cache.get(3));//4 1 2 5 3
        assertEquals(Integer.valueOf(4), cache.get(4));//1 2 5 3 4


    }


}