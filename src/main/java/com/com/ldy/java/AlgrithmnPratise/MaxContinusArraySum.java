package com.com.ldy.java.AlgrithmnPratise;

import com.ldy.java.AlgrithmnPratise.ConstantsVariable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class MaxContinusArraySum {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
        Scanner scanner = null;
        try {
            scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        int CONST_SIZE = 100000000;
        int[] array = new int[CONST_SIZE];
        int n = CONST_SIZE;
//        while (scanner.hasNext()) {
//            array[n] = scanner.nextInt();
//            n++;
//        }

        randomCreateData(array);
//        ArrayUtils.displayArray(array);

        testTimeUse(array);
    }

    private static void testTimeUse(int[] array) {
        long timeStart = System.currentTimeMillis();
        int result1 = dynamicGetContinueMaxSum(array, array.length);
        long timeEnd = System.currentTimeMillis();
        System.out.println("dynamic program use time is " + (timeEnd - timeStart) + " and result is " + result1);
        timeStart = System.currentTimeMillis();
        result1 = dividerAndConquer(array, 0, array.length - 1);
        timeEnd = System.currentTimeMillis();
        System.out.println("divide program use time is " + (timeEnd - timeStart) + " and result is " + result1);
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

    private static int dynamicGetContinueMaxSum(int[] array, int n) {
        int maxResult = array[0];
        int tmpSum = array[0];
        for (int i = 1; i < n; i++) {
            if (tmpSum > 0) {
                tmpSum += array[i];
            } else {
                tmpSum = array[i];
            }

            if (tmpSum > maxResult) {
                maxResult = tmpSum;
            }
        }

        return maxResult;
    }

    private static void randomCreateData(int[] array) {
        Random random = new Random(new Date().getTime());
        for (int i = 0; i < array.length; i++) {
            array[i] = (random.nextInt() %(1000)) * (Math.random() > 0.5 ? -1 : 1);
        }
    }


    private static int getContinueAdd(int beforeSum, int startIndex, int end, int[] array) {
        int tmpSum = beforeSum;
        for (int a1 = startIndex; a1 < end; a1++) {
            tmpSum += array[a1];
        }
        return tmpSum;
    }

    private static int threeMax(int i, int i1, int i2) {
        int a = i > i1 ? i : i1;
        return a > i2 ? a : i2;
    }


}
