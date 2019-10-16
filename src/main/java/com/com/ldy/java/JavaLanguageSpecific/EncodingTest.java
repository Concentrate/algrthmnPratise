package com.com.ldy.java.JavaLanguageSpecific;

import java.io.UnsupportedEncodingException;

/**
 * Created by liudeyu on 2017/5/4.
 */
public class EncodingTest {


    public static void main(String[] args){

        String[] charsetNames={
                "utf-8",
                "utf-16",
                "UTF-16BE",
                "UTF-16LE",
                "UTF-32",
                "UTF-32BE",
                "UTF-32LE",
                "unicode",
                "GBK",
                "GB2312",
                "GB18030",
                "ISO8859-1",
                "BIG5",
                "ASCII"
        };


        for(int i=0;i<charsetNames.length;i++){
            printByteLength(charsetNames[i]);
        }

    }

    /**
     * String类的不带参数的getBytes()方法会以程序所运行平台的默认编码方式为准来进行转换，
     * 在不同环境下可能会有不同的结果，因此建议使用指定编码方式的getBytes(String charsetName)方法。
     */
    public static void printByteLength(String charsetName){
        String a="a";	//一个英文字符
        String b="啊";	//一个中文字符
        try {
            System.out.println(charsetName+"编码英文字符所占字节数:"+a.getBytes(charsetName).length);
            System.out.println(charsetName+"编码中文字符所占字节数:"+b.getBytes(charsetName).length);
            System.out.println();
        } catch (UnsupportedEncodingException e) {
            System.out.println("非法编码格式！");
        }
    }
}
