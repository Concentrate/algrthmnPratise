package com.com.ldy.java.Util;

/**
 * @author: liudeyu
 * @date: 2020/9/29
 */
public class DisplayUtils {


    public static  void outputMatrix(int[][] matrix) {
        if (matrix == null) {
            return;
        }
        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix[i].length; j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(matrix[i][j]);
                if (j == matrix[i].length - 1) {
                    System.out.println();
                }
            }
        }

    }
}
