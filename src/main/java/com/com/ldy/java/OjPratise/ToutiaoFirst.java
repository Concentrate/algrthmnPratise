package com.com.ldy.java.OjPratise;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/9/10.
 */
public class ToutiaoFirst {
    int RowNum;
    int continueCountNum;
    int totalColor;
    ArrayList<Integer>[] matrix;
    int[] lastColorCount;
    boolean[] colorRecord;

    public void setMatrix(Scanner scanner) {
        matrix = new ArrayList[RowNum];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new ArrayList<>();
        }
        lastColorCount = new int[totalColor + 1];
        colorRecord = new boolean[totalColor + 1];
        for (int i = 0; i < RowNum; i++) {
            int tmpNum = scanner.nextInt();
            for (int j = 0; j < tmpNum; j++) {
                matrix[i].add(scanner.nextInt());
            }
        }

    }

    public int solveProblem() {
        for (int i = 0; i < RowNum; i++) {
            for (int j = 0; j < continueCountNum; j++) {
                int tmp = (i + j) % RowNum;
                for (int a1 = 0; a1 < matrix[tmp].size(); a1++) {
                    int b1 = matrix[tmp].get(a1);
                    lastColorCount[b1]++;
                }
            }
            for (int a2 = 0; a2 < lastColorCount.length; a2++) {
                if (lastColorCount[a2] >= 2) {
                    colorRecord[a2] = true;
                }
            }
            for (int a2 = 0; a2 < matrix[i].size(); a2++) {
                int tmp = matrix[i].get(a2);
                lastColorCount[tmp]--;
            }

        }
        int total = 0;
        for (int i = 0; i < colorRecord.length; i++) {
            if (colorRecord[i]) {
                total++;
            }
        }
        return total;
    }


    public static void main(String[] argv) {
//        Scanner scanner = InputUtil.getFileScanner();
        Scanner scanner=new Scanner(System.in);
        ToutiaoFirst main = new ToutiaoFirst();
        main.RowNum = scanner.nextInt();
        main.continueCountNum = scanner.nextInt();
        main.totalColor = scanner.nextInt();
        main.setMatrix(scanner);
        System.out.println(main.solveProblem());

    }
}
