package com.com.ldy.java.common;

import java.util.*;
import java.util.stream.Collectors;

public class MrThird {


    public static class Pair {
        public int after;
        public int before;


    }

    Integer[] fromDfsTraver(int[][] matrix, int startLine, Set<Integer> travelEle) {


        boolean findOne = false;


        for (int a2 = 0; a2 < matrix.length; a2++) {

            if (matrix[startLine][a2] == 1) {
                findOne = true;
                travelEle.add(a2);
                Integer[] res = fromDfsTraver(matrix, a2, travelEle);
                if(res.length==matrix.length){
                    return res;
                }
                travelEle.remove(a2);
            }
        }

        if (!findOne) {
            Integer[] tmp = new Integer[travelEle.size()];
            travelEle.stream().collect(Collectors.toList()).toArray(tmp);
            return tmp;
        }

        return new Integer[]{};

    }


    Integer[] findFullClassSeq(int n, Pair[] beforeArray) {

        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[n];
        }

        for (int i = 0; i < beforeArray.length; i++) {
            Pair tmp = beforeArray[i];
            matrix[tmp.after][tmp.before] = 1;
        }

        for (int i = 0; i < beforeArray.length; i++) {
            Set<Integer> tmpSet = new LinkedHashSet<>();
            tmpSet.add(i);
            Integer[] tmpResult = fromDfsTraver(matrix, i, tmpSet);
            if (tmpResult.length == n) {
                return tmpResult;
            }
        }
        return new Integer[]{};
    }

    public static void main(String[] args) {


    }
}
