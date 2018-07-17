package com.ldy.java.OjPratise;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by liudeyu on 2017/8/26.
 */
public class TopK {
    public static void main(String[] argv) {
        Scanner scanner = null;
//        try {
//            scanner = new Scanner(new FileInputStream(ConstantsVariable.DATA_PATH));
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
        scanner = new Scanner(System.in);
        String first, second;
        first = scanner.nextLine();
        second = scanner.nextLine();
        String[] subArray = first.split("\\s");
        int k = Integer.parseInt(second);
        int[] rawData = new int[subArray.length];
        for (int i = 0; i < subArray.length; i++) {
            rawData[i] = Integer.parseInt(subArray[i]);
        }
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        int minData = Integer.MAX_VALUE;
        int index = 0;
        for (int i = 0; i < rawData.length; i++) {
            if (minData > rawData[i]) {
                minData = rawData[i];
                index = i;
            }
        }
        priorityQueue.add(minData);
        for (int i = 0; i < rawData.length; i++) {
            if (i == index) {
                continue;
            }
            if (priorityQueue.peek() != null && rawData[i] < priorityQueue.peek()) {
                continue;
            } else {
                if (priorityQueue.size() >= k) {
                    priorityQueue.poll();
                }
                priorityQueue.add(rawData[i]);
            }
        }
        System.out.println(priorityQueue.peek());
    }
}

