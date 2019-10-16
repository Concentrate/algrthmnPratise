package com.com.ldy.java.OjPratise;


import com.com.ldy.java.Util.InputUtil;

import java.util.Scanner;

/**
 * Created by liudeyu on 2017/9/8.
 */
public class JDSecond {
    static int result = 0;
    static int target = 0;

    public static void main(String[] argv) {
        Scanner scanner = InputUtil.getFileScanner();
//        Scanner scanner = new Scanner(System.in);
        int left, right;
        String line = scanner.nextLine();
        String[] arry = line.split("\\s+");
        left = Integer.valueOf(arry[0]);
        right = Integer.valueOf(arry[1]);
        for (int i = left; i <= right; i++) {
            String t = String.valueOf(i);
            int[] tmp = transformString(t);
            target = getMidSum(tmp);
            boolean[] isVisit = new boolean[tmp.length];
            isVisit[0] = true;
            dfsSearchResult(isVisit, tmp, 0, tmp[0]);
        }
        System.out.println(result);

    }

    private static int getMidSum(int[] tmp) {
        int sum = 0;
        for (int i : tmp) {
            sum += i;
        }
        return sum / 2;
    }

    private static int[] transformString(String t) {
        int[] m = new int[t.length()];
        for (int i = 0; i < m.length; i++) {
            m[i] = Integer.parseInt(t.charAt(i)+"");
        }
        return m;
    }

    private static boolean dfsSearchResult(boolean[] isVisit, int[] array, int step, int tmpSum) {
        if (step >= array.length || tmpSum > target) {
            return false;
        } else if (tmpSum == target) {
            result++;
            return true;
        }
        for (int i = step + 1; i < array.length; i++) {
            if (!isVisit[i]) {
                isVisit[i] = true;
                boolean k = dfsSearchResult(isVisit, array, step + 1, tmpSum + array[i]);
                isVisit[i] = false;
                if (k) {
                    return true;
                }
            }
        }
        return false;
    }

}
