package com.com.ldy.java.letcodepratise;

import com.com.ldy.java.Util.ArrayUtils;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liudeyu on 2020/2/23.
 */
public class MaxContinueSubArraySum {


    public int getMaxSubArraySum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int maxSumRes = array[0];
        int[] includeLastSum = new int[array.length];
        int maxSubEndIndex = 0;
        includeLastSum[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            includeLastSum[i] = Math.max(includeLastSum[i - 1] + array[i], array[i]);
            if (maxSumRes < includeLastSum[i]) {
                maxSumRes = includeLastSum[i];
                maxSubEndIndex = i;
            }
        }

        List<Integer> subArray = new ArrayList<>();
        int tmpSum = 0;
        for (int j = maxSubEndIndex; j >= 0; j--) {
            subArray.add(array[j]);
            tmpSum += array[j];
            if (tmpSum == maxSumRes) {
                break;
            }
        }

        ArrayUtils.displayArray(Lists.reverse(subArray));
        return maxSumRes;
    }


    public static void main(String[] argv) {

        int[] tmpArr = new int[5];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < tmpArr.length; i++) {
            tmpArr[i] = scanner.nextInt();
        }
        System.out.println(new MaxContinueSubArraySum().getMaxSubArraySum(tmpArr));
    }
}
