package com.practice.stack;

public class Stack<E> {


    class Node<E>{
        E data;
        Node<E> next;

         Node(E data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

    private Node<E> head;
    private int size;

    public void push(E data) {
        size++;
        if(head == null) {
            head = new Node<>(data, null);
        } else {
            head = new Node<>(data, head);
        }
    }

    public E pop() {
        size--;
        E value = head.data;
        head = head.next;
        return value;
    }

    public E peek() {
        return head == null ? null : head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        return size;
    }


}
