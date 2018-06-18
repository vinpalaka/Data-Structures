package com.practice.lists;

import org.junit.Test;


public class ArrayListTest {

    public ArrayListTest() {

    }

    @Test
    public void add() {
        ArrayList<Integer> list = new ArrayList<>(10);
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(list.size());
        System.out.println(list.contains(2));
        list.add(5);
        list.add(6);
        System.out.println(list.contains(4));
        System.out.println(list.get(4));
        list.add(10);
        System.out.println(list.isEmpty());
        System.out.println("Size: " + list.size());

        System.out.println(list.remove(2));
        System.out.println(list.get(4));

        System.out.println("Size: " + list.size());

        String s = "apple";
        s.chars().forEach(System.out::println);
        int v = s.charAt(0);
        System.out.println(v);

    }

    @Test
    public void testOrigArrayList() {
        java.util.ArrayList<Integer> list = new java.util.ArrayList();
        list.add(1);
        list.remove(0);
    }
}