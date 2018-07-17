package com.ldy.java.Util;

/**
 * Created by liudeyu on 2017/8/27.
 */
public class ArrayUtil {
    public static void displayArray(int []array){
        if(array==null){
            return;
        }
        for(int i=0;i<array.length;i++){
            if(i==0){
                System.out.print(array[i]);
            }else{
                System.out.print(" "+array[i]);
            }
        }
        System.out.println();
    }
}
