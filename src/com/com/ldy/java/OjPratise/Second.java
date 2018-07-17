package com.ldy.java.OjPratise;

import java.util.*;

/**
 * Created by liudeyu on 2017/8/12.
 */
public class Second {
    public static void main(String[] argv) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int[] array = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = scanner.nextInt();
        }
        LinkedList<Integer> linkedList = new LinkedList<>();
        boolean isHead = false;
        for (int i = 0; i < number; i++) {
            if (isHead) {
                linkedList.addFirst(array[i]);
            } else {
                linkedList.addLast(array[i]);
            }
            isHead = !isHead;
        }
        boolean isStart = true;
        Iterator<Integer> start = linkedList.iterator();
        if (number % 2 == 1) {
            start = linkedList.descendingIterator();
        }
        while (start.hasNext()) {
            if (isStart) {
                isStart = false;
                System.out.print(start.next());
            } else {
                System.out.print(" " + start.next());
            }
        }
    }
}
