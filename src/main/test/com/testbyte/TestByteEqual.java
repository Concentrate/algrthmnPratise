package com.testbyte;

import com.google.common.collect.Lists;

import java.util.ArrayList;

/**
 * @author: liudeyu
 * @date: 2020/7/7
 */

public class TestByteEqual {


    public static void main(String[] args) {
        Byte a=1;
        Byte b=new Byte((byte) 1);

        Byte d=1;
        Byte f=(byte)1;
        int i1=1;
        System.out.println(a==b);
        System.out.println(a==f);
        System.out.println("byte compare new Byte is "+a.equals(b));
        System.out.println(a.equals((byte)i1));

        ArrayList<String> stringList = Lists.newArrayList();
        ArrayList<Integer> intList = Lists.newArrayList();
        System.out.println(stringList.getClass().isAssignableFrom(intList.getClass()));
    }

}
