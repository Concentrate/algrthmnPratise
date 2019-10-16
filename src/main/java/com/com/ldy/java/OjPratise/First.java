package com.com.ldy.java.OjPratise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/9/8.
 */
public class First {
    static char LEFT = '(';
    static char RIGHT = ')';

    public static void main(String[] argv) {
//        Scanner scanner = InputUtil.getFileScanner();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        List<Integer> recordLeftTotal = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            recordLeftTotal.add(1);
        }
        int index = 0;
        boolean isFirst = true;
        for (int i = 0; i < line.length() - 2; i++) {
            if (line.charAt(i) == LEFT && line.charAt(i + 1) == LEFT) {
                int num = recordLeftTotal.get(index);
                recordLeftTotal.set(index, num + 1);
                isFirst = true;
            } else {
                if (isFirst) {
                    isFirst = false;
                    index++;
                }
            }
        }
        int totalResulut = getTotalPermutation(recordLeftTotal, index);
        System.out.println(totalResulut);
    }

    private static int getTotalPermutation(List<Integer> recordLeftTotal, int index) {
        if (index == 0) {
            return 1;
        }
        int sum = 0;
        for (int i = 0; i < index; i++) {
            int k = permutation(recordLeftTotal.get(i));
            sum = Math.max(k, sum);
        }
        return sum;
    }

    private static int permutation(Integer integer) {
        int t = integer;
        int total = 1;
        while (t >= 1) {
            total *= (t--);
        }
        return total;
    }
}
