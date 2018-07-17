package com.ldy.java.AlgrithmnPratise;

import java.util.Scanner;

/**
 * Created by liudeyu on 2017/4/5.
 */
public class BoneCollector {
    int[] weight;
    int[] value;
    int totalWeight;
    int maxValue;

    public BoneCollector() {
        maxValue = Integer.MIN_VALUE;
    }

    public int solve() {
        int[] arrayMaxValue = new int[totalWeight + 1];
        arrayMaxValue[0] = 0;
        for (int i = 1; i <= weight.length; i++) {
            for (int j = totalWeight; j >= weight[i - 1]; j--) {
                arrayMaxValue[j] = Math.max(arrayMaxValue[j - weight[i - 1]] + value[i - 1], arrayMaxValue[j]);
            }
        }
        return arrayMaxValue[totalWeight];
    }

    public int solve2() {
        int num = weight.length;
        int[][] V = new int[totalWeight + 1][];
        for (int i = 0; i < V.length; i++) {
            V[i] = new int[num + 1];
        }
        for (int i = 1; i <= totalWeight; i++) {
            for (int j = 1; j <= num; j++) {
                if (i >= weight[j - 1]) {
                    V[i][j] = Math.max(value[j - 1] + V[i - weight[j - 1]][j - 1], V[i][j - 1]);
                } else {
                    V[i][j] = V[i][j - 1];
                }
            }
        }
        return V[totalWeight][num];

    }

    public static void main(String[] args) {
        int test;
        Scanner scanner = new Scanner(System.in);
        test = scanner.nextInt();
        for (int i = 0; i < test; i++) {
            int num, volumn;
            num = scanner.nextInt();
            volumn = scanner.nextInt();
            int[] values = new int[num];
            int[] weights = new int[num];
            for (int a1 = 0; a1 < num; a1++) {
                values[a1] = scanner.nextInt();
            }
            for (int a2 = 0; a2 < num; a2++) {
                weights[a2] = scanner.nextInt();
            }
            BoneCollector packageProblem = new BoneCollector();
            packageProblem.value = values;
            packageProblem.weight = weights;
            packageProblem.totalWeight = volumn;
            int aMax = packageProblem.solve();
            System.out.println(aMax);

        }

    }
}
