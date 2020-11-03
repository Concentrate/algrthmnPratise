package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist;

/**
 * @author: liudeyu
 * @date: 2020/11/3
 */


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * <p>
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 */
public class MaxMatrixArea {


    int maxMatrixArea(int[] tmpArr) {
        if (tmpArr == null || tmpArr.length == 0) {
            return 0;
        }
        int beforeMaxHight = Integer.MIN_VALUE;
        int currentMinHight = Integer.MAX_VALUE;
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < tmpArr.length; i++) {

            beforeMaxHight = Math.max(beforeMaxHight, tmpArr[i]);
            currentMinHight = tmpArr[i];
            for (int j = i; j < tmpArr.length; j++) {
                currentMinHight = Math.min(currentMinHight, tmpArr[j]);
                maxArea = Math.max(maxArea, (j - i + 1) * currentMinHight);
            }
        }
        return maxArea;
    }


    int maxMatrixArea2(int[] tmpArr) {
        if (tmpArr == null || tmpArr.length == 0) {
            return 0;
        }
        int result = 0;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < tmpArr.length; i++) {

            while (deque.size() != 0 && tmpArr[deque.peekLast()] > tmpArr[i]) {
                int pos = deque.pop();
                result = Math.max(result, (i - pos + 1) * tmpArr[pos]);
            }
            deque.push(i);
        }
        return result;
    }

    public static void main(String[] args) {


        MaxMatrixArea maxMatrixArea = new MaxMatrixArea();
        int[] tmpInput = {4, 2, 0, 3, 2, 5};
        System.out.println(maxMatrixArea.maxMatrixArea(tmpInput));
        System.out.println(maxMatrixArea.maxMatrixArea2(tmpInput));

    }
}
