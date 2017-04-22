package ThreadPratise;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Created by liudeyu on 2017/4/22.
 */
public class ProducerAndCustomModelWithDepot {
    public static void main(String[] args) {

    }
}

class Despot {
    List<Object> list;
    int maxSize;

    public Despot() {
        list = new LinkedList<>();
        maxSize = 100;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public void produce(int num) {
        synchronized (list) {
            if (list.size() + num > maxSize) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }
            list.notifyAll();
        }
    }

    public void consume(int num) {
        synchronized (list) {
            if (list.size() < num) {
                try {
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0; i < num; i++) {
                list.remove(i);
            }
            list.notifyAll();
        }
    }
}
// 其他的与上一个差不多，缩略