package com.ldy.java.ThreadPratise;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created by liudeyu on 2017/4/22.
 */
public class SemaphorePratise {
    public static void main(String[]args){
        ExecutorService service= Executors.newCachedThreadPool();
        Semaphore semaphore=new Semaphore(5,true);
        for(int i=0;i<20;i++){
            service.submit(new MyRunnable(i,semaphore));
        }


    }
}
class MyRunnable implements Runnable{
    int i;
    Semaphore semaphore;

    public MyRunnable(int i, Semaphore sime) {
        this.i = i;
        semaphore=sime;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            System.out.println(i+" is having the semaphore now ");
            Thread.sleep((long) (2000*Math.random()));
            semaphore.release();
            System.out.println("now the semaphore are aviable is "+semaphore.availablePermits());

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
