package com.com.ldy.java.ThreadPratise;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by liudeyu on 2017/3/1.
 */
public class ThreadOne {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(4);
        List<Future<String>> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            Future<String> stringFuture = service.submit(new GetString(i));
            list.add(stringFuture);
        }
        for(int i=0;i<4;i++){
            try {
                System.out.println(list.get(i).get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }

}

class GetString implements Callable<String> {
    private int id;

    public GetString(int id) {
        this.id = id;
    }

    @Override
    public String call() throws Exception {
        return Thread.currentThread().getName() + " and the thread id is " + id;
    }
}
