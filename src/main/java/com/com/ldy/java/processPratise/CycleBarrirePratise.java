package com.com.ldy.java.processPratise;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by liudeyu on 2017/3/13.
 */
public class CycleBarrirePratise {

    public static void main(String[]args){
        CyclicBarrier barrier=new CyclicBarrier(4, new Runnable() {
            @Override
            public void run() {
                System.out.println("所有线程执行完毕");
            }
        });
        for(int i=0;i<4;i++){
            if(i<3){
                new Thread(new MyRunnable(barrier)).start();
            }else{
                Thread thread=  new Thread(new MyRunnable(barrier));
                try {
                    Thread.sleep(7000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
              thread.start();
            }
        }
        for(int i=0;i<4;i++){
            new Thread(new MyRunnable(barrier)).start();
        }
        System.out.println("回收利用完毕");

    }
}
class MyRunnable implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public MyRunnable(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"正在写入数据");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            cyclicBarrier.await(2000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
            System.out.println(Thread.currentThread().getName()+" wait to long and execture next");

        } catch (TimeoutException e) {
//            e.printStackTrace();
            System.out.println(Thread.currentThread().getName()+" wait to long and execture next");
        }
        System.out.println(Thread.currentThread().getName()+"所有线程写入数据完毕");

    }
}
