package ThreadPratise;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by liudeyu on 2017/4/22.
 */
public class ReadWriteLockPartise {
    public static void main(String[] args) {
        ReadAndWriter runable = new ReadAndWriter();
        Thread r1 = new Thread(runable);
        Thread r2 = new Thread(runable);
       r1.start();
       r2.start();

    }
}

class ReadAndWriter implements Runnable {
    int data;
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public void setData(int a) {
        readWriteLock.writeLock().lock();
        try {
            Thread.sleep(200);
            data = a;
            System.out.println("success setting the data " + a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }

    public void readData() {
        readWriteLock.readLock().lock();
        try {
            Thread.sleep(200);
            System.out.println("read data is " + data);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000; i++) {
            setData(i);
            readData();
        }
    }
}