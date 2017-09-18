package ThreadPratise.ProductAndConumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liudeyu on 2017/9/6.
 */
public class LockImplementModel {
    public static void main(String[] argv) {
        Stock stock = new Stock();
        Thread producter = new Thread(new Producer(stock));
        Thread consumer = new Thread(new Consumer(stock));
        Thread consumer2 = new Thread(new Consumer(stock));
        Thread produter2 = new Thread(new Producer(stock));
        producter.start();
        consumer.start();
        consumer2.start();
        produter2.start();
    }
}

class Stock {
    private int[] stocks;
    private final int CONST_SIZE = 10;
    private Lock lock = new ReentrantLock();
    private Condition empty = lock.newCondition();
    private Condition full = lock.newCondition();
    private int lastIndex = 0;

    public Stock() {
        stocks = new int[CONST_SIZE];
    }

    public void putElementInStocks(int t) {
        lock.lock();
        try {
            while (lastIndex >= CONST_SIZE) {
                full.await();
            }
            stocks[lastIndex++] = t;
            empty.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public int takeElementInStocks() {
        int element = 0;
        lock.lock();
        try {
            while (lastIndex <= 0) {
                empty.await();
            }
            element = stocks[--lastIndex];
            full.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
        return element;
    }
}

class Producer implements Runnable {
    Stock stock;

    public Producer(Stock stock) {
        this.stock = stock;
    }

    public void produce() {
        int index = 0;
        while (true) {
            stock.putElementInStocks(++index);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        produce();
    }
}

class Consumer implements Runnable {

    Stock stock;

    public Consumer(Stock stock) {
        this.stock = stock;
    }

    public void consume() {
        while (true) {
            int t = stock.takeElementInStocks();
            System.out.println("current thread:" + Thread.currentThread() + "   Consumer consume element is " + t);
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        consume();
    }
}