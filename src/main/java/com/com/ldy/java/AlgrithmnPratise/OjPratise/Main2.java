package com.com.ldy.java.AlgrithmnPratise.OjPratise;

import java.util.Scanner;


/**
 * Created by liudeyu on 2017/9/9.
 */
public class Main2 {
    private static int n;

    public static void main(String[] argv) {
//        Scanner scanner = InputUtil.getFileScanner();
        Scanner scanner = new Scanner(System.in);
        int testTime = scanner.nextInt();
        while ((testTime--) != 0) {
            n = scanner.nextInt();
            int[] array = new int[n];
            int fourTimes = 0, evenNumber = 0;
            boolean isOk = false;
            for (int i = 0; i < array.length; i++) {
                array[i] = scanner.nextInt();
                if (array[i] % 4 == 0) {
                    fourTimes++;
                }
                if (array[i] % 2 != 0) {
                    evenNumber++;
                }
            }

            if (evenNumber == fourTimes + 1 && evenNumber + fourTimes == n) {
                isOk = true;
            }
            if (fourTimes >= evenNumber) {
                isOk = true;
            }
            if (isOk) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }


}
