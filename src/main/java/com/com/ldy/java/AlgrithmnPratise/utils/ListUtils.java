package com.com.ldy.java.AlgrithmnPratise.utils;

import java.util.List;

/**
 * @author: liudeyu
 * @date: 2020/11/12
 */
public class ListUtils {


    public static <T> void printList(List<T> tmpList, int startIndex) {
        if (tmpList == null || tmpList.size() == 0 || startIndex >= tmpList.size()) {
            System.out.println();
            return;
        }
        System.out.print(tmpList.get(startIndex) + " ");
        printList(tmpList, startIndex + 1);
    }
}
