package com.com.ldy.java.AlgrithmnPratise.dynamicProgram;

import com.ldy.java.AlgrithmnPratise.ConstantsVariable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/4/5.
 */

/**
 * 连续递增的子数组序列
 */
public class MaxIncrementSubArray {
    public static String DATA_PATH = "/users/liudeyu/data.txt";

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
            int n = scanner.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = scanner.nextInt();
            }
            int result = getMaxIncrementSubArrayLength(array);
            System.out.println("the max increment sub array num is " + result);
            System.out.println(getMaxSubContinueVolence(array));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static int getMaxSubContinueVolence(int[] array) {

        int maxNum = -1;
        int tmpRecord = 0;
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] < array[j + 1]) {
                tmpRecord++;
            } else {
                tmpRecord = 1;
            }
            if (tmpRecord > maxNum) {
                maxNum = tmpRecord;
            }
        }


        return maxNum;

    }

    /**
     * wrong answer
     */
    @Deprecated
    public static int getMaxIncrementSubArrayLength(int[] array) {
        if (array == null) {
            return 0;
        }
        int[] result = new int[array.length];
        result[0] = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                result[i] = result[i - 1] + 1;
            } else {
                result[i] = 1;
            }
        }
        return result[array.length - 1];
    }
}
