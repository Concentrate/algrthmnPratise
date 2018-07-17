package com.ldy.java.processPratise;

import java.util.concurrent.Semaphore;

/**
 * Created by liudeyu on 2017/3/13.
 */
public class SemaphorePratise {

    public static void main(String[] args) {
        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < N; i++) {
                new Thread(new My1Runnable(semaphore)).start();
        }
    }
}
class My1Runnable implements Runnable{

    private Semaphore semaphore;

    public My1Runnable(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"正在进行执行");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread()+"进行释放");
        semaphore.release();
    }
}