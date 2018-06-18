package com.practice.lists;

import org.junit.Test;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;


public class MyLinkedListTest {

    public MyLinkedListTest() {

    }

    @Test
    public void add() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println("List contains 3: " + list.contains(3));
        System.out.println("List contains 5: " + list.contains(5));

        list.addFirst(4);
        //list.clear();
        System.out.println(list.size());
        list.removeLast();


        System.out.println(list.size());
        list.add(5);
        list.add(6);
        list.remove();
        System.out.println(list.size());

    }

    @Test(expected = NoSuchElementException.class)
    public void iterator() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        Iterator<Integer> iter = list.iterator();
        assertEquals(null, iter.next());
        list.add(1);
        list.add(2);
        list.add(3);
        assertEquals(Integer.valueOf(1), iter.next());
        assertTrue(iter.hasNext());

        assertEquals(Integer.valueOf(2), iter.next());
        assertEquals(Integer.valueOf(3), iter.next());
        assertFalse(iter.hasNext());
        assertEquals(null, iter.next());

        assertEquals(Integer.valueOf(3), iter.next());

    }

    @Test
    public void iteratorWorks() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iter = list.iterator();
        assertEquals(Integer.valueOf(1), iter.next());
        assertTrue(iter.hasNext());

        assertEquals(Integer.valueOf(2), iter.next());
        assertEquals(Integer.valueOf(3), iter.next());
        assertFalse(iter.hasNext());
        assertEquals(3, list.size());

    }

    @Test(expected = IllegalStateException.class)
    public void iterRemove() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iter = list.iterator();
        iter.remove();//Cannot call remove without calling next
    }

    @Test()
    public void iterRemoveSuccOneElem() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        LinkedList<Integer> origLinkedList = new LinkedList<>();

        list.add(1);
        origLinkedList.add(1);
        Iterator<Integer> iter = list.iterator();
        Iterator<Integer> origIter = origLinkedList.iterator();

        assertEquals(origIter.next(), iter.next());
        iter.remove();//Cannot call remove without calling next
        origIter.remove();
        assertEquals(origLinkedList.peek(), list.head);
        assertEquals(origLinkedList.size(), list.size);

    }

    @Test()
    public void iterRemoveSuccLastElem() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        LinkedList<Integer> origLinkedList = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        origLinkedList.add(1);
        origLinkedList.add(2);
        origLinkedList.add(3);
        origLinkedList.add(4);

        Iterator<Integer> iter = list.iterator();
        Iterator<Integer> origIter = origLinkedList.iterator();

        assertEquals(origIter.next(), iter.next());
        assertEquals(origIter.next(), iter.next());
        iter.remove();//Cannot call remove without calling next
        origIter.remove();
        assertEquals(origIter.next(), iter.next());
        origIter.remove();
        iter.remove();//Cannot call remove without calling next

        assertEquals(origLinkedList.peek(), list.head.item);
        assertEquals(origLinkedList.size(), list.size);

        assertEquals(origIter.next(), iter.next());

        origIter.remove();
        iter.remove();

    }

    @Test()
    public void iterRemoveSuccMultipleElem() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        LinkedList<Integer> origLinkedList = new LinkedList<>();

        list.add(1);
        origLinkedList.add(1);
        Iterator<Integer> iter = list.iterator();
        Iterator<Integer> origIter = origLinkedList.iterator();

        assertEquals(origIter.next(), iter.next());
        iter.remove();//Cannot call remove without calling next
        origIter.remove();
        assertEquals(origLinkedList.peek(), list.head);
        assertEquals(origLinkedList.size(), list.size);

    }



    @Test
    public void reverse() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.reverse();
        list.print();
    }
}