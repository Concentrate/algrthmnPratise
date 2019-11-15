package com.com.ldy.java.AlgrithmnPratise.recursivethink;

/**
 * Created by liudeyu on 2019/10/28.
 */

import com.com.ldy.java.Util.ArrayUtils;

import java.util.Scanner;

/**
 * 排列组合问题
 */
public class NumberpermutationPro {


    int totalCount = 0;
    int[] recordsUsed = new int[10000];


    void resetRecordArray() {
        for (int i = 0; i < recordsUsed.length; i++) {
            recordsUsed[i] = -1;
        }
        totalCount = 0;
    }

    /**
     * n places,caclu n places permutation,number from 0-n,n's permutation
     */
    public void printNNumPermutationPro(int n) {
        int[] result = new int[n];
        int[] elements = new int[n];
        for (int i = 0; i < n; i++) {
            elements[i] = i;
        }
        resetRecordArray();
        printNPermutaionRecur(elements, result, 0);

    }

    public void printNPermutaionRecur(int[] elements, int[] result, int currentStep) {
        if (currentStep >= elements.length) {
            totalCount++;
            ArrayUtils.displayArray(result);
            return;
        }

        for (int i = 0; i < elements.length; i++) {
            if (recordsUsed[elements[i]] == -1) {
                recordsUsed[elements[i]] = 1;
                result[currentStep] = elements[i];
                printNPermutaionRecur(elements, result, currentStep + 1);
                recordsUsed[elements[i]] = -1;
            }
        }
    }


    public static void main(String[] argv) {
        NumberpermutationPro pro = new NumberpermutationPro();
        while (true) {
            int n = (new Scanner(System.in)).nextInt();
            pro.printNNumPermutationPro(n);
            System.out.println("total count is " + pro.totalCount);
        }
    }


}
