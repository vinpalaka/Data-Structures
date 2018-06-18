package com.practice.queue;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class MyPriorityQueueTest {

    /**
     * Exisiting priority queue
     */
    @Test
    public void min() {
        PriorityQueue<Integer> queue = new PriorityQueue();
        queue.add(10);
        queue.add(115);
        queue.add(14);
        queue.add(90);
        assertEquals(Integer.valueOf(10), queue.peek());
        queue.remove();
        assertEquals(Integer.valueOf(14), queue.peek());
    }

    /**
     * Turn priority queue into max heap.
     */
    @Test
    public void max() {
        PriorityQueue<Integer> queue = new PriorityQueue((Comparator<Integer>) (o1, o2) -> o2 - o1);
        queue.add(10);
        queue.add(115);
        queue.add(14);
        queue.add(90);
        assertEquals(Integer.valueOf(115), queue.peek());
        queue.remove();
        assertEquals(Integer.valueOf(90), queue.peek());
    }

    @Test
    public void heapify() {
        int arr[] = {12, 11, 13, 5, 6, 7, 17};
        MyPriorityQueue<Integer> queue = new MyPriorityQueue();
        int[] newAr = queue.heapify(arr);
        Arrays.stream(newAr).forEach(System.out::println);
    }
}