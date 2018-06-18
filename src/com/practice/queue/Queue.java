package com.practice.queue;

/**
 * Adds and removes into queue at constant time.
 * Follows first in first out.
 * @param <E>
 */
public class Queue<E> {
    class Node {
        E data;
        Node next;

        public Node(E data) {
            this.data = data;
        }
    }

    Node head;
    Node end;
    int size = 0;

    public void add(E data) {
        if(head == null) {
            head = new Node(data);
            end = head;
        } else {
            end.next = new Node(data);
            end = end.next;
        }
        size++;
    }

    public E remove() {
        if(head == null) {
            return null;//error
        } else {
            size--;
            E data = head.data;
            head = head.next;
            return data;
        }
    }

    public E peek() {
        if(head != null) {
            return head.data;
        }
        return null;
    }

    public int size() {
        return size;
    }

    public void print() {
        if(head != null) {
            Node temp = head;
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }
}
