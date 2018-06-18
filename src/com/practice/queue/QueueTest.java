package com.practice.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class QueueTest {

    Queue<Integer> queue = new Queue<>();
    @Test
    public void firstInFirstOut() {
        String s = "9";
        System.out.println(s.charAt(0));
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        assertEquals(Integer.valueOf(1), queue.remove());
        assertEquals(Integer.valueOf(2), queue.peek());
        assertEquals(3, queue.size());
        queue.add(5);
        queue.print();
        assertEquals(Integer.valueOf(2), queue.remove());
        assertEquals(Integer.valueOf(3), queue.peek());
    }
}