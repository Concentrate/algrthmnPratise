package com.ldy.java.OjPratise;

/**
 * Created by liudeyu on 2017/9/18.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class MiFirst {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static boolean fun(String table, int n) {
        boolean isOk = false;
        int num = n;

        for (int i = 0; i < table.length(); i++) {
            if (table.charAt(i) == '1') {
                num++;
            }
        }
        String[]tmp=table.split("1001");
        int aCount=0;
        for(int i=0;i<tmp.length;i++){
            if(!"".equals(tmp[i])){
                aCount++;
            }
        }
        if(tmp.length<=0) {
            return (table.length() + 1) / 2 >= num;
        }else{
            return (table.length()+1-aCount)/2>=num;
        }

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean res;

        String _table;
        try {
            _table = in.nextLine();
        } catch (Exception e) {
            _table = null;
        }

        int _n;
        _n = Integer.parseInt(in.nextLine().trim());

        res = fun(_table, _n);
        System.out.println(String.valueOf(res ? 1 : 0));
    }
}
