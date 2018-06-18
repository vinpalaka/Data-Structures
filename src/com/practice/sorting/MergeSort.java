package com.practice.sorting;

public class MergeSort {
    public void mergeSort(int[] ar) {
        if(ar.length < 2)
            return;
        int mid = ar.length/2;
        int[] left = new int[mid];
        int[] right = new int[ar.length - mid];
        for(int i = 0; i< left.length; i++)
            left[i] = ar[i];
        for(int i = 0; i < right.length;i++)
            right[i] = ar[mid + i];
        mergeSort(left);
        mergeSort(right);
        merge(left,right,ar);
    }

    private void merge(int[] left, int[] right, int[] ar) {
        int leftEnd = left.length;
        int rightEnd = right.length;
        int leftPtr = 0;
        int rightPtr = 0;
        int index = 0;
        while(leftPtr < leftEnd && rightPtr < rightEnd) {
            if(left[leftPtr] < right[rightPtr]) {
                ar[index++] = left[leftPtr++];
            } else {
                ar[index++] = right[rightPtr++];
            }

        }
        while (leftPtr < leftEnd) {
            ar[index++] = left[leftPtr++];
        }
        while (rightPtr < rightEnd) {
            ar[index++] = right[rightPtr++];
        }
    }


}
