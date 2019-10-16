package com.arrayabout;

import java.util.Random;

/**
 * Created by liudeyu on 2019/10/14.
 */
public class CombineSortArray {


    public static void sortArray(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int[] tmpArray = new int[array.length];
        divideAndConquersort(array, 0, array.length - 1, tmpArray);
    }

    public static void divideAndConquersort(int[] array, int start, int end, int[] tmpArray) {
        if (start < end) {
            int mid = (end + start) / 2;
            divideAndConquersort(array, start, mid, tmpArray);
            divideAndConquersort(array, mid + 1, end, tmpArray);
            mergeArray(array, start, mid, end, tmpArray);
        }

    }

    private static void mergeArray(int[] array, int start, int mid, int end, int[] tmpArray) {
        int i = start, j = mid + 1;
        int t = 0;
        while (i <= mid && j <= end) {
            if (array[i] < array[j]) {
                tmpArray[t++] = array[i++];
            } else {
                tmpArray[t++] = array[j++];
            }
        }
        while (i <= mid) {
            tmpArray[t++] = array[i++];
        }
        while (j <= end) {
            tmpArray[t++] = array[j++];
        }
        t = 0;
        while (start <= end) {
            array[start++] = tmpArray[t++];
        }
    }


    public static void displayArray(int[] array) {
        if (array == null) {
            return;
        }
        int index = 0;
        for (int i : array) {
            System.out.print(i + "  ");
            if ((index++) % 30 == 0) {
                System.out.println();
            }
        }
        System.out.println();
    }

    public static void main(String[] argv) {
        int length = 2000000;
        int[] cacluArray = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            cacluArray[i] = random.nextInt(length);
        }
        displayArray(cacluArray);
        sortArray(cacluArray);
        displayArray(cacluArray);
    }
}
