package com.com.ldy.java.ThreadPratise;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by liudeyu on 2017/9/4.
 */
public class VilotilePratise {
    volatile int number = 0;

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    public static void main(String[] argv) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 5, 4000,
                TimeUnit.MICROSECONDS, new ArrayBlockingQueue<Runnable>(5), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("current runnable r rejected");
            }
        });
        VilotilePratise pratise = new VilotilePratise();
        for (int i = 0; i < 100; i++) {
            if (i == 0) {
                threadPoolExecutor.submit(new SetThread(pratise));
            } else {
                threadPoolExecutor.submit(new ReadThread(pratise));
            }
        }
    }
}

class ReadThread implements Runnable {

    private VilotilePratise vilotilePratise;

    public ReadThread(VilotilePratise vilotilePratise) {
        this.vilotilePratise = vilotilePratise;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "   :" + vilotilePratise.getNumber());
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class SetThread implements Runnable {

    private VilotilePratise vilotilePratise;

    public SetThread(VilotilePratise vilotilePratise) {
        this.vilotilePratise = vilotilePratise;
    }

    @Override
    public void run() {
        while (true) {
            vilotilePratise.setNumber((int) (10000 * Math.random()));
        }
    }
}