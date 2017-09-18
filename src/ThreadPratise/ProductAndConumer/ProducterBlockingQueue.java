package ThreadPratise.ProductAndConumer;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by liudeyu on 2017/9/6.
 */
public class ProducterBlockingQueue {
    public static void main(String[] argv) {
        StoreHouse storeHouse=new StoreHouse();
        Thread producter=new Thread(new Producer(storeHouse));
        Thread consumer=new Thread(new Consumer(storeHouse));
        Thread consumer2=new Thread(new Consumer(storeHouse));
        producter.start();
        consumer.start();
        consumer2.start();

    }

    static class StoreHouse {
        private final int CONST_SIZE = 10;
        private BlockingQueue<Integer> depot = new ArrayBlockingQueue<Integer>(CONST_SIZE);

        public void putElementInStore(int t) {
            boolean isSuccess = false;
            while (!isSuccess) {
                try {
                    isSuccess = depot.offer(t, 100, TimeUnit.MICROSECONDS);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        public int takeElementFromStore() {
            Integer result = null;
            try {
                while (result == null) {
                    result = depot.poll(100, TimeUnit.MICROSECONDS);
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return result;
        }
    }

    static class Producer implements Runnable {

        private StoreHouse storeHouse;

        public Producer(StoreHouse storeHouse) {
            this.storeHouse = storeHouse;
        }

        @Override
        public void run() {
            int index = 0;
            while (true) {
                storeHouse.putElementInStore(++index);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class Consumer implements Runnable {
        private StoreHouse storeHouse;

        public Consumer(StoreHouse storeHouse) {
            this.storeHouse = storeHouse;
        }

        @Override
        public void run() {
            while (true) {
                int t = storeHouse.takeElementFromStore();
                System.out.println(Thread.currentThread() + " take element is " + t);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
