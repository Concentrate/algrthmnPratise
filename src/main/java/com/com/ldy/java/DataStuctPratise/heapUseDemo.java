package com.com.ldy.java.DataStuctPratise;

import java.util.*;

/**
 * Created by liudeyu on 2017/3/15.
 */
public class heapUseDemo {
    public static int N = 1000;

    public static void main(String[] args) {

        int []array=new int[N];
        for(int i=0;i<array.length;i++){
            array[i]=i+1;
        }
        while (true){
            Scanner scanner=new Scanner(System.in);
            int k=scanner.nextInt();
            int kthMinValue=findKMinValue(k,array);
            System.out.println("The k min value is "+kthMinValue);
        }

    }

    private static int findKMinValue(int k,int []array) {
        MaxHeap maxHeap=new MaxHeap();
        for(int i=0;i<k;i++){
            maxHeap.insertElement(array[i]);
        }
        for(int j=k;j<array.length;j++){
            if(array[j]>maxHeap.top()){
                maxHeap.pop();
                maxHeap.insertElement(array[j]);
            }
        }
        return maxHeap.top();
    }

    private static void displayArray(int[] sortedArray) {
        for (int e : sortedArray) {
            System.out.print(e + " ");
        }
        System.out.println("");
    }
}

class MaxHeap {
    List<Integer> array;
    int size;

    public MaxHeap() {
        array = new ArrayList<>();
        array.add(Integer.MIN_VALUE); // invailed value
        size = 0;
    }

    public void disPlayHeap() {
        for (int a : array) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    /**
     * 1<=index<=array.length
     */
    private void upHeapfiy(int index) {
        if (index <= 1 || index > size) {
            return;
        }
        int element = array.get(index);
        if (element > array.get(index / 2)) {
            mySwap(index, index / 2);
            upHeapfiy(index / 2);
        }
    }

    private void downHeapFiy(int index) {
        if (index > size / 2 || index <= 0) {
            return;
        }
        int leftIndex = index * 2, rightIndex = index * 2 + 1;
        int theMaxOne = array.get(index);
        int theMaxIndex = -1;
        if (leftIndex <= size && array.get(leftIndex) > theMaxOne) {
            theMaxOne = array.get(leftIndex);
            theMaxIndex = leftIndex;
        }
        if (rightIndex <= size && array.get(rightIndex) > theMaxOne) {
            theMaxOne = array.get(rightIndex);
            theMaxIndex = rightIndex;
        }
        if (theMaxOne != array.get(index)) {
            mySwap(index, theMaxIndex);
            downHeapFiy(theMaxIndex);
        }
    }

    public void insertElement(int value) {
        array.add(value);
        size++;
        upHeapfiy(size);
    }

    public int top() {
        if (size >= 1) {
            return array.get(1);
        }
        return 0;
    }

    public int pop() {
        int t = top();
        mySwap(1, size);
        size--;
        downHeapFiy(1);
        return t;
    }

    public int[] heapSort() {
        List<Integer> tmpArray = new ArrayList<>();
        tmpArray.addAll(array);
        int[] result = new int[size];
        for (int i = 0; i < result.length; i++) {
            result[result.length - 1 - i] = pop();
        }
//        /*这里检验控制，所以用了较低效的又一次取值*/
//        for (int i = 0; i < result.length; i++) {
//            result[i] = array.get(i + 1);
//        }
        array = tmpArray;
        return result;
    }

    private void mySwap(int index, int i) {
        int tmp = array.get(index);
        array.set(index, array.get(i));
        array.set(i, tmp);
    }
}