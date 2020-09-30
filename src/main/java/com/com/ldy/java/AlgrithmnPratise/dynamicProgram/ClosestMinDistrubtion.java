package com.com.ldy.java.AlgrithmnPratise.dynamicProgram;

import com.com.ldy.java.Util.ArrayUtils;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/4/9.
 */
/*
题目背景：
现在有一袋硬币，里面最多有100个硬币，面值区间为[1, 500]，要分给两个人，并使得他们所获得的金钱总额之差最小，并给出这个最小差值。
* */
public class ClosestMinDistrubtion {
    int total;
    int[] value;
    int minDifference = Integer.MAX_VALUE;
    int[][] memo;

    void initMemoSpace(int total, int n) {
        memo = new int[n+1][];
        for (int i = 0; i <= n; i++) {
            memo[i] = new int[total + 1];
        }
    }




    int minGapDistrubution(int step, int disOneValue) {
        if (step >= value.length) {
            if (Math.abs(total - disOneValue - disOneValue) < minDifference) {
                minDifference = Math.abs(total - disOneValue - disOneValue);
            }
            return Math.abs(total - disOneValue - disOneValue);
        }
        int ans = minGapDistrubution(step + 1, disOneValue + value[step]);
        int ans1 = minGapDistrubution(step + 1, disOneValue);
        return Math.min(ans, ans1);
    }


    int recursiveWithMemo(int step, int disOneValue) {
        memo[step][disOneValue] = Math.abs(total - disOneValue - disOneValue);
        if (step >= value.length) {
            if (Math.abs(total - disOneValue - disOneValue) < minDifference) {
                minDifference = Math.abs(total - disOneValue - disOneValue);
            }
            return Math.abs(total - disOneValue - disOneValue);
        }
        int an, an1;
        if (memo[step + 1][disOneValue + value[step]] != 0) {
            an = memo[step + 1][disOneValue + value[step]];
        } else {
            an = recursiveWithMemo(step + 1, disOneValue + value[step]);
        }
        if (memo[step + 1][disOneValue] != 0) {
            an1 = memo[step + 1][disOneValue];
        } else {
            an1 = recursiveWithMemo(step + 1, disOneValue);
        }
        return Math.min(an, an1);
    }


    /*动态规划自底向上的方式*/
    int minGapDitributionWithDynamicProgram(){
        int num=value.length;
        int [][]V=new int[num+1][];
        for(int i=0;i<num+1;i++){
            V[i]=new int[total+1];
        }
        for(int i=0;i<=total;i++){
            V[0][i]=Math.abs(total-2*i);
        }
        for(int i=0;i<=num;i++){
            V[i][0]=total;
        }
        for(int i=1;i<=num;i++){
            for(int j=1;j<=total;j++){
               if(j>=value[i-1]){
                   V[i][j]=Math.min(V[i-1][j-value[i-1]],V[i-1][j]);
               }else{
                   V[i][j]=V[i-1][j];
               }
            }
        }
        return V[num][total];
    }



    @Deprecated
    /**is wrong*/
    int stupidMinGapNarrowThink(){
        int []result = new int[value.length];
        result[0]=value[0];
        for(int a1=0;a1<value.length-1;a1++){
            result[a1+1]=Math.abs(result[a1]-value[a1+1]);
        }
        return result[value.length-1];
    }

    /**动态规划，自底向上空间优化*/
    int minGapDitributionDynamicWithSpaceOptime(){
        int n=value.length;
        int []V=new int[total+1];
        for(int i=0;i<=total;i++){
            V[i]=Math.abs(total-i-i);
        }
        for(int i=1;i<=n;i++){
            for(int j=total;j>=value[i-1];j--){
                V[j]=Math.min(V[j-value[i-1]],V[j]);
            }
        }
        return V[total];
    }



    public static void main(String[] args) {
        int n;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[] array = new int[n];
        int total = 0;
        Random random=new Random();
        for (int i = 0; i < n; i++) {
//            array[i] = scanner.nextInt();
//            array[i]= (int) (Math.random()*n);
            array[i]=random.nextInt(n);
            total += array[i];
        }
        ClosestMinDistrubtion minDistrubtion = new ClosestMinDistrubtion();
        minDistrubtion.value = array;
        minDistrubtion.total = total;
        minDistrubtion.initMemoSpace(total,n);
        long startTime=System.currentTimeMillis();
        int a = minDistrubtion.minGapDistrubution(0, 0);
        int b=minDistrubtion.recursiveWithMemo(0,0);
        int c=minDistrubtion.minGapDitributionWithDynamicProgram();
        int d=minDistrubtion.minGapDitributionDynamicWithSpaceOptime();
        long endTime=System.currentTimeMillis();
        ArrayUtils.displayArray(array);
        System.out.println(String.format("The min gap is,%d,%d,%d,%d ", a,b,c,d) );
        System.out.println("the narrow gap by myself think is "+minDistrubtion.stupidMinGapNarrowThink());

    }
}
