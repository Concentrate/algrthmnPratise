package com.com.ldy.java.AlgrithmnPratise.leetcodestruct;

import java.util.Scanner;

public class Main {


    public static class Pair {
        int first;
        int second;

        public Pair(int a, int b) {
            first = a;
            second = b;
        }
    }

    public static int[][] generZipMatrix(int M, int N) {

        if (M <= 0 || N <= 0) {
            return null;
        }
        int[][] matrix = new int[M][];
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[N];
        }
        int total = M * N;
        int tmpCount = 1;

        int travelX = 0, travelY = 0;

        Pair rightTopToleftBottom = new Pair(1, -1);
        Pair leftBottomToRightTop = new Pair(-1, 1);

        matrix[travelX][travelY] = tmpCount++;

        while (tmpCount <= total) {




            if (travelY < N - 1) {
                travelY++;
            } else {
                // think
                travelX++;
            }




            while (travelY > 0 && travelY <= N - 1 && travelX >= 0 && travelX <= M - 1) {
                matrix[travelX][travelY] = tmpCount++;

                travelX = travelX + rightTopToleftBottom.first;
                travelY = travelY + rightTopToleftBottom.second;

            }




            if (travelX < M - 1) {
                travelX++;
            } else {
                // think 
                travelY++;
            }




            while (travelY >= 0 && travelY <= N - 1 && travelX >= 0 && travelX <= M - 1) {

                matrix[travelX][travelY] = tmpCount++;

                travelX = travelX + leftBottomToRightTop.first;
                travelY = travelY + leftBottomToRightTop.second;

            }

            if (travelX >= M - 1) {
                travelX = M - 1;
            } else if (travelX <= 0) {
                travelX = 0;
            }

            if (travelY >= N - 1) {
                travelY = N - 1;
            } else if (travelY <= 0) {
                travelY = 0;
            }


        }

        return matrix;


    }

    public static void printMatrix(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + "  ");
            }

            System.out.println();
        }
    }

    public static int[][] genMatr(int M, int N) {
        int[][] matrix = new int[M][];
        int tmpCount = 1;
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new int[N];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = tmpCount++;
            }

        }

        return matrix;

    }

    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        // System.out.println("Hello World!");

        int M = 9, N = 9;

        int[][] genMa = genMatr(M, N);
        // printMatrix(genMa);
        int[][] zipMatr = generZipMatrix(M, N);
        printMatrix(zipMatr);


    }
}