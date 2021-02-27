package com.com.ldy.java.common;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class StackToQueue {

    Deque<Integer> readStack=new LinkedList<Integer>();

    Deque<Integer> writeList=new LinkedList<Integer>();




    public void offer(int val){
        writeList.push(val);
    }
    public  int poll(){
        if(readStack.isEmpty()){
            while (!writeList.isEmpty()){
                readStack.push(writeList.pop());
            }
        }

        return readStack.pop();
    }

    public static void main(String[] args) {




    }
}
