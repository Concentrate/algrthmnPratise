package com.com.ldy.java.ThreadPratise;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liudeyu on 2018/5/17.
 */
public class SynchroTest1 {
    public static void main(String[] argv) {
        ExecutorService pool = Executors.newFixedThreadPool(4);
        WaitSomething a1 = new WaitSomething();
        for (int i = 0; i < 4; i++) {
            pool.submit(new TmpThread(a1));
        }
        while (!pool.isTerminated()){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main thread done");
    }


    static class TmpThread implements Runnable {

        private WaitSomething something;

        public TmpThread(WaitSomething something) {
            this.something = something;
        }

        @Override
        public void run() {
            something.waitAndIncrement();
            something.getCountAndSay();
        }

    }

    static class WaitSomething {
        private int count = 0;
        private ReentrantReadWriteLock readLock = new ReentrantReadWriteLock(false);

        public void waitAndIncrement() {
            try {
                readLock.writeLock().lock();
                System.out.println("hello,this is the world");
                count++;
                Thread.sleep(3 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.writeLock().unlock();
            }
        }


        public void getCountAndSay() {
            readLock.readLock().lock();
            System.out.println("the count num is " + count);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            readLock.readLock().unlock();
        }
    }
}
