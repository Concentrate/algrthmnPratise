package com.ldy.java.ThreadPratise;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by liudeyu on 2017/4/22.
 */
public class CustomerAndProducerModel {

    public static void main(String[] args) {
        List<Integer>list=new LinkedList<>();
        int maxStorgeSize=100;

        Producer producer=new Producer(list,maxStorgeSize);
        Customer customer=new Customer(list,maxStorgeSize);
//        producer.setNum(3);
        customer.setEveryTimeConsume(1);
        ExecutorService executorService= Executors.newCachedThreadPool();
        executorService.submit(producer);
        executorService.submit(customer);
        executorService.shutdown();



    }
}

class Producer implements Runnable {

    List<Integer> list;
    int num; // 每次生产商品的数量
    int maxSize; // 仓库的最大数量

    public Producer(List<Integer> list, int maxSize) {
        this.list = list;
        num = 1;
        this.maxSize = maxSize;
    }

    public void setNum(int num) {
        this.num = num;
    }


    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                if (num + list.size() > maxSize) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for (int i = 0; i < num; i++) {
                    list.add(i);
                }
                list.notifyAll();
                System.out.println("生产商品中 ,现在仓库里面有商品个数为 " + list.size());
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
class Customer implements Runnable{

    List<Integer>list;
    int maxSize;
    int everyTimeConsume;

    public Customer(List<Integer> list, int maxSize) {
        this.list = list;
        this.maxSize = maxSize;
        everyTimeConsume=1;
    }

    public void setEveryTimeConsume(int everyTimeConsume) {
        this.everyTimeConsume = everyTimeConsume;
    }

    @Override
    public void run() {
        while (true){
            synchronized (list){
                if(everyTimeConsume>list.size()){
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                for(int i=0;i<everyTimeConsume;i++){
                    list.remove(i);
                }
                list.notifyAll();
                System.out.println(String.format("消费商品中， 现在仓库里面有 %d 个商品",list.size()));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    }
}