package com.practice.arrays;

import java.util.HashSet;
import java.util.Set;

public class Intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length < nums2.length) {
            return in(nums1, nums2);
        } else {
            return in(nums2, nums1);
        }
    }

    public int[] in(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for(int curr : nums1) {
            set.add(curr);
        }
        Set<Integer> ans = new HashSet<>();
        for(int curr : nums2) {
            if(set.contains(curr))
                ans.add(curr);
        }
        int[] q = new int[ans.size()];
        int i = 0;
        for(Integer c : ans) {
            q[i++] = c;
        }
        return q;
    }
}
