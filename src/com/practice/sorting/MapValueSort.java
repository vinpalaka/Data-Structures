package com.practice.sorting;

import java.util.*;

/**
 * Passing in an array, this will put them into a tree map
 * and sort based on which key shows up the most.
 */
public class MapValueSort {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.merge(nums[i], 1, (x, y) -> x + y);
        }
        TreeMap<Integer, Integer> tree = new TreeMap<>(new ValueComparator(map));
        tree.putAll(map);
        int i = 0;
        List<Integer> list = new ArrayList<>();
        Iterator<Integer> iter = tree.keySet().iterator();
        while(i< k) {
            if(iter.hasNext()) {
                Integer value = iter.next();
                list.add(value);
            }
            i++;
        }
        return list;
    }

    class ValueComparator implements Comparator<Integer> {

        private Map<Integer, Integer> map;

        public ValueComparator() {
            map = new TreeMap<>();
        }

        public ValueComparator(Map<Integer,Integer> map) {
            this.map = map;
        }

        public int compare(Integer a, Integer b) {
            int x = map.get(a);
            int y = map.get(b);
            if(x == y) {
                return a - b;
            }
            return y - x;
        }
    }
}
