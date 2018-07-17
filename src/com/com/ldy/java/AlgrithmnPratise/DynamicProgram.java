package com.ldy.java.AlgrithmnPratise;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/4/3.
 */
public class DynamicProgram {


    public static void main(String[] args) {
        try {
            InputStream inputStream = new FileInputStream("/Users/liudeyu/data.txt");
            Scanner scanner = new Scanner(inputStream);
            int maxWeight = scanner.nextInt();
            int n = scanner.nextInt();
            int[] weight = new int[n];
            int[] value = new int[n];
            for (int i = 0; i < n; i++) {
                weight[i] = scanner.nextInt();
                value[i] = scanner.nextInt();
            }
            packageProblem packageProblem = new packageProblem(weight, value, maxWeight);
            int maxValue;
//            int maxValue = packageProblem.getMaxValueByViolence();
//            maxValue=packageProblem.getMaxValueByDynamicProgram();
//            maxValue = packageProblem.getMaxValueByDynamicProgramAndSpaceOptimize();
            maxValue=packageProblem.completePackageByViolence();
            System.out.println("max is " + maxValue);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }
}

class packageProblem {
    int[] weight;
    int[] values;
    int maxWeigth;
    int[] record;
    int maxValue;

    public packageProblem(int[] weight, int[] values, int maxWeigth) {
        this.weight = weight;
        this.values = values;
        this.maxWeigth = maxWeigth;
        record = new int[weight.length];
    }


    public int getMaxValueByDynamicProgram() {
        int V[][] = new int[maxWeigth + 1][];
        for (int i = 0; i < maxWeigth + 1; i++) {
            V[i] = new int[weight.length + 1];
        }
        for (int a1 = 0; a1 <= weight.length; a1++) {
            V[0][a1] = 0;
        }
        for (int a2 = 0; a2 <= maxWeigth; a2++) {
            V[a2][0] = 0;
        }
        for (int i = 1; i <= maxWeigth; i++) {
            for (int j = 1; j <= weight.length; j++) {
                if (weight[j - 1] <= i) {
                    V[i][j] = Math.max(V[i - weight[j - 1]][j - 1] + values[j - 1], V[i][j - 1]);
                } else {
                    V[i][j] = V[i][j - 1];
                }
            }
        }
        return V[maxWeigth][weight.length];

    }

    public int getMaxValueByDynamicProgramAndSpaceOptimize() {
        int[] V = new int[maxWeigth + 1];
        V[0] = 0;
        for (int i = 1; i < weight.length + 1; i++) {
            for (int j = maxWeigth; j >= 1; j--) {
                if (j >= weight[i - 1]) {
                    V[j] = Math.max(V[j - weight[i - 1]] + values[i - 1], V[j]);
                }
            }
        }
        return V[maxWeigth];
    }

    public int getMaxValueByViolence() {
        toImplementMaxValueByViolence(0, 0, 0);
        return maxValue;
    }

    private void toImplementMaxValueByViolence(int step, int useWeight, int aValue) {
        if (step >= weight.length) {
            if (aValue > maxValue) {
                displayResult(aValue);
            }
            return;
        }
        for (int i = step; i < weight.length; i++) {
            if (weight[i] <= maxWeigth - useWeight) {
                record[i] = 1;
                toImplementMaxValueByViolence(i + 1, useWeight + weight[i], aValue + values[i]);
                record[i] = 0;
            } else {
                toImplementMaxValueByViolence(i + 1, useWeight, aValue);
            }
        }

    }

    public int completePackageByViolence() {
        completePackageByViolenceRecursive(0,0, 0);
        return maxValue;
    }

    private void completePackageByViolenceRecursive(int step, int useWeight, int aValue) {
        if (step >= weight.length) {
            if (aValue > maxValue) {
                maxValue = aValue;
            }
            return;
        }
        for (int i = step; i < weight.length; i++) {
            if (weight[i] <= maxWeigth - useWeight) {
                completePackageByViolenceRecursive(step, useWeight + weight[i], aValue + values[i]);
            } else {
                completePackageByViolenceRecursive(step + 1, useWeight, aValue);
            }
        }
    }


    private void displayResult(int aValue) {
        maxValue = aValue;
        System.out.println("max value is " + maxValue);
        boolean isFirst = true;
        ArrayList<Integer> integers = new ArrayList<>();
        for (int i = 0; i < record.length; i++) {
            if (record[i] == 1) {
                integers.add(i);
            }
        }
        int sum1 = 0, sum2 = 0;
        System.out.print("the weight is : ");
        for (int i = 0; i < integers.size(); i++) {
            if (i != 0) {
                System.out.print("+");
            }
            System.out.print(weight[integers.get(i)]);
            sum1 += weight[integers.get(i)];
        }
        System.out.print("=" + sum1 + "\n");
        System.out.print("the value is : ");
        for (int i = 0; i < integers.size(); i++) {
            if (i != 0) {
                System.out.print("+");
            }
            System.out.print(values[integers.get(i)]);
            sum2 += values[integers.get(i)];
        }
        System.out.println("=" + sum2 + "\n");
    }


}