package com.com.ldy.java.AlgrithmnPratise.ArrayPratise;


/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），
 * 每段绳子的长度记为k[1],...,k[m]。请问k[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 */
public class CutRopeProblem {

    public int cutRope(int target) {
        if (target <= 0) {
            return 0;
        }

        double tmp = Math.sqrt(target);
        int ceilTmp = (int) Math.ceil(tmp);
        int result = 1;
        int perNum = (int) Math.ceil(target * 1.0f / ceilTmp);
        for (int i = 0; i < ceilTmp; i++) {
            if (i < ceilTmp - 1) {
                result = result * perNum;
                System.out.print("multiple  " + perNum + ",");
            } else {
                int aMult = perNum;
                if (perNum * ceilTmp != target) {
                    aMult = target - (perNum - 1) * ceilTmp;
                }
                System.out.println("multiple  " + aMult);

                result = result * aMult;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CutRopeProblem cutRopeProblem = new CutRopeProblem();
        System.out.println(cutRopeProblem.cutRope(15));
    }
}
