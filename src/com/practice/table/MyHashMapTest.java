package com.practice.table;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import static junit.framework.TestCase.assertEquals;

public class MyHashMapTest {

    @Test
    public void put() {
        Map<String, Integer> map = new HashMap<>();
        MyHashtable<String, Integer> table = new MyHashtable<>(29);
        map.put("Vin", 2);
        table.put("Vin", 2);
        assertEquals(map.get("Vin"), table.get("Vin"));
        assertEquals(map.size(), table.size());

        map.put("James", 4);
        map.put("Victor", 6);
        map.put("Randy", 7);
        table.put("James", 4);
        table.put("Victor", 6);
        table.put("Randy", 7);

        assertEquals(map.get("Victor"), table.get("Victor"));
        assertEquals(map.size(), table.size());

        table.put("James", 8);
        map.put("James", 8);
        assertEquals(map.get("James"), table.get("James"));
        assertEquals(map.size(), table.size());


    }

    @Test
    public void remove() {
        Map<String, Integer> map = new HashMap<>();
        MyHashtable<String, Integer> table = new MyHashtable<>(29);
        map.put("Vin", 2);
        table.put("Vin", 2);
        map.put("James", 4);
        map.put("Victor", 6);
        map.put("Randy", 7);
        table.put("James", 4);
        table.put("Victor", 6);
        table.put("Randy", 7);
        assertEquals(map.remove("James"), table.remove("James"));
        assertEquals(map.size(), table.size());

        //empty
        assertEquals(map.remove("asdfadfa"), table.remove("asdfadfa"));
        assertEquals(map.size(), table.size());
        map.put("Vivian", 4);
        map.put("Tim", 6);
        map.put("John", 7);
        table.put("Vivian", 4);
        table.put("Tim", 6);
        table.put("John", 7);

        assertEquals(map.remove("Victor"), table.remove("Victor"));
        assertEquals(map.remove("Tim"), table.remove("Tim"));
        assertEquals(map.get("Victor"), table.get("Victor"));
        assertEquals(map.get("Tim"), table.get("Tim"));
        assertEquals(map.size(), table.size());


    }
}