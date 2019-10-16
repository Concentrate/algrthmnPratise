package com.com.ldy.java.AlgrithmnPratise.ArrayPratise;


import java.util.Scanner;

/**
 * Created by liudeyu on 2017/9/18.
 */
public class TwoMensionArray {
    int[][] matrix;

    void initMatrix(int length) {
        matrix = new int[length][];
        for (int a1 = 0; a1 < matrix.length; a1++) {
            matrix[a1] = new int[length];
        }
        int index = 1;
        for (int a1 = 0; a1 < matrix.length; a1++) {
            for (int a2 = 0; a2 < matrix[a1].length; a2++) {
                matrix[a1][a2] = index++;
            }
        }
    }

    ANode findElement(int ele) {
        int verticalIndex = matrix.length - 1;
        int landIndex = 0;
        int resIndex = -1;
        while (verticalIndex >= 0 && landIndex <= matrix.length - 1) {
            if (matrix[landIndex][verticalIndex] > ele) {
                verticalIndex--;
            } else if (matrix[landIndex][verticalIndex] < ele) {
                landIndex++;
            } else {
                break;
            }
        }
        if (verticalIndex >= 0 && landIndex <= matrix.length - 1) {
            return new ANode(landIndex,verticalIndex);
        }else{
            return new ANode(-1,-1);
        }

    }

    public static void main(String[] argv) {
        TwoMensionArray twoMensionArray=new TwoMensionArray();
        twoMensionArray.initMatrix(10);
        Scanner scanner=new Scanner(System.in);
        while (true){
            int t=scanner.nextInt();
            ANode aNode=twoMensionArray.findElement(t);
            System.out.println(aNode.x+"   "+aNode.y);
        }

    }

    static class ANode {
        int x, y;

        public ANode(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
