package com.com.ldy.java.AlgrithmnPratise.ArrayPratise;


import java.util.Scanner;

/**
 * Created by liudeyu on 2017/9/18.
 */
public class TwoMensionArray {
    int[][] matrix;


    /*
    题目：
在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

基本思想：
首先选取数组中右上角的数字。如果等于要找的数字，结束。如果大于要找的数字，剔除这个数字所在的列；如果小于要找的数字，剔除这个数字所在的行。
————————————————
版权声明：本文为CSDN博主「杜鲁门」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/bug_moving/article/details/55095507
    * */

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
