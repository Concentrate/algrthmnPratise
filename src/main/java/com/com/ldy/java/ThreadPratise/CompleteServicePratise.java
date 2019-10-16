package com.com.ldy.java.ThreadPratise;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by liudeyu on 2017/4/22.
 */
public class CompleteServicePratise {
    private static class NormalCallable implements Callable<Integer>{

        int i;

        public NormalCallable(int i) {
            this.i = i;
        }


        @Override
        public Integer call() throws Exception {
            Thread.sleep((long) (2000*Math.random()));
            System.out.println(Thread.currentThread().getName()+" are done ");
            return i;
        }
    }

    public static void main(String[]args){
        CompletionService<Integer>completionService=new ExecutorCompletionService<Integer>(Executors.newCachedThreadPool());
        int N = 10;
        for(int i = 1; i<= N; i++){
            completionService.submit(new NormalCallable(i));

        }
        for(int i = 1; i<= N; i++){
            try {
                System.out.println("return thread num is "+completionService.take().get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }

    }
}
