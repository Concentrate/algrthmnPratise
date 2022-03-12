package com.com.ldy.java.tmp;

import java.util.concurrent.*;

public class ProducerConsumer {


    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<>();


    public BlockingQueue<Integer> getQueue() {
        return queue;
    }


    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Producer producer = new Producer(producerConsumer.getQueue());
        Consumer consumer = new Consumer(producerConsumer.getQueue());
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 100000; i++) {

                    try {
                        producer.produceData(i);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                try {
                    int index=0;
                    while (index<10000){
                        int dataFetch = consumer.consumerData();
                        System.out.println("consume data  " + dataFetch);
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 3, 10000, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<>());
        threadPoolExecutor.execute(r1);
        threadPoolExecutor.execute(r2);
    }


}

class Producer {

    private BlockingQueue<Integer> queue;

    public Producer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public void produceData(int num) throws InterruptedException {
        boolean isOk = false;
        while (!isOk) {
            // blocking queue inner implement  signal wait and notify,easy way
            isOk = queue.offer(num, 1000, TimeUnit.MILLISECONDS);
        }
    }
}

class Consumer {
    private BlockingQueue<Integer> queue;

    public Consumer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }

    public int consumerData() throws InterruptedException {
        Integer result = null;
        while (result == null) {
            // blocking queue inner implement  signal wait and notify,easy way
            result = queue.poll(1000, TimeUnit.MILLISECONDS);
        }
        return result;
    }
}