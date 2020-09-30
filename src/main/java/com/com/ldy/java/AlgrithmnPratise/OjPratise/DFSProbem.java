package com.com.ldy.java.AlgrithmnPratise.OjPratise;

import java.util.Scanner;

public class DFSProbem {
    public static boolean[][] isVisit;
    public static int countAre = 0;
    public static Node[] nextStep;


    public static void main(String[] argv) {

        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        scanner.nextLine();
        String[] array = new String[row];
        for (int a1 = 0; a1 < row; a1++) {
            array[a1] = scanner.nextLine();
        }
        char[][] matrix = new char[row][];
        for (int i = 0; i < row; i++) {
            matrix[i] = new char[row];
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                matrix[i][j] = array[i].charAt(j);
            }
        }
        isVisit = new boolean[row][];
        for (int i = 0; i < row; i++) {
            isVisit[i] = new boolean[row];
        }

        initStep();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < row; j++) {
                if (!isVisit[i][j] && matrix[i][j] == '*') {
                    countAre++;
                    dfsTraverse(matrix, i, j, row);
                }

            }
        }
        System.out.println(countAre);

    }

    private static void dfsTraverse(char[][] mat, int currentX, int currentY, int totalRow) {
        isVisit[currentX][currentY] = true;
        for (int i = 0; i < 8; i++) {
            int nextX = currentX + nextStep[i].x;
            int nextY = currentY + nextStep[i].y;
            if (nextX < 0 || nextX >= totalRow || nextY < 0 || nextY >= totalRow) {
                continue;
            }
            if (mat[nextX][nextY] == '*' && !isVisit[nextX][nextY]) {
                dfsTraverse(mat, nextX, nextY, totalRow);
            }
        }
    }

    private static void initStep() {
        nextStep = new Node[8];
        for (int i = 0; i < 8; i++) {
            nextStep[i] = new Node();
        }
        nextStep[0].y = -1;
        nextStep[0].x = 0;
        nextStep[1].y = -1;
        nextStep[1].x = 1;
        nextStep[2].y = 0;
        nextStep[2].x = 1;
        nextStep[3].y = 1;
        nextStep[3].x = 1;
        nextStep[4].y = 1;
        nextStep[4].x = 0;
        nextStep[5].y = 1;
        nextStep[5].x = -1;
        nextStep[6].y = 0;
        nextStep[6].x = -1;
        nextStep[7].y = -1;
        nextStep[7].x = -1;
    }


}

class Node {
    int x;
    int y;

    public Node() {
    }

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
