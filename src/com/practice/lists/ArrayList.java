package com.practice.lists;

import java.util.Arrays;

public class ArrayList<E> {
    private E[] ar;
    private int size = 0;

    public ArrayList(int size) {
        this.size = size;
        ar = (E[]) new Object[size];
    }

    public boolean add(E o) {
        size++;
        if(size == ar.length)
            ar = Arrays.copyOf(ar, size);
        ar[size -1 ] = o;
        return true;
    }

    public int size() {
        return size;
    }

    public void clear() {
        ar = null;
        size = 0;
    }

    public boolean contains(E o) {
        if(ar != null) {
            for(E item : ar) {
                if(item.equals(o))
                    return true;
            }
        }
        return false;
    }

    public E get(int index) {
        return ar[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        E o = ar[index];
        System.arraycopy(ar, index + 1, ar, index, size - index - 1);

        ar[--size] = null;
        return o;
    }
}
