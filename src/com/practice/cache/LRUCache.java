package com.practice.cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache<K, V> {
    Map<K, Node> map;
    Node head, last;
    int capacity;

    class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        Node next;
        Node prev;
    }

    public void add(V value) {
        K va = (K) value;

        put(va, value);
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>(capacity);
    }

    /**
     * Takes Node and makes it new head.
     * If in the middle or end of list. sets the previous node
     * to point to newHead next.
     * @param newHead
     */
    private void pushToLast(Node newHead) {
        //If it is last item, next must be null and don't remove.
        //Keep it where it is because it was recently used.
        if (newHead.next != null) {

            //if prev is null, then it is current head
            if (newHead.prev != null) {
                newHead.prev.next = newHead.next;
            } else {
                head = head.next; //Removing head
            }
            last.next = newHead;
            newHead.prev = last;
            last = newHead;
            newHead.next = null;
        }
    }

    /**
     * Returns value if in cache.
     * Makes value recently used as well.
     * @param key
     * @return
     */
    public V get(K key) {
        Node value = map.get(key);
        if (value != null) {
            pushToLast(value);//make it recently used item.
            return value.value;
        }
        return null;
    }

    /**
     * Adds item to cache.
     * If already in cache, makes it recently used.
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        Node newHead = map.get(key);
        if (newHead != null) {
            pushToLast(newHead);
        }
        else {
            if (capacity <= map.size()){
                map.remove(key);
                reSize();
            }
            Node newNode = new Node(key, value);
            if(head == null) {
                head = newNode;
                last = newNode;
            } else {
                last.next = newNode;
                newNode.prev = last;
                last = newNode;
            }
            map.put(key, newNode);
        }
    }

    /**
     * Removes
     */
    private void reSize() {
        K key = head.key;
        head = head.next;
        head.prev = null;
    }
}