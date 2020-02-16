package com.practice.arrays;

import java.util.Map;
import java.util.TreeMap;

public class Intervals {
    public boolean canAttendMeetings(int[][] intervals) {
        if(intervals.length == 0)
            return true;
        TreeMap<Integer, Integer> tree = new TreeMap<Integer, Integer>();


        for(int i = 0; i < intervals.length; i++) {
            Map.Entry<Integer, Integer> entry = tree.floorEntry(intervals[i][0]);
            if(entry != null) {
                if(intervals[i][0] >= tree.floorKey(intervals[i][0]) && intervals[i][0] < entry.getValue() )
                    return false;
            }

        }
        return true;
    }
}
