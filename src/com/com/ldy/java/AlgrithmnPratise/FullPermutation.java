package com.ldy.java.AlgrithmnPratise;

import java.util.LinkedList;

/**
 * Created by liudeyu on 2017/4/8.
 */
public class FullPermutation {
    int[] record;
    LinkedList<Integer> list;
    int n;
    int count;
    int THEMAX = 100000000;
    int r;

    public FullPermutation() {
        list = new LinkedList<>();
        n = 10;
        record = new int[n];
        r = 2;
    }

    /* 回溯法的思考，类似深度优先遍历，其实回溯法就是相对来说比较万能也是比较暴力的方法了，
    * 也叫做万能的解法，搜索所有问题的解空间*/
    // 使用队列抽取，相比简单的record数组来记录，对于广度的全排列，速度要强的多
    public void getPermutation() {
        for (int i = 0; i < n; i++) {
            list.offer(i);
        }
        int[] buff = new int[n];
        long current = System.currentTimeMillis();
        count = 0;
//        queueRecursivePermution(0,buff);
//        regularRecursiveNotOptimeGetPermution(0,buff);
        divededPermutation();
        long afterCaclu = System.currentTimeMillis();
        System.out.println("total count is " + count + " and use time is " + (afterCaclu - current) + " ms");
    }

    // 对于使用数据record来说，由于每次递归都要遍历record数组，所以对于广度的全排列来说速度远远不如队列记录处理的方式
    private void regularRecursiveNotOptimeGetPermution(int step, int[] buff) {
        if (step >= n) {
            count++;
            return;
        }
        for (int i = 0; i < n; i++) {
            if (record[i] == 0) {
                record[i] = 1;
                buff[step] = i;
                if (count > THEMAX) {
                    return;
                }
                regularRecursiveNotOptimeGetPermution(step + 1, buff);
                record[i] = 0;
            }
        }

    }

    private void queueRecursivePermution(int i, int[] buff) {
        if (i >= n) {
//            displayResult(buff);
            count++;
            return;
        }
        int index = i;
        while (!list.isEmpty()) {
            index++;
            int top = list.poll();
//            System.out.print(" " + top);
            buff[i] = top;
            if (count > THEMAX) {
                return;
            }
            queueRecursivePermution(i + 1, buff);
            list.offer(top);
            if (index > n - 1) {
                break;
            }
        }
    }


    /* 分治法思考全排列方式，每次选择第i个，然后把除了i的元素进行全排列，为了好递归，每次先将i与第1个元素互换，然后将第2到第n
    * 个元素进行全排列，然后将i和第1个进行调换，所有子问题的解就是原问题的解,这个速度更快,比队列优化的普通回溯要快*/
    public void divededPermutation() {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        toImplementDividedPermutation(0, array);
    }

    private void toImplementDividedPermutation(int step, int[] array) {
        if (step >= n - 1) {
//           displayResult(array);
            count++;
            return;
        }
        for (int a1 = step; a1 < n; a1++) {
            mySwap(a1, step, array);
            if (count > THEMAX) {
                return;
            }
            toImplementDividedPermutation(step + 1, array);
            mySwap(a1, step, array);
        }
    }


    /*get combination ,from normal recursive Search*/

    public void getCombination() {

        count = 0;
        long startTime = System.currentTimeMillis();
        // TODO: 2017/4/8
//        normalRecursiveCombination();
        long endTime = System.currentTimeMillis();
        System.out.println("total count is " + count + " and use time is " + (endTime - startTime) + " ms");

    }

    private void normalRecursiveCombination() {
        int[] array = new int[r];
        int[] record = new int[n];

        toImplementNormalRecursiveCombination(0, 0, array, record);
    }

    private void toImplementNormalRecursiveCombination(int step, int fromIndex, int[] result, int[] book) {
        if (step >= r) {
            count++;
            displayResult(result);
            return;
        }
        for (int a1 = fromIndex; a1 < n; a1++) {
            if (book[a1] == 0) {
                book[a1] = 1;
                result[step] = a1;
                toImplementNormalRecursiveCombination(step + 1, a1 + 1, result, book);
                book[a1] = 0;
            }
        }
    }

    /*分治法求组合问题*/
    public void getCombinationWithConquerAndDivided(int step){
        

    }



    private void mySwap(int startIndex, int i, int[] array) {
        int tmp = array[startIndex];
        array[startIndex] = array[i];
        array[i] = tmp;
    }


    private void displayResult(int[] buff) {
        for (int a1 = 0; a1 < buff.length; a1++) {
            if (a1 != 0) {
                System.out.print(" ");
            }
            System.out.print(buff[a1]);
        }
        System.out.println("");
    }


    public static void main(String[] args) {
        FullPermutation permutation = new FullPermutation();
//        permutation.getPermutation();
        permutation.getCombination();
    }
}
