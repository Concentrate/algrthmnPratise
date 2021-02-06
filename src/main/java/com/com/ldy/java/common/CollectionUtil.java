package com.com.ldy.java.common;

import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import org.springframework.cglib.core.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Created by liudeyu on 2019/10/14.
 */
public class CollectionUtil {


    public static int[] listToArray(List<Integer> list) {
        if (list == null) {
            return null;
        }

        int[] arr = new int[list.size()];
        for (int a1 = 0; a1 < list.size(); a1++) {
            arr[a1] = list.get(a1);
        }
        return arr;
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

    public static int[] randomCreateArray(int length) {
        int[] tmp = new int[length];
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            tmp[i] = random.nextInt(length);
        }
        return tmp;
    }


    public static List<Integer> copyList(List<Integer> src) {
        if (src == null) {
            return Collections.emptyList();
        }
        List<Integer> dest = new ArrayList<>();
        for (int k1 : src) {
            dest.add(k1);
        }
        return dest;
    }

}
