package com.practice.stack;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class StackTest {

    @Test
    public void stack() {

        LinkedList s = new LinkedList();
        List<Integer> m;
        Stack<String> names = new Stack<>();
        assertEquals(0, names.size());
        names.push("Vin");
        assertEquals("Vin", names.peek());

        names.push("Tim");
        names.push("Jasmine");
        assertEquals("Jasmine", names.peek());

        assertEquals("Jasmine", names.pop());

        names.push("Joseph");

        names.push("Joseph");
        names.push("Randy");
        names.push("Larry");

        assertEquals("Larry", names.pop());


    }
}