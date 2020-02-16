package com.practice.table;

import java.util.Objects;

//2019 version power of 2 for getting index is better than using prime for perfomance
//    //https://runzhuoli.me/2018/09/20/why-hashmap-size-power-of-2.html
public class MyHashMap<K, V> {

    private static final int MIN_CAP =  16;
    private MyHashMap.Node[] map;
    public int size = 0;
    int capacity = MIN_CAP; //large prime number
    float loadFactor = .75f; //Ratio of elements to capacity. Could use this to resize.

    class Node<K, V> {
        K key;
        V value;

        Node<K, V> next;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public MyHashMap() {
        map = new MyHashMap.Node[capacity];
    }

    public MyHashMap(int capacity) {
        this.capacity = capacity;
        map = new MyHashMap.Node[capacity];
    }

    public void put(K key, V value) {
        int hashCode = getHash(key);
        int index = getIndex(hashCode, capacity);
        if( map[index] == null ) {
            map[index] = new Node(key, value);
            size++;
        } else {
            Node<K, V> sameBucket = map[index];
            while(!sameBucket.key.equals(key) && sameBucket.next != null) {
                sameBucket = sameBucket.next;
            }

            if(sameBucket.key.equals(key)) {
                //Over writing same value
                sameBucket.value = value;
            } else {
                //collision
                sameBucket.next = new Node<K, V>(key, value);
                size++;
            }
        }
    }

    public V remove(K key) {
        int hashCode = getHash(key);
        int index = getIndex(hashCode, capacity);
        V temp = null;
        if(map[index] == null) {
            //Do something
        } else {
            Node<K, V> curr = map[index];
            Node<K, V> prev = curr;
            if(curr.key.equals(key) && curr.next == null) {
                temp = curr.value;
                map[index] = null;

            } else {
                while(!curr.key.equals(key) && curr.next != null) {
                    prev = curr;
                    curr = curr.next;
                }

                temp= curr.value;
                prev.next = null;
            }
            size--;
        }
        return temp;
    }

    public V getValue(K key) {
        Node<K, V> curr = getNode(key);
        return curr != null ? curr.value : null;
    }

    private Node<K, V> getNode(K key) {
        int hashCode = getHash(key);
        int index = getIndex(hashCode, capacity);
        return map[index];
    }

    public int size() {
        return size;
    }

    private int getIndex(int hashCode, int capacity) {
        return hashCode & (capacity - 1);
    }

    private int getHash(K key) {
        int h;
        return (h = key.hashCode()) ^ (h >>> 16);
    }

}
