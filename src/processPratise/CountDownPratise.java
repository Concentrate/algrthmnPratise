package processPratise;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.RunnableFuture;

/**
 * Created by liudeyu on 2017/3/13.
 */
public class CountDownPratise {
    private  static CountDownLatch downLatch;
    public static void main(String[]args){
        downLatch=new CountDownLatch(2);
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" is execute ");
                try {
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName()+" is execute done ");
                    downLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" is execute ");
                try {
                    Thread.sleep(200);
                    System.out.println(Thread.currentThread().getName()+" is execute done ");
                    downLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println("在主线程execute");
        try {
            downLatch.await();
            System.out.println("两个线程执行完毕");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
