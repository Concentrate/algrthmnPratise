package com.ldy.java.AlgrithmnPratise;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WYSecond {

    public static void main(String[] argv) {
//        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        Scanner scanner = new Scanner(System.in);
//        int size = scanner.nextInt();
//        int[] array = new int[size];
//        for (int i = 0; i < size; i++) {
//            array[i] = scanner.nextInt();
//        }
        while(true){
            int size=scanner.nextInt();
            int []array=new int[size];
            for(int i=0;i<array.length;i++){
                array[i]= (int) (Math.random()*array.length);
            }

            violenceSolve(array);

            int res = dividedAndConquerSolve(array, 0, array.length - 1);
            System.out.println(res);
        }


    }

    private static int dividedAndConquerSolve(int[] array, int start, int end) {
        if (array == null || start > end) {
            return 0;
        }
        if (start == end) {
            return array[start] * array[start];
        }
        int mid = start + (end - start) / 2;
        int leftSum = dividedAndConquerSolve(array, start, mid);
        int rightSum = dividedAndConquerSolve(array, mid + 1, end);
        int midMax = Integer.MIN_VALUE;
        for (int i = mid; i >= 0; i--) {
            int tmpSum = array[i];
            int minElement = array[i];
            int tmpResult = array[i] * array[i];
            for (int j = i + 1; j < array.length; j++) {
                minElement = minElement < array[j] ? minElement : array[j];
                tmpSum += array[j];
                int aMult = tmpSum * minElement;
                if (aMult > tmpResult) {
                    tmpResult = aMult;
                }
            }
            if (tmpResult > midMax) {
                midMax = tmpResult;
            }
        }
        int t1 = leftSum > rightSum ? leftSum : rightSum;
        return t1 > midMax ? t1 : midMax;
    }

    private static void violenceSolve(int[] array) {

        int maxResult = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            int thesum = array[i] * array[i];
            int theMin = array[i];
            int tmpSum = array[i];
            for (int j = i + 1; j < array.length; j++) {
                theMin = theMin < array[j] ? theMin : array[j];
                tmpSum += array[j];
                if (theMin * tmpSum > thesum) {
                    thesum = theMin * tmpSum;
                }
            }
            if (maxResult < thesum) {
                maxResult = thesum;
            }
        }
        System.out.println(maxResult);
    }

}