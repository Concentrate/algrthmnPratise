package com.com.ldy.java.common;

import java.util.*;

public class TencentPratise {

    long getContinueSum(int start, int end) {

        return (long) ((end - start + 1) * (start + end) * 1.0d / 2);


    }

    public Set<List<Integer>> subElementInRaw(int input) {

        if (input <= 1) {
            return new LinkedHashSet<>();
        }

        Set<List<Integer>> result = new LinkedHashSet<>();

        int smallOne = 1;
        int bigOne = 2;
//        int lastOne = input;
        while (smallOne < input / 2) {

            bigOne = input / 2;
            while (bigOne > smallOne) {


                long target = getContinueSum(smallOne, bigOne);
                if (target == input) {
//                    consturctToResult(result, smallOne, bigOne);
                    System.out.println(String.format("start is %s ,end is %s", smallOne, bigOne));
                    break;
                }
                bigOne--;

            }
            smallOne++;

        }

        return result;
    }


    public void printResultSet(Set<List<Integer>> result) {

        Iterator<List<Integer>> iterator = result.stream().iterator();
        while (iterator.hasNext()) {

            List<Integer> value = iterator.next();
            for (int i = 0; i < value.size(); i++) {
                System.out.print(value.get(i) + "   ");
            }
            System.out.println();
        }
    }


    private void consturctToResult(Set<List<Integer>> result, int smallOne, int tmp) {
        List<Integer> integerList = new ArrayList<>();
        System.out.println("******");
        for (int i = smallOne; i <= tmp; i++) {
//            integerList.add(i);
            System.out.print(i + "  ");
        }
//        result.add(integerList);
        System.out.println("#####");
    }

    public static void main(String[] args) {
        TencentPratise tencentPratise = new TencentPratise();
        Set<List<Integer>> result = tencentPratise.subElementInRaw(93299);
        tencentPratise.printResultSet(result);
    }
}
