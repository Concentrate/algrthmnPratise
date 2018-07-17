package com.ldy.java.OjPratise;


import com.ldy.java.AlgrithmnPratise.ConstantsVariable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/8/31.
 */
public class Main1 {
    public static void main(String[] argv) {
        Scanner scanner = getScanner();
        while (scanner.hasNext()) {
            int number = scanner.nextInt();
            int[] array = new int[number];
            for (int i = 0; i < number; i++) {
                array[i] = scanner.nextInt();
            }
            int valK = scanner.nextInt();
            int result = dividerAndConquerGetKTimes(array, 0, array.length - 1, valK);
            System.out.println(result + "\n");
        }

    }

    private static int dividerAndConquerGetKTimes(int[] array, int start, int end, int val) {
        if (array == null) {
            return 0;
        }
        if (start >= end) {
            return array[start] % val == 0 ? 1 : 0;
        }
        int mid = start + (end - start) / 2;
        int leftSum = dividerAndConquerGetKTimes(array, start, mid - 1, val);
        int rightSum = dividerAndConquerGetKTimes(array, mid + 1, end, val);
        int midMaxSum = 0;
        int tmpSum = array[mid];
        for (int i = mid; i <= end; i++) {
            tmpSum = 0;
            for (int j = i; j >= start; j--) {
                tmpSum += array[j];
                if (tmpSum % val == 0 && tmpSum > val) {
                    int a1 = i - j + 1;
                    if (a1 > midMaxSum) {
                        midMaxSum = a1;
                    }
                }
            }
        }

        return threeMax(leftSum, rightSum, midMaxSum);
    }

    private static int threeMax(int i, int i1, int i2) {
        int a = i > i1 ? i : i1;
        return a > i2 ? a : i2;
    }


    public static Scanner getScanner() {
        Scanner scanner = null;
//        scanner = new Scanner(System.in);
        try {
            scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return scanner;
    }
}
