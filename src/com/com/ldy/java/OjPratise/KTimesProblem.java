package com.ldy.java.OjPratise;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/8/31.
 */
public class KTimesProblem {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }
        int tmpRecord = 0;
        int maxResult = Integer.MIN_VALUE + 99999;
        int[] result = new int[size + 1];
        result[0] = Integer.MIN_VALUE + 99999;
        for (int i = 0; i < size; i++) {
            if (i == 0) {
                result[0] = array[i];
            } else {
                if (result[i - 1] > 0) {
                    result[i] = result[i - 1] + array[i];
                } else {
                    result[i] = array[i];
                }
            }
        }
        for (int i = 0; i < size; i++) {
            if (result[i] > maxResult) {
                maxResult = result[i];
            }
        }
        System.out.println(maxResult);
    }
}
