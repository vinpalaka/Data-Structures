package com.practice.lists;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedList<E> implements Iterable<E> {

    public Node<E> head, last;
    int size = 0;

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    class MyIterator implements Iterator<E> {
        Node<E> next;
        Node<E> prev;
        Node<E> iteratedItem;
        boolean isOkToRemove = false;
        public MyIterator() {
            this.next = head;
        }
        @Override
        public boolean hasNext() {
            return next != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            prev = iteratedItem; //If it is the first element, prev should be null
            iteratedItem = next;
            E data = iteratedItem.item;
            next = next.next;
            isOkToRemove = true;
            return data;
        }

        /**
         * NEEDS WORKKK
         * Removes the iterated item.
         * Cannot call without calling next;
         */
        @Override
        public void remove() {
            if(!isOkToRemove)
                throw new IllegalStateException();

            if(prev == null) {
                head = next;
            } else {
                prev.next = next;
            }
            iteratedItem = prev;
            isOkToRemove = false;
            size--;
            //iterated item will be next so

        }
    }


    public class Node<E> {
        public E item;
        public Node<E> next;

        public Node(E n) {
            this.item = n;
        }
    }

    public Node<E> reverse() {

        Node<E> current = head;
        Node<E> prev = null;
        while (current != null) {
            Node<E> next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    /**
     * Adds item to end of list. USE LAST!!!!!
     * @param item
     * @return
     */
    public boolean add(E item) {
        size++;
        if(head == null) {
            head = new Node<>(item);
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(item);
        }
        return true;
    }

    public void add(E item, int index) throws Exception {
        size++;
        if(index > size)
            throw new Exception("Bad input");
        Node temp = head;
        for(int i = 0; i < index; i++) {
            temp = temp.next;
        }
        Node n = new Node(item);
        n.next = temp.next;
        temp.next = n;
    }

    public int size() {
        return size;
    }


    public void addFirst(E item) {
        size++;
        if(head == null) {
            head = new Node<>(item);
        } else {
            Node newItem = new Node(item);
            newItem.next = head;
            head = newItem;
        }
    }

    public void clear() {
        size = 0;
        head = null;
    }

    public boolean contains(Object o) {
        if( head != null) {
            Node<E> temp = head;
            while (temp.next != null) {
                if(temp.next.item.equals(o)) {
                    return true;
                }
                temp = temp.next;
            }
        }
        return false;
    }

    /**
     * Use last.
     * @return
     */
    public E removeLast() {
        if(head != null ) {
            size--;
            Node<E> temp = head;
            while(temp.next != null) {
                if(temp.next.next == null) {
                    E found = (E) temp.next.item;
                    temp.next = null;
                    return found;
                }
                temp = temp.next;
            }
        }
        return null;
    }

    public E remove() {
        size--;
        E item = head.item;
        if(head.next != null) {
            head = head.next;
        }
        return item;
    }

    public void print() {
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.item);
            temp = temp.next;
        }
    }

    /**
     * Detects and removes loop.
     * returns item that points at loop.
     */
    public E detectAndRemoveLoop() {

        Node<E> node = head;
        // If list is empty or has only one node
        // without loop
        if (node == null || node.next == null)
            return null;

        Node<E> slow = node, fast = node;

       /* // Move slow and fast 1 and 2 steps
        // ahead respectively.
        slow = slow.next;
        fast = fast.next.next;*/

        // Search for loop using slow and fast pointers. No need to check slow, since fast already covered
        while (fast != null && fast.next != null) {
            if (slow == fast)
                break;

            slow = slow.next;
            fast = fast.next.next;
        }

        /* If loop exists */
        if (slow == fast) {
            slow = node;

            //fast took twice as many steps as slow, slow and fast will meet again. at
            //start of loop if slow starts at head again.
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }

            /* since fast->next is the looping point */
            fast.next = null; /* remove loop */
            return fast.item;
        }
        return null;
    }
}
