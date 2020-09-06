package com.testbyte;

import java.util.Comparator;

/**
 * @author: liudeyu
 * @date: 2020/7/9
 */
public class TestTemplate {


    public static <K, V> boolean compareValue(Comparator<? super K> comparable, K k1, K k2) {
        return comparable.compare(k1, k2) > 0;
    }


    interface ACompare{


         static void sayHello(){
            System.out.println("hello");
        }
    }

    public static void main(String[] args) {

    }
}
