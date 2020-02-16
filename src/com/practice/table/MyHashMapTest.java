package com.practice.table;

import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static junit.framework.TestCase.assertEquals;

public class MyHashMapTest {

    private Map<String, Integer> map;
    private MyHashMap<String, Integer> myMap;
    private MyHashtable<String, Integer> table;

    @Before
    public void setup() {
        map = new HashMap<>();
        table = new MyHashtable<>(17);
        myMap = new MyHashMap<>();
    }

    @Test
    public void put() {

        map.put("Vin", 2);
        table.put("Vin", 2);
        myMap.put("Vin", 2);

        assertEquals(map.get("Vin"), table.get("Vin"));
        assertEquals(map.get("Vin"), myMap.getValue("Vin"));


        assertEquals(map.size(), table.size());
        assertEquals(map.size(), myMap.size());

        map.put("James", 4);
        map.put("Victor", 6);
        map.put("Randy", 7);
        table.put("James", 4);
        table.put("Victor", 6);
        table.put("Randy", 7);
        myMap.put("James", 4);
        myMap.put("Victor", 6);
        myMap.put("Randy", 7);

        assertEquals(map.get("Victor"), table.get("Victor"));
        assertEquals(map.get("Victor"), myMap.getValue("Victor"));

        assertEquals(map.size(), table.size());
        assertEquals(map.size(), myMap.size());


        table.put("James", 8);
        map.put("James", 8);
        myMap.put("James", 8);

        assertEquals(map.get("James"), table.get("James"));
        assertEquals(map.get("James"), myMap.getValue("James"));

        assertEquals(map.size(), table.size());
        assertEquals(map.size(), myMap.size());
    }

    @Test
    public void remove() {
        map.put("Vin", 2);
        map.put("James", 4);
        map.put("Victor", 6);
        map.put("Randy", 7);
        table.put("Vin", 2);
        table.put("James", 4);
        table.put("Victor", 6);
        table.put("Randy", 7);
        myMap.put("Vin", 2);
        myMap.put("James", 4);
        myMap.put("Victor", 6);
        myMap.put("Randy", 7);

        Integer expectedValue = map.remove("James");
        assertEquals(expectedValue, table.remove("James"));
        assertEquals(expectedValue, myMap.remove("James"));

        assertEquals(map.size(), table.size());
        assertEquals(map.size(), myMap.size());

        //empty
        expectedValue = map.remove("asdfadfa");
        assertEquals(expectedValue, table.remove("asdfadfa"));
        assertEquals(expectedValue, myMap.remove("asdfadfa"));

        assertEquals(map.size(), table.size());
        assertEquals(map.size(), myMap.size());

        map.put("Vivian", 4);
        map.put("Tim", 6);
        map.put("John", 7);
        table.put("Vivian", 4);
        table.put("Tim", 6);
        table.put("John", 7);
        myMap.put("Vivian", 4);
        myMap.put("Tim", 6);
        myMap.put("John", 7);

        expectedValue = map.remove("Victor");
        assertEquals(expectedValue, table.remove("Victor"));
        assertEquals(expectedValue, myMap.remove("Victor"));

        expectedValue = map.remove("Tim");
        assertEquals(expectedValue, table.remove("Tim"));
        assertEquals(expectedValue, myMap.remove("Tim"));

        assertEquals(map.get("Victor"), table.get("Victor"));
        assertEquals(map.get("Victor"), myMap.getValue("Victor"));

        assertEquals(map.get("Tim"), table.get("Tim"));
        assertEquals(map.get("Tim"), myMap.getValue("Tim"));

        assertEquals(map.size(), table.size());
        assertEquals(map.size(), myMap.size());


    }

    //This is the test claiming to say that & is more efficient than % but don't see shit.
    @Test
    public void perf() {
        int iterationsCount = 50000000;
        System.out.println("JVM vendor:"+System.getProperty("java.vendor"));
        System.out.println("JVM version:"+System.getProperty("java.version"));
        System.out.println();

        // Warm up loop

        System.out.println("Warm up:");
        for (int i=0;i<5;i++){
            long startTime = System.currentTimeMillis();
            int result = method(iterationsCount);
            long endTime = System.currentTimeMillis();
            System.out.println((i+1)+") Result: "+result+" Took: "+(endTime-startTime)+"ms.");
        }

        // The real thing
        System.out.println();

        System.out.println("The real thing:");
        for (int i=0;i<5;i++){
            long startTime =
                    System.currentTimeMillis();
            int result = method(iterationsCount);
            long endTime = System.currentTimeMillis();
            System.out.println( (i+1) + ") Result: " +result+" Took: " +
                    (endTime-startTime)+"ms.");
        }
    }

    public static int method(int iterationsCount){
        int sum = 0;
        for (int i=0;i<iterationsCount;i++){
            sum += Math.abs(Objects.hashCode(i ) & 16);

        }
        return sum;
    }
}