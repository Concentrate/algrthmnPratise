package com.com.ldy.java.common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackToQueue {

    Deque<Integer> readStack = new LinkedList<Integer>();

    Deque<Integer> writeList = new LinkedList<Integer>();


    public StackToQueue offer(int val) {
        writeList.push(val);
        return this;
    }

    public boolean hasNext() {
        return readStack.size() > 0 || !writeList.isEmpty();
    }

    public int poll() {
        if (readStack.isEmpty()) {
            while (!writeList.isEmpty()) {
                readStack.push(writeList.pop());
            }
        }

        return readStack.pop();
    }

    public static void main(String[] args) {

        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.offer(1).offer(2).offer(3).offer(4)
        .offer(7);
        while (stackToQueue.hasNext()) {
            System.out.println(stackToQueue.poll());
        }

    }
}
