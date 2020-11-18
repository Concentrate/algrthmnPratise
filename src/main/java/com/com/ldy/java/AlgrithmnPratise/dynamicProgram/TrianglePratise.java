package com.com.ldy.java.AlgrithmnPratise.dynamicProgram;

import java.util.Arrays;

/**
 * @author: liudeyu
 * @date: 2020/11/18
 */
public class TrianglePratise {


    public int findMinWayFromTopToBottom(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int[] result = new int[matrix[matrix.length - 1].length + 1];
        for (int a1 = 0; a1 < result.length; a1++) {
            if (a1 < matrix[matrix.length - 1].length) {
                result[a1] = matrix[matrix.length - 1][a1];
            } else {
                result[a1] = Integer.MAX_VALUE / 2;
            }
        }

        if (matrix.length >= 2) {

            for (int i = matrix.length - 2; i >= 0; i--) {

                for (int j = 0; j < matrix[i].length; j++) {
                    result[j] = Math.min(result[j] + matrix[i][j], result[j + 1] + matrix[i][j]);
                }

            }
        }
        int tmpResult = Integer.MAX_VALUE;
        for (int i = 0; i < matrix[0].length; i++) {
            tmpResult = Math.min(tmpResult, result[i]);
        }
        return tmpResult;
    }

    public static void main(String[] args) {


        TrianglePratise trianglePratise = new TrianglePratise();

        int[][] matrix = new int[4][];
        matrix[0] = new int[]{2};
        matrix[1] = new int[]{3, 4};
        matrix[2] = new int[]{6, 5, 7};
        matrix[3] = new int[]{4, 1, 8, 3};

        System.out.println(trianglePratise.findMinWayFromTopToBottom(matrix));

    }


}
