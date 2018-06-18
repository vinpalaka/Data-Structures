package com.practice.lists;

/**
 * Anytime we want to use Node functionality
 * @param <E>
 */
public class ListNode<E> {
    public E item;
    public ListNode<E> next;

    public ListNode(E n) {
        this.item = n;
    }
}
