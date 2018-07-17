package com.ldy.java.AlgrithmnPratise;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

/**
 * Created by liudeyu on 2017/4/2.
 */
public class BFSPratise {
    ArrayList<Integer>[]matrix;
    int minSteps;
    boolean[]record;
    public BFSPratise(int n) {

        matrix=new ArrayList[n];
        minSteps=Integer.MAX_VALUE;
        record=new boolean[n];
    }

    public int minStepGoThere(int start,int end){
        Queue<Integer> queue= new ArrayDeque<>();
        queue.offer(start);
        int index=0;
        while(!queue.isEmpty()){
            int top=queue.poll();
            record[top]=true;
            index++;
            if(top==end){
                break;
            }
            for(int i=0;i<matrix[top].size();i++){
                if(!record[matrix[top].get(i)]){
                    queue.offer(matrix[top].get(i));
                }
            }
        }
        return index;

    }


    public BFSPratise(ArrayList<Integer>[] matrix, int minSteps) {

        this.matrix = matrix;
        this.minSteps = minSteps;
    }

    public static void main(String[]args){

    }
}
