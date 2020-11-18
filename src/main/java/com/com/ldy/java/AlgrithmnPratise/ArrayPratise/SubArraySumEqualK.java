package com.com.ldy.java.AlgrithmnPratise.ArrayPratise;

/**
 * @author: liudeyu
 * @date: 2020/11/18
 */

/*
给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。

Example

Input:nums = [1,1,1], k = 2
Output: 2
* */
public class SubArraySumEqualK {


    /**暴力破解，O(n*k)简单能够想到*/

    /**
     * 有负数的时候就是错的，不是滑动窗口的解法
     * wrong answer!
     */
    int subArrayEqualK(int[] rawInput, int k) {

        if (rawInput == null || rawInput.length == 0) {
            return 0;
        }
        if (rawInput.length == 1) {
            return rawInput[0] == k ? 1 : 0;
        }
        int count = 0;
        int tmpSum = 0;
        for (int left = 0, right = 0; right < rawInput.length; right++) {
            tmpSum += rawInput[right];

            while (tmpSum >= k) {
                if (tmpSum == k) {
                    count++;
                }
                tmpSum -= rawInput[left++];
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubArraySumEqualK subArraySumEqualK = new SubArraySumEqualK();
        System.out.println(subArraySumEqualK.subArrayEqualK(new int[]{-1, -1, 1}, 0));

    }
}
