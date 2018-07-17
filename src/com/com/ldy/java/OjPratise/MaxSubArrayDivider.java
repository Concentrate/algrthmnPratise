package com.ldy.java.OjPratise;


import com.ldy.java.AlgrithmnPratise.ConstantsVariable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/8/26.
 */
public class MaxSubArrayDivider {
    public static void main(String[] argv) {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//        scanner = new Scanner(System.in);
        int CONST_SIZE = 100000;
        int[] array = new int[CONST_SIZE];
        int realSize = 0;
        while (scanner.hasNext()) {
            array[realSize] = scanner.nextInt();
            realSize++;
        }
        int result = dividerAndConquer(array, 0, realSize - 1);
        System.out.println(result);
    }

    private static int dividerAndConquer(int[] array, int start, int end) {
        if (array == null) {
            return 0;
        }
        if (start >= end) {
            return array[start];
        }
        int mid = start + (end - start) / 2;
        int leftSum = dividerAndConquer(array, start, mid);
        int rightSum = dividerAndConquer(array, mid + 1, end);
        int midMaxSum = array[mid];
        int tmpSum = array[mid];
        for (int i = mid - 1; i >= start; i--) {
            tmpSum += array[i];
            if (tmpSum > midMaxSum) {
                midMaxSum = tmpSum;
            }
        }
        tmpSum = midMaxSum;
        for (int j = mid + 1; j <= end; j++) {
            tmpSum += array[j];
            if (tmpSum > midMaxSum) {
                midMaxSum = tmpSum;
            }
        }
        return threeMax(leftSum, rightSum, midMaxSum);
    }

    private static int threeMax(int leftSum, int rightSum, int midMaxSum) {
        int tmp1 = leftSum > rightSum ? leftSum : rightSum;
        return tmp1 > midMaxSum ? tmp1 : midMaxSum;
    }
}
