package com.common;

import com.algrithmntest.com.primenumberabout.PrimeNumberDetect;
import com.com.ldy.java.Util.ArrayUtils;

/**
 * Created by liudeyu on 2019/10/16.
 */
public class MainUtil {


    public static void main(String[]argv){
        PrimeNumberDetect detector=new PrimeNumberDetect();
        ArrayUtils.displayArray(detector.detectPrimeNumber(2,1000));
    }



}
