package com.com.ldy.java.AlgrithmnPratise.letcode;

/**
 * @author: liudeyu
 * @date: 2020/11/2
 */


import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnel;
import com.google.common.hash.PrimitiveSink;

import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Set;

/**
 * 945. Minimum Increment to Make Array Unique
 * <p>
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 * <p>
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 */

public class MinimunIncrement {


    static interface MayContain {
        boolean contain(Integer num);

        void put(Integer num);

    }

    BloomFilterContain bloomFilterContain = new BloomFilterContain();
    SetContain setContain = new SetContain();

    static class BloomFilterContain implements MayContain {
        BloomFilter<Integer> bloomFilter;

        public BloomFilterContain() {
            bloomFilter = BloomFilter.create(new Funnel<Integer>() {
                @Override
                public void funnel(Integer from, PrimitiveSink into) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    byteArrayOutputStream.write(from);
                    into.putBytes(byteArrayOutputStream.toByteArray());
                }
            }, 100000, 0.01);
        }

        @Override
        public boolean contain(Integer num) {
            return bloomFilter.mightContain(num);
        }

        @Override
        public void put(Integer num) {
            bloomFilter.put(num);
        }
    }

    static class SetContain implements MayContain {

        Set<Integer> set = new HashSet<>();

        @Override
        public boolean contain(Integer num) {
            return set.contains(num);
        }

        @Override
        public void put(Integer num) {
            set.add(num);
        }
    }


    int miniMoveAction(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }


        int moveAction = 0;
        for (int a1 = 0; a1 < array.length; a1++) {
            int tmp = array[a1];
            while (bloomFilterContain.contain(tmp)) {
                tmp += 1;
                moveAction += 1;
            }
            bloomFilterContain.put(tmp);
        }

        return moveAction;
    }


    public static void main(String[] args) {
        MinimunIncrement minimunIncrement = new MinimunIncrement();
        int[] tmpArr = {3, 2, 1, 2, 1, 7};
        System.out.println(minimunIncrement.miniMoveAction(tmpArr));

    }

}
