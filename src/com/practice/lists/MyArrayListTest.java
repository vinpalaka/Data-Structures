package com.practice.lists;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyArrayListTest {

    public MyArrayListTest() {

    }

    @Test
    public void add() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertTrue(list.isEmpty());
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.size());
        assertTrue(list.contains(2));
        list.add(5);
        list.add(6);
        assertEquals(5, list.size());
        assertFalse(list.contains(4));
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(6), list.get(4));
        list.add(10);
        assertEquals(Integer.valueOf(3), list.remove(2));
        assertEquals(5, list.size());

        assertEquals(Integer.valueOf(10), list.get(4));

        assertEquals(Integer.valueOf(10), list.remove(4));
        assertEquals(4, list.size());
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(13, list.size());
        assertEquals(Integer.valueOf(2), list.remove(1));
        assertEquals(Integer.valueOf(2), list.remove(7));
        assertEquals(11, list.size());

    }
}