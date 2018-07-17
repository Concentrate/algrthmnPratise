package com.ldy.java.OjPratise;

/**
 * Created by liudeyu on 2017/9/18.
 */

import java.util.*;

public class Main {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static long fun(long x) {
        long index = 1;
        Set<Long> set = new TreeSet<Long>();
        set.add(1L);
        List<Long> array = new ArrayList<>();
        array.add(1L);
        while (!set.contains(x)) {
            int m = array.size();
            List<Long> another = new ArrayList<>();
            another.add(1L);
            for (int i = 0; i < m-1; i++) {
                long e = array.get(i) + array.get(i+1);
                set.add(e);
                another.add(e);
            }
            another.add(1L);
            array = another;
            index++;
        }
        return index;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long res;

        long _x;
        _x = Long.parseLong(in.nextLine().trim());

        res = fun(_x);
        System.out.println(String.valueOf(res));

    }
}
