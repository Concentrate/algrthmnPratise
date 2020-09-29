package com.com.ldy.java.pointtooffer;

import com.com.ldy.java.Util.DisplayUtils;

/**
 * @author: liudeyu
 * @date: 2020/9/29
 */
public class TwoMensionArrayFindElement {


    static boolean findElement(int[][] matrix, int element) {
        if (matrix == null) {
            return false;
        }

        int row = matrix.length;
        int columnNum = matrix[0].length;

        int i = row - 1, j = 0;

        while (i >= 0 && j < columnNum) {

            if (matrix[i][j] == element) {
                return true;
            }

            if (matrix[i][j] > element) {
                i--;
            } else {
                j++;
            }

        }

        return false;

    }


    public static void main(String[] args) {

        int[][] matrix = new int[3][];
        int index = 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[matrix.length];
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = index++;
            }
        }

        DisplayUtils.outputMatrix(matrix);

        System.out.println(findElement(matrix, 399));

    }
}
