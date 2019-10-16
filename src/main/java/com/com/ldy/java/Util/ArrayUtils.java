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
}
