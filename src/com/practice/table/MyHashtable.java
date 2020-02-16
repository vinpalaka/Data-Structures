package com.practice.table;


/**
 * This NEEDS TO BE TESTED!!!!!!
 * @param <K>
 * @param <V>
 */
public class MyHashtable<K, V> {

    private Node[] table;
    public int size = 0;
    int capacity; //large prime number
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

    public MyHashtable(int capacity) {
        this.capacity = capacity;
        table = new Node[capacity];
    }

    /**
     * Adds key value pair to table.
     * @param key
     * @param value
     */
    public void put(K key, V value) {
        int hash = getHash(key);

        //no collision
        if(table[hash] == null) {
            table[hash] = new Node(key, value);
            size++;
        } else {
            //Collision
            //Key could be anywhere in List, so traverse through list to check.
            Node next = table[hash];
            while(next != null && !next.key.equals(key)) {
                next = next.next;
            }
            if(next != null && next.key.equals(key)) {
                //Over write existing value
                next.value = value;
            } else {
                //Node is not in list, so add new Node.
                Node<K, V> newValue = new Node(key, value);
                size++;

                //adds new value to head;
                newValue.next = table[hash];
                table[hash] = newValue;
            }

        }
    }

    //https://runzhuoli.me/2018/09/20/why-hashmap-size-power-of-2.html
    private int getHash(K key) {
        //What is hashCode?
        return Math.abs(key.hashCode() % capacity);// Remainder of capacity will always be a index less than capacity.
    }

    /**
     * Returns but does remove value if value
     * for corresponding key is found.
     * @param key unique key
     * @return V value;
     */
    public V get(K key) {
        int hash = getHash(key);
        Node<K, V> n = table[hash];
        while(n != null) {
            if(n.key.equals(key))
                return n.value;
            n = n.next;
        }
        return null;
    }

    /**
     * Removes and retirevs value if found.
     * @param key unique key.
     * @return null if not found.
     */
    public V remove(K key) {
        int hash = getHash(key);
        Node<K, V> n = table[hash];
        Node<K, V> prev = table[hash];
        V v = null;
        if (n != null) {
            while(n.next != null) {
                prev = n;
                n = n.next;
                //Could be middle or last element
                if(n.key.equals(key)) {
                    size--;
                    v = n.value;
                    n = n.next;
                    prev.next = n;
                    return v;
                }
            }

            //Only one element for this key so can set whole element to null.
            if(n.key.equals(key)) {
                size--;
                v = n.value;
                table[hash] = null;
            }
        }
        return v;
    }

    /**
     * Returns the number of key-value mappings in this map.  If the
     * map contains more than {@code Integer.MAX_VALUE} elements, returns
     * {@code Integer.MAX_VALUE}.
     *
     * @return the number of key-value mappings in this map
     */
    public int size() {
        return size;
    }

    /**
     * Checks if key is in table
     * @param key
     * @return true if key found
     */
    public boolean contains(K key) {
        return get(key) != null;
    }
}

