package com.com.ldy.java.AlgrithmnPratise.dynamicProgram;


/**
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbingStairs {


    int getStairMethodCount(int n) {

        int[] memo = new int[n + 1];
        return toImplementGetStairMethodCount(n, memo);


    }

    long getStairMethodCount2(int n) {

        if (n <= 0) {
            return 0;
        }

        long[] result = new long[n + 1];

        result[0] = 0;
        result[1] = 1;
        result[2] = 2;

        for (int i = 3; i <= n; i++) {
            result[i] = result[i - 1] + result[i - 2];
        }

        return result[n];

    }

    private int toImplementGetStairMethodCount(int n, int[] memo) {

        if (n <= 0) {
            return 0;
        } else if (n <= 2) {
            memo[n] = n;
            return n;
        }

        if (memo[n] != 0) {
            return memo[n];
        }

        memo[n] = toImplementGetStairMethodCount(n - 1, memo)
                + toImplementGetStairMethodCount(n - 2, memo);

        return memo[n];

    }

    public static void main(String[] args) {

        ClimbingStairs climbingStairs = new ClimbingStairs();

        System.out.println(climbingStairs.getStairMethodCount(3));
        System.out.println(climbingStairs.getStairMethodCount(2));
        System.out.println(climbingStairs.getStairMethodCount(1222));
        System.out.println(climbingStairs.getStairMethodCount2(122222));

    }
}
