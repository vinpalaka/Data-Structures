package com.practice.sorting;

/**
 * Quicksort
 * Helpful video:
 * https://www.youtube.com/watch?v=COk73cpQbFQ
 */
public class QuickSort {
    public int[] sort(int[] ar) {
        sort(0, ar.length -1, ar);
        return ar;
    }

    private void sort(int low, int hi, int[] ar) {
        if(low < hi) {
            int partition = partition(ar, low, hi);
            sort(low, partition -1, ar);
            sort(partition + 1, hi, ar);
        }
    }

    private int partition(int[] ar, int low, int hi) {
        int pivot = ar[hi];
        int pivotIndex = low;
        for(int i = low; i < hi; i++) {
            //swaps higher things over to the right and keeps smaller on left
            if(ar[i] <= pivot) {
                swap(ar, i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(ar, hi, pivotIndex);//Moves pivot over to the right of all the small stuff.
        return pivotIndex;
    }

    private void swap(int[] ar, int i, int i1) {
        int temp = ar[i];
        ar[i] = ar[i1];
        ar[i1] = temp;
    }


}
