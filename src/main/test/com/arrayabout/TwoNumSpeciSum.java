package com.arrayabout;

import com.google.common.hash.HashCode;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by liudeyu on 2019/10/14.
 */
public class TwoNumSpeciSum {

    private static class Pair {
        public int first;
        public int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }

//        @Override
//        public int hashCode() {
//            return HashCode.fromInt(first).hashCode() + HashCode.fromInt(second).hashCode();
//        }
//
//
//        @Override
//        public boolean equals(Object obj) {
//            if (!(obj instanceof Pair)) {
//                return false;
//            }
//            Pair others = (Pair) obj;
//            return first == others.first && second == others.second || second == others.first && first == others.second;
//        }
    }

    public static Set<Pair> specificTwoNumSum(int sum, int[] array) {
        CombineSortArray.sortArray(array);
        int start = 0, end = array.length - 1;
        Set<Pair> result = new TreeSet<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.first - o2.first;
            }
        });
        while (start < end) {
            if (array[start] + array[end] == sum) {
                result.add(new Pair(start, end));
                start++;
            } else if (array[start] + array[end] < sum) {
                start++;
            } else {
                end--;
            }
        }
        return result;
    }


    public static void main(String[] argv) {

        int length = 200;
        int tmpSum = (int) (length + length * 0.1);
        int[] randomA = CollectionUtil.randomCreateArray(length);
        Set<Pair> res = specificTwoNumSum(tmpSum, randomA);
        Iterator<Pair> keysIt = res.iterator();
        while (keysIt.hasNext()) {
            Pair value = keysIt.next();
            System.out.println(String.format("%d + %d = %d", value.first, value.second, tmpSum));
        }
        System.out.println("totol result count " + res.size());
    }
}
