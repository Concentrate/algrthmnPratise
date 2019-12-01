package com.com.ldy.java.Util;


import com.com.ldy.java.common.IterableUtils;

import java.util.List;

/**
 * Created by liudeyu on 2017/8/27.
 */
public class ArrayUtils {
    public static void displayArray(int[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (i == 0) {
                System.out.print(array[i]);
            } else {
                System.out.print(" " + array[i]);
            }
        }
        System.out.println();
    }




    public static void displayArray(List<Integer> array) {
        IterableUtils.forEach(array, (index, num) -> {
            System.out.print(num + " ");
            if (index % 10 == 0) {
                System.out.println();
            }
        });

        System.out.println();
    }

    public static <T> void displayTArray(List<T> array) {
        if (array == null || array.size() == 0) {
            return;
        }
        IterableUtils.forEach(array, (index, arr) -> {
            System.out.print(arr + " ");
            if (index % 10 == 0 && index != 0) {
                System.out.println();
            }
        });
        System.out.println();
    }

    public static <T> void displayMatrix(List<List<T>> matrix) {
        if (matrix == null || matrix.size() == 0) {
            return;
        }
        IterableUtils.forEach(matrix, (index, array) -> {
            displayTArray(array);
        });
    }
}
