package com.com.ldy.java.AlgrithmnPratise.dynamicProgram;

import com.com.ldy.java.Util.ArrayUtils;
import com.com.ldy.java.common.CollectionUtil;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: liudeyu
 * @date: 2020/12/2
 */
public class MinimunCoinChange {


    int minimunCount(int amout, int[] coins) {
        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amout <= 0) {
            return -1;
        }

        int[] memo = new int[amout + 1];
        List<Integer> changeCoins = new ArrayList<>();
        return toImplementChangeMoney(amout, coins, memo, changeCoins);
    }

    private int dpMiniMumChangeCount(int amount, int[] coins) {

        if (coins == null || coins.length == 0) {
            return -1;
        }
        if (amount <= 0) {
            return -1;
        }

        int[] changeCount = new int[amount + 1];
        for (int a1 = 0; a1 < changeCount.length; a1++) {
            changeCount[a1] = amount + 1;
        }
        changeCount[0] = 0;

        for (int i = 0; i < changeCount.length; i++) {

            for (int j = 0; j < coins.length; j++) {

                if (i < coins[j]) {
                    continue;
                }
                changeCount[i] = Math.min(changeCount[i], 1 + changeCount[i - coins[j]]);
            }
        }

        return changeCount[amount] == amount + 1 ? -1 : changeCount[amount];

    }

    private int toImplementChangeMoney(int amout, int[] coins, int[] memo, List<Integer> changeCoins) {

//        if (amout == 0) {
////            ArrayUtils.displayArray(changeCoins);
//        }
        if (amout <= 0) {
            changeCoins.clear();
            return 0;
        }

        if (memo[amout] != 0) {
            return memo[amout];
        }
        int result = amout + 1;
        for (int a1 = 0; a1 < coins.length; a1++) {
            changeCoins.add(coins[a1]);
            int changeCount = toImplementChangeMoney(amout - coins[a1], coins, memo, changeCoins);
            result = Math.min(result, changeCount + 1);
            changeCoins.remove((Integer) coins[a1]);
        }
        memo[amout] = result;
        return memo[amout];
    }


    public static void main(String[] args) {

        int[] coins = new int[]{1, 2, 5, 7};
        MinimunCoinChange minimunCoinChange = new MinimunCoinChange();
        System.out.println(/*minimunCoinChange.minimunCount(19993, coins) + */" " +
                minimunCoinChange.dpMiniMumChangeCount(19993, coins));
    }

}
