package com.practice.lists;


public class MyArrayList<E> {
    private E[] ar;
    private int index = 0;
    private int DEFAULT_SIZE = 10;

    public MyArrayList() {
        ar = (E[]) new Object[DEFAULT_SIZE];
    }

    public boolean add(E o) {
        index++;
        if(index == ar.length) {
            ar = makeNewArray();
        }
        ar[index -1 ] = o;
        return true;
    }

    private E[] makeNewArray() {
        E[] ar = (E[]) new Object[this.index + DEFAULT_SIZE];

        for(int i = 0 ; i < this.index; i++) {
            ar[i] = this.ar[i];
        }
        return ar;
    }

    public int size() {
        return index;
    }

    public void clear() {
        ar = null;
        index = 0;
    }

    public boolean contains(E o) {
        if(ar != null) {
            for(E item : ar) {
                if(item == null)
                    break;

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
        return index == 0;
    }

    public E remove(int index) {
        E o = ar[index];
        while(ar[index] != null) {
            ar[index] = ar[index + 1];
            index++;
        }
        this.index--;
        return o;
    }
}
