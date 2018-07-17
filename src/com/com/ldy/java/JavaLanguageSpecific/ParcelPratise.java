package com.ldy.java.JavaLanguageSpecific;

import java.io.Serializable;

/**
 * Created by liudeyu on 2017/5/20.
 */
public class ParcelPratise {
    public static void main(String[]args){
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());

    }
}
class Cat implements Serializable{
    private static final long serialVersionUID=Cat.class.hashCode();
    private transient String name;



}