package com.ldy.java.AlgrithmnPratise;

import com.sun.xml.internal.bind.v2.TODO;

/**
 * Created by liudeyu on 2017/3/12.
 */
public class ReverseNumber {
    public int reverse(int x) {
        String numFor = String.valueOf(x);
        int res = 0;
        int endWith = numFor.startsWith("-") ? 1 : 0;
        StringBuilder builder = new StringBuilder();
        for (int i = numFor.length() - 1; i >= endWith; i--) {
            builder.append(numFor.charAt(i));
        }
        if (numFor.startsWith("-")) {
            long tmp = Long.valueOf(builder.toString(), 10);
            tmp = -tmp;
            if (tmp >= Integer.MIN_VALUE) {
                res = (int) tmp;
            }

        } else {
            long tmp = Long.valueOf(builder.toString(), 10);
            if (tmp <= Integer.MAX_VALUE) {
                res = (int) tmp;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int t = -9;
        System.out.println(String.valueOf(t));
    }
}
