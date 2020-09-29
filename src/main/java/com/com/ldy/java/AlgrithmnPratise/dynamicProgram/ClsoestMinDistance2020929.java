package com.com.ldy.java.AlgrithmnPratise.dynamicProgram;

/**
 * @author: liudeyu
 * @date: 2020/9/29
 */

import com.com.ldy.java.common.CollectionUtil;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 临接上一个closest min 问题,2020 年基于自己的思考结果
 */
public class ClsoestMinDistance2020929 {


    int getSum(int[] coins, int index) {

        if (index >= coins.length) {
            return 0;
        }
        return coins[index] + getSum(coins, index + 1);
    }

    int findMinClosestDitribution(int[] coins) {
        if (coins == null || coins.length == 0) {
            return 0;
        }

        int[] records = new int[coins.length + 1];

        int coinSum = getSum(coins, 0);
        Map<Integer, Integer> assigOneCoin = new HashMap<>();

        for (int i = 1; i < records.length; i++) {
            if (Math.abs(coinSum - 2 * records[i - 1]) < Math.abs(coinSum - 2 * (records[i - 1] + coins[i - 1]))) {
                records[i] = records[i - 1];
            } else {
                records[i] = records[i - 1] + coins[i - 1];
                assigOneCoin.put(i - 1, coins[i - 1]);
            }
        }
        System.out.println("give one person coin is ,two people ,one is A ,another is B");
        System.out.println("A: ");
        for (int a1 = 0; a1 < coins.length; a1++) {
            if (assigOneCoin.get(a1) != null) {
                System.out.print(assigOneCoin.get(a1) + " ");
            }
        }

        System.out.println();
        System.out.println("B: ");
        for (int a1 = 0; a1 < coins.length; a1++) {
            if (assigOneCoin.get(a1) == null) {
                System.out.print(coins[a1] + " ");
            }
        }
        System.out.println();
        return Math.abs(coinSum - 2 * records[coins.length]);
    }


    public static void main(String[] args) {
        int[] coin = {2, 343, 2, 32, 334, 33, 55, 25, 2, 135};
        ClsoestMinDistance2020929 minDistance2020929 = new ClsoestMinDistance2020929();
        System.out.println(minDistance2020929.findMinClosestDitribution(coin));


        System.out.println("old solve problem algrthmn ");
        ClosestMinDistrubtion closestMinDistrubtion = new ClosestMinDistrubtion();
        closestMinDistrubtion.value = coin;
        closestMinDistrubtion.total = minDistance2020929.getSum(coin, 0);
        closestMinDistrubtion.initMemoSpace(closestMinDistrubtion.total, coin.length);
        int a = closestMinDistrubtion.minGapDistrubution(0, 0);
        int b = closestMinDistrubtion.recursiveWithMemo(0, 0);
        int c = closestMinDistrubtion.minGapDitributionWithDynamicProgram();
        int d = closestMinDistrubtion.minGapDitributionDynamicWithSpaceOptime();
        System.out.println(String.format("%d, %d ,%d,%d", a, b, c, d));
    }
}
