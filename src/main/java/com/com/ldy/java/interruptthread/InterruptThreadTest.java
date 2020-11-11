package com.com.ldy.java.interruptthread;

import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.MergeKSortLinkedList;
import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.NodeUtils;
import com.com.ldy.java.AlgrithmnPratise.DataStuctPratise.linkedlist.intNode.Node;

import java.util.concurrent.*;

/**
 * @author: liudeyu
 * @date: 2020/11/11
 */
public class InterruptThreadTest {

    ExecutorService executor = Executors.newFixedThreadPool(4);

    public static class AThread implements Callable<Integer> {


        @Override
        public Integer call() throws Exception {
            int index = -1;
            int reverCount = 1000000;

            // isinterrupted 判断才能生效
            while (index < 1000/* && !Thread.currentThread().isInterrupted()*/) {
                index++;
                System.out.println(index);
//                Thread.sleep(1000);

                Node tmpList = NodeUtils.createRandomeIntList(reverCount, true);
                Node tmpList2 = NodeUtils.createRandomeIntList(reverCount, true);

                MergeKSortLinkedList mergeKSortLinkedList = new MergeKSortLinkedList();
                mergeKSortLinkedList.mergeKLinkedList(new Node[]{tmpList, tmpList2});
            }
            System.out.println("being interupt");
            return 1;
        }
    }

    public static void main(String[] args) throws InterruptedException {

        InterruptThreadTest interruptThreadTest = new InterruptThreadTest();
        Future<Integer> future = interruptThreadTest.executor.submit(new AThread());
        Thread.sleep(5000);
        future.cancel(true);
        System.out.println("cancel done");
//        interruptThreadTest.executor.shutdown();
//        try {
//            Integer tmpRes = future.get(300, TimeUnit.MICROSECONDS);
//
//            System.out.println(tmpRes);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        } catch (TimeoutException e) {
//            e.printStackTrace();
//        }finally {
//            future.cancel(true);
//        }
    }
}
