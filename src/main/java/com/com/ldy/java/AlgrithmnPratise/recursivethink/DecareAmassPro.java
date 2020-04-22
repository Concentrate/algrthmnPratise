package com.com.ldy.java.AlgrithmnPratise.recursivethink;

import com.com.ldy.java.Util.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liudeyu on 2019/12/1.
 */
public class DecareAmassPro {
    int totalCount = 0;


    public void decareAmassPrint(List<List<Integer>> matrix) {

        if (matrix == null || matrix.size() == 0 || matrix.get(0).size() == 0) {
            return;
        }
        totalCount = 0;
        int[][] book = new int[matrix.size()][];
        for (int a1 = 0; a1 < book.length; a1++) {
            book[a1] = new int[matrix.get(a1).size()];
        }

        toImplementDecareAmssProSolve(matrix, 0, new int[matrix.size()]);
        System.out.println("total count is " + totalCount);


    }

    void toImplementDecareAmssProSolve(List<List<Integer>> matrix, int rowIndex, int[] resultStore) {
        if (rowIndex >= matrix.size()) {
            ArrayUtils.displayArray(resultStore);
            totalCount++;
            return;
        }

        for (int a1 = 0; a1 < matrix.get(rowIndex).size(); a1++) {
            resultStore[rowIndex] = matrix.get(rowIndex).get(a1);
            toImplementDecareAmssProSolve(matrix, rowIndex + 1, resultStore);
        }

    }


    public static void main(String[] argv) {

        DecareAmassPro decareAmassPro = new DecareAmassPro();
        int length = 5;
        List<List<Integer>> matrix = new ArrayList<>(length);
        int index = 0;
        for (int i = 0; i < length; i++) {
            matrix.add(new ArrayList<>(length));
            for (int b1 = 0; b1 < length; b1++) {
                matrix.get(i).add(index++);
            }
        }
        decareAmassPro.decareAmassPrint(matrix);
    }
}
