package com.com.ldy.java.AlgrithmnPratise.ArrayPratise;

import com.com.ldy.java.Util.ArrayUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liudeyu on 2019/11/18.
 */
public class DikaerMutliperPrint {


    static List<List<String>> randomCreateMultrix() {
        List<List<String>> result = new ArrayList<>();
        int index = 0;
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            tmp.add(charAddIndex('a', i));
            if (i % 5 == 0 && i != 0) {
                result.add(tmp);
                tmp = new ArrayList<>();
            }
        }
        return result;
    }


    static String charAddIndex(char tmp, int offset) {
        return String.valueOf((char) (tmp + offset));
    }

    static void printDikaerRes(List<List<String>> inputMatr) {
        if (inputMatr == null || inputMatr.size() == 0) {
            return;
        }
        StringBuilder builder = new StringBuilder();
        toImpleRecursivePringD(inputMatr, 0, builder);

    }

    private static void toImpleRecursivePringD(List<List<String>> inputMatr, int i, StringBuilder builder) {
        if (i == inputMatr.size() - 1) {
            List<String> tmpLast = inputMatr.get(i);
            for (String a1 : tmpLast) {
                System.out.println(builder.toString() + a1);
            }
            return;
        }
        List<String> curList = inputMatr.get(i);
        StringBuilder rawStringBu = new StringBuilder(builder.toString());
        for (int j = 0; j < curList.size(); j++) {
            builder=new StringBuilder(rawStringBu);
            builder.append(curList.get(j));
            toImpleRecursivePringD(inputMatr, i + 1, builder);
        }

    }


    public static void main(String[] argv) {
        List<List<String>> martix = randomCreateMultrix();
        ArrayUtils.displayMatrix(martix);
        printDikaerRes(martix);

    }
}
