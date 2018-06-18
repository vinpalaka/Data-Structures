package com.practice.sorting.dataobjects;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class SortLogTest {

    @Test
    public void sortLogs() {
        //Map<String, Integer> = new HashMap<>();
         SortLog s = new SortLog();
         String sd= "jack and jack and jack";
         System.out.println(sd.replace("jack", ""));
        List<SortLog.Item> item = s.sortLogs(Arrays.asList("168 489", "123 cba", "321 986", "456 afg",
                "678 986", "568 489", "234 zfd", "078 cba"));
        item.stream().forEach(System.out::println);
        String x = "123";
        System.out.println(x.matches("[0-9]+"));
    }

    @Test
    public void sortSolution() {
        SortLog s = new SortLog();
//        List<SortLog.Item> item = s.sortLogs(Arrays.asList("abc 168 489", "dbc tla cba", "cde 321 986", "456 afg",
//                "dbc aba tle", "eng tla", "qrz elfa", "078 cba"));
        List<SortLog.Item> item = s.sortLogs(Arrays.asList("abc 168 489", "dbc tla cba", "cde 321 986", "456 afg",
                "dbc aba tle", "eng tla", "qrz elfa", "078 cba"));
        item.stream().forEach(System.out::println);
    }


}