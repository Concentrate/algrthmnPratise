package com.ldy.java.ThreadPratise;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by liudeyu on 2017/4/22.
 */
public class ProducerAndCustomerModelWithLock {
    public static void main(String[] args) {
        Storage storage=new Storage();
        AProducer producer=new AProducer(storage);
        ACustomer aCustomer=new ACustomer(storage);
        ExecutorService service= Executors.newCachedThreadPool();
        service.submit(producer);
        service.submit(aCustomer);
    }
}

class Storage {
    List<Integer> list;
    int maxSize;
    private Lock lock=new ReentrantLock();
    private Condition fullCondition=lock.newCondition();
    private Condition emptyCondiction=lock.newCondition();

    public Storage() {
        list=new LinkedList<>();
        maxSize=100;
    }
    public void produce(int num){
        lock.lock();
        if(list.size()+num>maxSize){
            try {
                fullCondition.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<num;i++){
            list.add(i);
        }
        System.out.println("生产中 ，总共商品个数为 "+list.size());
        emptyCondiction.signalAll();
        fullCondition.signalAll();
        lock.unlock();
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }
    public void consume(int num){
        lock.lock();
        if(list.size()<num){
            try {
                emptyCondiction.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        for(int i=0;i<num;i++){
            list.remove(i);
        }
        System.out.println("消费中， 总共商品个数为 "+list.size());
        fullCondition.signalAll();
        emptyCondiction.signalAll();
        lock.unlock();
    }
}

class AProducer implements Runnable{
    Storage storage;

    public AProducer(Storage storage) {
        this.storage = storage;
    }
    public void prodcue(int num){
        storage.produce(num);
    }

    @Override
    public void run() {
        for(int i=1;i<100;i++){
            prodcue(i);
        }

    }
}
class ACustomer implements Runnable{
    Storage storage;

    public ACustomer(Storage storage) {
        this.storage = storage;
    }
    public void consume(int num){
        storage.consume(num );
    }

    @Override
    public void run() {
      for(int i=1;i<100;i++){
          consume(i);
      }
    }
}

