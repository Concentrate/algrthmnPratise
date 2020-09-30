package com.com.ldy.java.AlgrithmnPratise.OjPratise;

import java.util.Scanner;

/**
 * Created by liudeyu on 2017/9/14.
 */
public class Main3 {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
//        Scanner scanner = InputUtil.getFileScanner();
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        int result = getResult(array);
        System.out.println(result);

    }

    private static int getResult(int[] array) {
        int total = 0;
        for (int i = 0; i < array.length; i++) {
            int first = array[i];
            for (int j = i + 1; j < array.length; j++) {
                int second = array[j];
                StringBuilder builder = new StringBuilder();
                int l2 = builder.append(second).toString().length();
                builder = new StringBuilder();
                int l1=builder.append(first).toString().length();

            }
        }
        return total;
    }
}
