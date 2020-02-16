package com.practice.arrays;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class IntervalsTest {

    @Test
    public void canAttendMeetings() {
        Intervals intervals = new Intervals();
        intervals.canAttendMeetings(new int[][] {{7,10},{2,4}});
        List<String> matches = new ArrayList<>(Arrays.asList("Timm", "Lame", "Gee", "Roook"));
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);


        while (!q.isEmpty())
            System.out.println(q.removeLast());
        if(matches.stream()
                .allMatch(this::check))
            System.out.println("Yooo");
    }

    private boolean check(String s) {
        System.out.println(s);
        if(s.length() > 3)
            return true;
        return false;
    }
}