package com.com.ldy.java.letcodepratise.tree;

/**
 * Created by liudeyu on 2020/1/29.
 */
public class MaxSumInTree {
    int maxMany(int... argv) {
        int maxNum = argv[0];
        for (int tmp : argv) {
            if (tmp > maxNum) {
                maxNum = tmp;
            }
        }
        return maxNum;
    }

    public static void main(String[] argv) {

    }
}
