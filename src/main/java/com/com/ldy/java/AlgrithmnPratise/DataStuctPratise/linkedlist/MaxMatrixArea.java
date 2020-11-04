package com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist;

/**
 * @author: liudeyu
 * @date: 2020/11/3
 */


import java.util.*;

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

//        Deque<Integer> deque = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tmpArr.length; i++) {

            while (stack.size() != 0 && tmpArr[stack.peek()] >= tmpArr[i]) {
                int pos = stack.pop();
                int tempMax = tmpArr[pos] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                result = Math.max(result, tempMax);
            }

            stack.push(i);
        }
        return result;
    }

    public int largestRectangleArea(int[] heights) {

        int n = heights.length;
        // Store indices.
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        int[] left = buildLeftBound(heights, stack);
        int[] right = buildRightBound(heights, stack);

        int ans = 0;
        for (int i = 0; i < n; i++) {
            int currHeightMax = heights[i] * (right[i] - left[i] - 1);
            System.out.println(String.format("当前 hight 最高的 的为 %s , 两边间距为 %s ,面积为 %s",
                    heights[i], (right[i] - left[i] - 1), currHeightMax));
            ans = Math.max(ans, currHeightMax);
        }
        return ans;
    }

    private int[] buildLeftBound(int[] h, ArrayDeque<Integer> stack) {
        int n = h.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int cur = h[i];
            while (!stack.isEmpty() && h[stack.peek()] >= cur) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        return ans;
    }

    private int[] buildRightBound(int[] h, ArrayDeque<Integer> stack) {
        stack.clear();
        int n = h.length;
        int[] ans = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            int cur = h[i];
            while (!stack.isEmpty() && h[stack.peek()] >= cur) {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {


        MaxMatrixArea maxMatrixArea = new MaxMatrixArea();
        int[] tmpInput = {4, 2, 0, 3, 2, 5};
        System.out.println(maxMatrixArea.maxMatrixArea(tmpInput));
        System.out.println(maxMatrixArea.maxMatrixArea2(tmpInput));
        System.out.println(maxMatrixArea.largestRectangleArea(tmpInput));

    }
}
