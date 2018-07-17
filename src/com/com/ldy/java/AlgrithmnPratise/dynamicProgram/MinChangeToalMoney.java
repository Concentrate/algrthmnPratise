package com.ldy.java.AlgrithmnPratise.dynamicProgram;

import java.util.Scanner;

/**
 * Created by liudeyu on 2017/4/9.
 */
public class MinChangeToalMoney {
    /*如果我们有面值为1元、3元和5元的硬币若干枚，如何用最少的硬币凑够11元？ */
    int[] money;
    int changeMoney;
    int minNumber;
    int num;

    public MinChangeToalMoney(int[] money, int changeMoney) {
        this.money = money;
        this.changeMoney = changeMoney;
        num = money.length;
        minNumber = Integer.MAX_VALUE;
    }

    /*还是从最容易想到的回溯法想起*/
    public int recursiveGetMinNumberWithoutMemo(int curMoney, int curPosition, int mNumber) {


        if (curPosition >= num) {
            if (curMoney == changeMoney) {
                return mNumber;
            }
            return Integer.MAX_VALUE;
        }
        if (curMoney == changeMoney) {
            if (mNumber > minNumber) {
                minNumber = mNumber;
            }
            return mNumber;
        }

        int an1 = recursiveGetMinNumberWithoutMemo(curMoney + money[curPosition], curPosition + 1, mNumber + 1);
        int an2 = recursiveGetMinNumberWithoutMemo(curMoney, curPosition + 1, mNumber);
        return Math.min(an1, an2);
    }

    /* recursive agrithmn with memo*/
    public int recursiveGetMinNumberWithMemo() {
        int[][] memo = new int[num + 1][];
        for (int i = 0; i <= num; i++) {
            memo[i] = new int[changeMoney + 1];
        }

        return toImplementRecursiveWithMemo(memo, 0, 0, 0);
    }
    // todo 算法不对，待思考和修改，自顶向下带备忘录的recursive 结果不对
    private int toImplementRecursiveWithMemo(int[][] memo, int position, int curMoney, int coinNumber) {
        if (position >= num||curMoney>changeMoney) {
            if (curMoney == changeMoney) {
                return coinNumber;
            }
            return Integer.MAX_VALUE;
        }
        memo[position][curMoney] = coinNumber;
        if (curMoney == changeMoney) {
            if (coinNumber < minNumber) {
                minNumber = coinNumber;
            }
            return coinNumber;
        }

        int an, an1;
        if (curMoney+money[position]<=changeMoney&&memo[position + 1][curMoney + money[position]] != 0) {
            an = memo[position + 1][curMoney + money[position]];
        } else {
            an = toImplementRecursiveWithMemo(memo, position + 1, curMoney + money[position], coinNumber + 1);
        }
        if (position+1<num&&memo[position + 1][curMoney] != 0) {
            an1 = memo[position + 1][curMoney];
        } else {
            an1 = toImplementRecursiveWithMemo(memo, position + 1, curMoney, coinNumber);
        }
        return Math.min(an, an1);

    }


    /*动态规划，自底向上的思考*/
    int getMinNumOfChangeWithDynamicPragramAndSpaceOptime(){
        int []V=new int[changeMoney+1];
        for(int i=0;i<=changeMoney;i++){
            V[i]= 0;
            if(i!=0){
                V[i]=Integer.MAX_VALUE-10;
            }
        }
        for(int i=1;i<=num;i++){
            for(int j=changeMoney;j>=money[i-1];j--){
                V[j]=Math.min(V[j-money[i-1]]+1,V[j]);
            }
        }
        return V[changeMoney];
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
//            array[i]=scanner.nextInt();
            array[i] = i;
        }
//        int totalMoney=scanner.nextInt();
        int totalMoney = (0 + n - 1) * n / 2;
        MinChangeToalMoney changeToalMoney = new MinChangeToalMoney(array, totalMoney);
        long startTime = System.currentTimeMillis();
//        int minNumber = changeToalMoney.recursiveGetMinNumberWithoutMemo(0, 0, 0);
//        int minNumber = changeToalMoney.recursiveGetMinNumberWithMemo();
        int minNumber=changeToalMoney.getMinNumOfChangeWithDynamicPragramAndSpaceOptime();
        long endTime = System.currentTimeMillis();
        System.out.println("The min number is " + minNumber + " and use time is " + (endTime - startTime) + " ms");


    }
}
