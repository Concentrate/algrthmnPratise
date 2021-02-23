package com.com.ldy.java.AlgrithmnPratise.sort;

/**
 * @author: liudeyu
 * @date: 2021/2/23
 */
public class MySort {


    public int[] MySort(int[] arr) {
        // write code here
        if (arr == null || arr.length <= 0) {
            return arr;
        }

        arr = toImpleteCombineSort(arr, 0, arr.length - 1);
        return arr;
    }


    private int[] toImpleteCombineSort(int[] arr, int start, int end) {
        if (arr == null || start >= end) {
            return arr;
        }
        int mid = start + (end - start) / 2;
        toImpleteQuickSort(arr, start, mid);
        toImpleteQuickSort(arr, mid + 1, end);

        int index1 = start;
        int index2 = mid + 1;
        int[] result = new int[end - start + 1];
        int index = 0;
        while (index1 <= mid && index2 <= end) {

            if (arr[index1] < arr[index2]) {
                result[index++] = arr[index1++];
            } else {
                result[index++] = arr[index2++];

            }
        }

        while (index1 <= mid) {
            result[index++] = arr[index1++];
        }
        while (index2 <= end) {
            result[index++] = arr[index2++];
        }

        return result;
    }

    private void toImpleteQuickSort(int[] arr, int start, int end) {
        if (start >= end) {
            return;
        }
        int sentinel = arr[end];
        int tmpStart = start, tmpEnd = end;
        while (tmpStart < tmpEnd) {

            while (tmpStart < tmpEnd && arr[tmpStart] <= sentinel) {
                tmpStart++;
            }

            if (tmpStart < tmpEnd) {
                arr[tmpEnd] = arr[tmpStart];
                tmpEnd--;
            }

            while (tmpEnd > tmpStart && arr[tmpEnd] >= sentinel) {
                tmpEnd--;
            }
            if (tmpStart < tmpEnd) {
                arr[tmpStart] = arr[tmpEnd];
                tmpStart++;
            }
        }
        arr[tmpStart] = sentinel;
        toImpleteQuickSort(arr, start, tmpStart - 1);
        toImpleteQuickSort(arr, tmpStart + 1, end);

    }


    public static void displayArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MySort mySort = new MySort();
        int[] arr1 = new int[]{1, 2, 43, 3, 223, 23, 5, 6, 7, 8};
        int[] arr2 = mySort.MySort(arr1);
        displayArray(arr2);
    }
}
