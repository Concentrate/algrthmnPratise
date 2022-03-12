package com.com.ldy.java.tmp;

public class quicksort {


    public static void quickSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        toImplementQuickSort(array, 0, array.length - 1);

    }

    private static void toImplementQuickSort(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int privot = array[end];
        int left = start;
        int right = end;

        while (left < right) {
            while (left < right && array[left] < privot) {
                left++;
            }
            if (left < right) {
                array[right] = array[left];
                right--;
            }

            while (left < right && array[right] > privot) {
                right--;
            }
            if (left < right) {
                array[left] = array[right];
                left++;
            }

        }
        // right pos at privot
        array[left] = privot;
        toImplementQuickSort(array, start, left - 1);
        toImplementQuickSort(array, left + 1, end);
    }


    public static void main(String[] args) {
        int []array={1,88,39,90,5,6,7};
        quickSort(array);
        for(int i=0;i<array.length;i++){
            System.out.println(array[i]+" ");
        }
    }
}
