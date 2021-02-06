package com.com.ldy.java.concurrentPratise;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AboutLockThinkDeeper {

    public static class UnHoldLockTestRelease implements Runnable {

        private Lock lock;
        private long sleepTime;
        private Condition condition;

        public UnHoldLockTestRelease(Lock lock, long sleepTime, Condition condition) {
            this.lock = lock;
            this.sleepTime = sleepTime;
            this.condition = condition;
        }

        @Override
        public void run() {

            lock.lock();
            try {
                Thread.sleep(sleepTime);
                System.out.println(String.format("release current lock , %s", Thread.currentThread()
                ));
                condition.await();
                Thread.sleep(sleepTime);
                condition.signal();

            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }


    public static void main(String[] args) {
        Lock lock = new ReentrantLock(false);
        Condition condition = lock.newCondition();
        Thread thread1 = new Thread(new UnHoldLockTestRelease(lock, 200L, condition), "thread1");
        Thread thread2 = new Thread(new UnHoldLockTestRelease(lock, 400L, condition), "thread2");
        thread1.start();
        thread2.start();

        new Thread(() -> {
            lock.lock();
            try {
                System.out.println("release");
                condition.signal();
            } finally {
                lock.unlock();
            }
        }).start();

    }
}
